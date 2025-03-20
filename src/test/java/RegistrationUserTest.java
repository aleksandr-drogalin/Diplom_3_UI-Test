import io.qameta.allure.junit4.DisplayName;
import model_page_object.MainPage;
import model_page_object.PageAuthorization;
import model_page_object.PageRegistration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import support.InitialData;

public class RegistrationUserTest {

    private ClientAPI clientAPI;
    private static WebDriver driver;

    @Before
    public void setUp() {
        clientAPI = new ClientAPI(); //инициализация клиента api
        driver = Browser.getWebDriver(InitialData.BROWSER_NAME); //инициализация вебдрайвера
    }

    @Test
    @DisplayName("успешная регистрация нового пользователя")
    public void successfulRegistrationUser() {
        driver.get(InitialData.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        PageAuthorization pageAuthorization = new PageAuthorization(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);

        mainPage.clickOnButtonLogInAccount(); //переход на форму авторизации по кнопке "Войти в аккаунт"
        pageAuthorization.clickOnButtonRegister(); //клик на кнопку "Зарегистрироваться" на сранице авторизации
        pageRegistration.inputUserName(InitialData.REGISTRATION_NAME); //заполнение имени
        pageRegistration.inputEmail(InitialData.REGISTRATION_EMAIL); //заполнение email
        pageRegistration.inputPassword(InitialData.REGISTRATION_PASSWORD); //заполнение пароля
        pageRegistration.clickOnButtonRegister(); //клик на кнопку "Зарегистрироваться" на странице регистрации
        boolean actualResult = pageAuthorization.checkButtonLoginIsDisplayed();

        Assert.assertTrue("ошибка регистрации нового пользователя", actualResult);
    }

    @After
    public void tearDown() {
        driver.quit(); //закрытие браузера
        clientAPI.deleteUser(InitialData.REGISTRATION_EMAIL, InitialData.REGISTRATION_PASSWORD); //удаление пользователя
    }
}