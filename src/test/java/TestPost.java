import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestPost {

    private static final Logger logger = LogManager.getLogger(TestPost.class);

    static {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
    }

    private WebDriver driver;
    private String mailUrl;
    private String login;
    private String password;

    @BeforeTest
    public void beforeTestMethod() throws IOException {
        logger.info("Подготовка тестового окружения");
        driver = RemoteWebDriver.builder()
                .addAlternative(new ChromeOptions())
                .build();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DataProviderUserProperty propertyUserValues = new DataProviderUserProperty();
        propertyUserValues.getPropValues();
        login = propertyUserValues.getUserName();
        password = propertyUserValues.getPassword();

        mailUrl = "https://mail.google.com";
    }

    @Test()
    public void testSendPost() {
        GoogleAuth googleAuth = GoogleAuth.getInstance(driver, mailUrl);
        googleAuth.authorization(login, password);

        GooglePost googlePost = PageFactory.initElements(driver, GooglePost.class);
        long countMessages = googlePost.getMessagesCount("Simbirsoft Тестовое задание");

        SendMessage sendMessage = SendMessage.getInstance(driver);
        sendMessage.sendMail(login, "SimbirSoft Тестовое задание. Герасимчук", "Найдено сообщений: " + countMessages);
    }

    @AfterTest
    public void afterTestMethod() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}
