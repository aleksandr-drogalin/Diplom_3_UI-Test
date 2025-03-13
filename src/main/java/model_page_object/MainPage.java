package model_page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Личный кабинет"
    private By buttonPersonalRoom = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка "Войти в аккаунт"
    private By buttonLogInAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка оформить заказ
    private By buttonPlaceNewOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    //заголовок "Соберите бургер"
    private By сonstructorTitle = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10' and text()='Соберите бургер']");
    //кнопка "Соусы"
    private By buttonSauce = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    //изображение соуса "Spicy-X"
    private By imageSauceSpicyX = By.xpath(".//img[@alt='Соус Spicy-X']");
    //кнопка "Начинки"
    private By buttonFilling = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    //изображение начинки "мясо бессмертных моллюсков"
    private By imageFillingMeatNotDeathShellfish = By.xpath(".//img[@alt='Мясо бессмертных моллюсков Protostomia']");
    //кнопка "Булки"
    private By buttonBun = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    //изображение булки "Флюоресцентная булка R2-D3"
    private By imageFluoriscentBun = By.xpath(".//img[@alt='Флюоресцентная булка R2-D3']");

    @Step("клик на кнопку \"Личный кабинет\"")
    public void clickOnButtonPersonalRoom() {
        driver.findElement(buttonPersonalRoom).click();
    }

    @Step("клик на кнопку \"Войти в аккаунт\"")
    public void clickOnButtonLogInAccount() {
        driver.findElement(buttonLogInAccount).click();
    }

    @Step("проверка отображения кнопки \"Оформить заказ\" при успешной авторизации")
    public boolean buttonPlaceNewOrderIsDisplayed() {
       new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(buttonPlaceNewOrder));
       return driver.findElement(buttonPlaceNewOrder).isDisplayed();
    }

    @Step("проверка отображения заголовка конструктора")
    public boolean constructorIsDisplayed() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(сonstructorTitle));
        return driver.findElement(сonstructorTitle).isDisplayed();
    }

    @Step("клик на кнопку \"Соусы\"")
    public void clickOnButtonSauce() {
        driver.findElement(buttonSauce).click();
    }

    @Step("проверка отображения элемента раздела \"Соусы\"")
    public boolean sauceIsDisplayed() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(imageSauceSpicyX));
        //прокрутка до элемента
        WebElement elementSauce =driver.findElement(imageSauceSpicyX);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",elementSauce);
        // координаты и размеры элемента
        Rectangle rect = elementSauce.getRect();
        // размеры окна браузера
        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();
        // проверка, что элемент полностью находится в пределах окна
        return rect.getX() >= 0
                && rect.getY() >= 0
                && rect.getX() + rect.getWidth() <= windowWidth
                && rect.getY() + rect.getHeight() <= windowHeight;
    }

    @Step("клик на кнопку \"Начинки\"")
    public void clickOnButtonFilling() {
        driver.findElement(buttonFilling).click();
    }

    @Step("проверка отображения элемента раздела \"Начинки\"")
    public boolean fillingIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(imageFillingMeatNotDeathShellfish));
        //прокрутка до элемента
        WebElement elementFilling =driver.findElement(imageFillingMeatNotDeathShellfish);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",elementFilling);
        // координаты и размеры элемента
        Rectangle rect = elementFilling.getRect();
        // размеры окна браузера
        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();
        // проверка, что элемент полностью находится в пределах окна
        return rect.getX() >= 0
                && rect.getY() >= 0
                && rect.getX() + rect.getWidth() <= windowWidth
                && rect.getY() + rect.getHeight() <= windowHeight;
    }
    @Step("клик на кнопку \"Булки\"")
    public void clickOnButtonBun() {
        driver.findElement(buttonBun).click();
    }

    @Step("проверка отображения элемента раздела \"Булки\"")
    public boolean bunIsDisplayed() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(imageFluoriscentBun));
        //прокрутка до элемента
        WebElement elementBun =driver.findElement(imageFluoriscentBun);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",elementBun);
        // координаты и размеры элемента
        Rectangle rect = elementBun.getRect();
        // размеры окна браузера
        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();
        // проверка, что элемент полностью находится в пределах окна
        return rect.getX() >= 0
                && rect.getY() >= 0
                && rect.getX() + rect.getWidth() <= windowWidth
                && rect.getY() + rect.getHeight() <= windowHeight;
    }
}