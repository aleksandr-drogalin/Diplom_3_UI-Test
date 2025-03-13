import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    //выбор драйвера браузера по его названию
    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                return new ChromeDriver();
            case "Yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\droga\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            default: throw new RuntimeException("Введите значение константы BROWSER_NAME: Сhrome или Firefox");
        }
    }
}