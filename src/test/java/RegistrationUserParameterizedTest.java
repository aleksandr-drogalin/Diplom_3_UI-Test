import io.qameta.allure.junit4.DisplayName;
import model_page_object.MainPage;
import model_page_object.PageAuthorization;
import model_page_object.PageRegistration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import support.InitialData;

@RunWith(Parameterized.class)
public class RegistrationUserParameterizedTest {

    private static WebDriver driver;

    //поля с тестовыми данными
    private final String password;
    private final boolean isVisibleErrorMessage;
    private final String testName;

    //конструктор класса
    public RegistrationUserParameterizedTest(String password, boolean isVisibleErrorMessage, String testName) {
        this.password = password;
        this.isVisibleErrorMessage = isVisibleErrorMessage;
        this.testName = testName;
    }

    //тестовые данные
    @Parameterized.Parameters (name = "{2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"qw", true, "2 символа в пароле"},
                {"qwe1", true, "4 символа в пароле"},
                {"qwe12", true, "5 символов в пароле"}
        };
    }

    @Before
    public void setUp() {
        driver = Browser.getWebDriver(InitialData.BROWSER_NAME);
    }

    @Test
    @DisplayName("регистрация нового пользователя с некорректным паролем")
    public void registrationUserWithUncorrectPassword() {
        driver.get(InitialData.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        PageAuthorization pageAuthorization = new PageAuthorization(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);

        mainPage.clickOnButtonLogInAccount(); //переход на форму авторизации по кнопке "Войти в аккаунт"
        pageAuthorization.clickOnButtonRegister(); //клик на кнопку "Зарегистрироваться" на сранице авторизации
        pageRegistration.inputUserName(InitialData.REGISTRATION_NAME); //заполнение имени
        pageRegistration.inputPassword(password); //заполнение пароля
        pageRegistration.clickOnFieldEmail(); //клик на поле email пользователя
        boolean actualResult = pageRegistration.checkMessageErrorPassword();

        Assert.assertEquals("ошибка верификации пароля", isVisibleErrorMessage, actualResult);
    }

    @After
    public void tearDown() {
        driver.quit(); //закрытие браузера
        }
}