package model_page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageRegistration {

    private WebDriver driver;

    public PageRegistration(WebDriver driver) {
        this.driver = driver;
    }

    //поле ввода имени пользователя
    private By fieldInputUserName = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']/following-sibling::input");
    //поле ввода email
    private By fieldInputEmail = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']/following-sibling::input");
    //поле ввода пароля
    private By fieldInputPassword = By.xpath(".//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']/following-sibling::input");
    //кнопка зарегистрироваться
    private By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");
    //сообщение о некорректном пароле
    private By messageErrorPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    //кнопка "Войти"
    private By buttonEnter = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    @Step("ввод имени пользователя при регистрации")
    public void inputUserName(String name) {
        driver.findElement(fieldInputUserName).sendKeys(name);
    }

    @Step("ввод email пользователя при регистрации")
    public void inputEmail(String email) {
        driver.findElement(fieldInputEmail).sendKeys(email);
    }

    @Step("ввод пароля пользователя при регистрации")
    public void inputPassword(String password) {
        driver.findElement(fieldInputPassword).sendKeys(password);
    }

    @Step("клик на кнопке \"Зарегистрироваться\" на странице регистрации")
    public void clickOnButtonRegister() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(buttonRegister));
        driver.findElement(buttonRegister).click();
    }

    @Step("проверка отображения сообщения о некорректном пароле")
    public boolean checkMessageErrorPassword() {
        return driver.findElement(messageErrorPassword).isDisplayed();
    }

    @Step("клик на поле email")
    public void clickOnFieldEmail() {
        driver.findElement(fieldInputEmail).click();
    }

    @Step("клик на кнопку \"Войти\" на странице регистрации")
    public void clickOnButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
}