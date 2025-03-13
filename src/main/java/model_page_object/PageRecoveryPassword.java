package model_page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRecoveryPassword {

    private WebDriver driver;

    public PageRecoveryPassword(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Войти"
    private By buttonLogin = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    @Step("клик на кнопку \"Войти\" на странице восстановления пароля")
    public void clickOnButtonEnter() {
        driver.findElement(buttonLogin).click();
    }
}