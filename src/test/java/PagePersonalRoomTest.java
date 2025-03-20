import io.qameta.allure.junit4.DisplayName;
import model_page_object.MainPage;
import model_page_object.PageAuthorization;
import model_page_object.PagePersonalRoom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import support.InitialData;

public class PagePersonalRoomTest {

    private ClientAPI clientAPI;
    private static WebDriver driver;

    private MainPage mainPage;
    private PagePersonalRoom pagePersonalRoom;
    private PageAuthorization pageAuthorization;

    @Before
    public void setUp() {
        clientAPI = new ClientAPI(); //инициализация клиента api
        clientAPI.createNewUser(InitialData.REGISTRATION_EMAIL, InitialData.REGISTRATION_PASSWORD, InitialData.REGISTRATION_NAME); //создание пользователя
        driver = Browser.getWebDriver(InitialData.BROWSER_NAME); //инициализация вебдрайвера

        //авторизация пользователя
        driver.get(InitialData.MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
        pageAuthorization = new PageAuthorization(driver);

        mainPage.clickOnButtonLogInAccount(); //переход на форму авторизации по кнопке "Войти в аккаунт"
        pageAuthorization.inputEmail(InitialData.REGISTRATION_EMAIL); //заполнение email
        pageAuthorization.inputPassword(InitialData.REGISTRATION_PASSWORD); //заполнение пароля
        pageAuthorization.clickOnButtonEnter(); //клик на кнопку "Войти"
    }

    @Test
    @DisplayName("переход в личный кабинет по клику на кнопку \"Личный кабинет\"")
    public void checkClickOnButtonPersonalRoom() {
        pagePersonalRoom = new PagePersonalRoom(driver);

        mainPage.clickOnButtonPersonalRoom(); //переход в личный кабинет по кнопке "Личный кабинет"
        String actualName = pagePersonalRoom.getFieldName(); //получить имя пользователя из формы
        String actualEmail = pagePersonalRoom.getFieldEmail(); //получить email пользователя из формы

        Assert.assertEquals("ошибка перехода в личный кабинет", InitialData.REGISTRATION_NAME, actualName); //проверка что поле Имя заполнено правильно
        Assert.assertEquals("ошибка перехода в личный кабинет",InitialData.REGISTRATION_EMAIL, actualEmail); //проверка что поле Email заполнено правильно
    }

    @Test
    @DisplayName("переход в конструктор по клику на кнопку \"Конструктор\"")
    public void checkClickToButtonConstructor() {
        pagePersonalRoom = new PagePersonalRoom(driver);

        mainPage.clickOnButtonPersonalRoom(); //переход в личный кабинет по кнопке "Личный кабинет"
        pagePersonalRoom.clickOnButtonConstructor(); //клик на кнопку "Конструктор"
        boolean isConstructor = mainPage.constructorIsDisplayed();

        Assert.assertTrue("ошибка перехода в конструктор", isConstructor);
    }

    @Test
    @DisplayName("переход в конструктор по клику на логотип stellar burgers")
    public void checkClickToLogo() {
        pagePersonalRoom = new PagePersonalRoom(driver);

        mainPage.clickOnButtonPersonalRoom(); //переход в личный кабинет по кнопке "Личный кабинет"
        pagePersonalRoom.clickOnLogo(); //клик на логотип Stellar Burgers
        boolean isConstructor = mainPage.constructorIsDisplayed();

        Assert.assertTrue("ошибка перехода в конструктор", isConstructor);
    }

    @Test
    @DisplayName("выход из личного кабинета по кнопке Выйти")
    public void checkExitFromPersonalRoom() {
        pagePersonalRoom = new PagePersonalRoom(driver);

        mainPage.clickOnButtonPersonalRoom(); //переход в личный кабинет по кнопке "Личный кабинет"
        pagePersonalRoom.clickOnExitFromPersonalRoom(); //клик на кнопку выхода из личного кабинета
        boolean isExitFromPersonalRoom = pageAuthorization.checkButtonLoginIsDisplayed();

        Assert.assertTrue("ошибка выхода из личного кабинета", isExitFromPersonalRoom);
    }

    @After
    public void tearDown() {
        driver.quit(); //закрыть браузер
        clientAPI.deleteUser(InitialData.REGISTRATION_EMAIL, InitialData.REGISTRATION_PASSWORD); //удаление пользователя
    }
}