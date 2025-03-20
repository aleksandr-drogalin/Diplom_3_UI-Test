package model_page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PagePersonalRoom {

    private WebDriver driver;

    public PagePersonalRoom(WebDriver driver) {
        this.driver = driver;
    }

    //поле с именем
    private By fieldName = By.xpath(".//input[@class='text input__textfield text_type_main-default input__textfield-disabled' and @name='Name']");
    //поле с Email
    private By fieldEmail = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_disabled']/input[@class='text input__textfield text_type_main-default input__textfield-disabled' and @name='name']");
    //кнопка "Конструктор"
    private By buttonConstructor = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    //логотип Stellar Burgers  в шапке
    private By logoInHeader = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //кнопка Выход
    private By buttonExit = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    @Step("получить содержимое поля \"Имя\"")
    public String getFieldName() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(fieldName).getAttribute("value");
    }

    @Step("получить содержимое поля \"Email\"")
    public String getFieldEmail() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.findElement(fieldEmail).getAttribute("value");
    }

    @Step("клик на кнопку конструктор")
    public void clickOnButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("клик на логотип Stellar Burgers")
    public void clickOnLogo() {
        driver.findElement(logoInHeader).click();
    }

    @Step("выйти из аккаунта")
    public void clickOnExitFromPersonalRoom() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(buttonExit));
        driver.findElement(buttonExit).click();
    }
};