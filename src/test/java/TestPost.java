import DataProviderProperty.DataProviderUserProperty;
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

    private String login;
    private String password;
    private String messageSubject;
    private String messageBody;

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

        messageSubject = propertyUserValues.getMessageSubject();
        messageBody = propertyUserValues.getMessageBody();
    }

    @Test
    public void testSendPost() {
        GoogleAuth googleAuth = PageFactory.initElements(driver, GoogleAuth.class);
        googleAuth.authorization(login, password);

        GooglePost googlePost = PageFactory.initElements(driver, GooglePost.class);
        int countMessages = googlePost.getMessagesCount();

        SendMessage sendMessage = PageFactory.initElements(driver, SendMessage.class);
        sendMessage.sendMail(login, messageSubject, messageBody + countMessages);
    }

    @AfterTest
    public void afterTestMethod() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}
