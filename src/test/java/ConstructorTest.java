import io.qameta.allure.junit4.DisplayName;
import model_page_object.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import support.InitialData;

public class ConstructorTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = Browser.getWebDriver(InitialData.BROWSER_NAME); //инициализация вебдрайвера
    }

    @Test
    @DisplayName("проверка перехода в раздел \"Соусы\"")
    public void checkTransitionToSectionSauce() {
        driver.get(InitialData.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickOnButtonSauce(); //клик на кнопку "Соусы"
        boolean isSauce = mainPage.sauceIsDisplayed();

        Assert.assertTrue("ошибка перехода в раздел соусы", isSauce);
    }

    @Test
    @DisplayName("проверка перехода в раздел \"Начинки\"")
    public void checkTransitionToSectionFilling() {
        driver.get(InitialData.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickOnButtonFilling(); // клик на кнопку "Начинки"
        boolean isFilling = mainPage.fillingIsDisplayed();

        Assert.assertTrue("ошибка перехода в раздел начинки", isFilling);
    }

    @Test
    @DisplayName("проверка перехода в раздел \"Булки\"")
    public void checkTransitionToSectionBun() {
        driver.get(InitialData.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);

        mainPage.clickOnButtonSauce(); //клик на кнопку "Соусы"
        mainPage.clickOnButtonBun(); //клик на кнопку "Булки"
        boolean isBun = mainPage.bunIsDisplayed();

        Assert.assertTrue("ошибка перехода в раздел булки", isBun);
    }

    @After
    public void tearDown() {
        driver.quit(); //закрыть браузер
    }
}