package model_page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageAuthorization {

    private WebDriver driver;

    public PageAuthorization(WebDriver driver) {
        this.driver = driver;
    }

    //поле ввода email
    private By fieldInputEmail = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");
    //поле ввода пароля
    private By fieldInputPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    //кнопка "зарегистрироваться"
    private By buttonRegister = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    //кнопка "восстановить пароль"
    private By buttonRecoveryPassword = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    //кнопка "Войти"
    private By buttonLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");

    @Step("ввод email при входе в учетную запись")
    public void inputEmail(String email) {
        driver.findElement(fieldInputEmail).sendKeys(email);
    }

    @Step("ввод пароля при входе в учетную запись")
    public void inputPassword(String password) {
        driver.findElement(fieldInputPassword).sendKeys(password);
    }

    @Step("клик на кнопку \"Зарегистрироваться\" на странице входа")
    public void clickOnButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step("подтверждение нахождения на странице входа (отображается кнопка \"Войти\")")
    public boolean checkButtonLoginIsDisplayed() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return driver.findElement(buttonLogin).isDisplayed();
    }

    @Step("клик на кнопку \"Войти\" на странице входа")
    public void clickOnButtonEnter() {
        driver.findElement(buttonLogin).click();
    }

    @Step("клик на кнопку \"Воccтановить пароль\"")
    public void clickOnButtonRecoveryPassword() {
        driver.findElement(buttonRecoveryPassword).click();
    }
}