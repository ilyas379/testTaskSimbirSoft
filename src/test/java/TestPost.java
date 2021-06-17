import DataProviderProperty.DataProviderInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.Message;
import pojo.User;

import java.io.IOException;
import java.time.Duration;

public class TestPost {

    private static final Logger logger = LogManager.getLogger(TestPost.class);

    static {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
    }

    private WebDriver driver;

    @BeforeTest
    public void beforeTestMethod() {
        logger.info("Подготовка тестового окружения");
        driver = RemoteWebDriver.builder()
                .addAlternative(new ChromeOptions())
                .build();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviderInfo.class)
    public void testSendPost(User user, Message message) {
        GoogleAuth googleAuth = PageFactory.initElements(driver, GoogleAuth.class);
        googleAuth.authorization(user.getUserName(), user.getPassword());

        GooglePost googlePost = PageFactory.initElements(driver, GooglePost.class);
        long countMessages = googlePost.getMessagesCount(message.getMessageSearchText());

        SendMessage sendMessage = PageFactory.initElements(driver, SendMessage.class);
        sendMessage.sendMail(user.getUserName(), message.getSubject(), message.getMessageBody() + countMessages);
    }

    @AfterTest
    public void afterTestMethod() {
        logger.info("Закрытие браузера");
        driver.quit();
    }
}
