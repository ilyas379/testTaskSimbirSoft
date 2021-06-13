import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPost {


    static {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
    }
    private static final Logger logger = LogManager.getLogger(TestPost.class);

    private WebDriver driver;

    private String login;
    private String password;
    private String messageSubject;
    private String messageBody;




    @BeforeTest
    public void beforeTestMethod() {
        logger.info("подготовка тестового окружения");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login = "autotestsimbir@gmail.com";
        password = "795880asDd";
        messageSubject = "SimbirSoft Тестовое задание. Герасимчук";
        messageBody = "Найдено сообщений: ";

    }

    @Test
    public void testSendPost() {
        GoogleAuth googleAuth = new GoogleAuth(driver);
        googleAuth.authorization(login, password);

        GooglePost googlePost = new GooglePost(driver);
        int countMessages = googlePost.getMessagesCount();

        SendMessage sendMessage = new SendMessage(driver);
        sendMessage.sendMail(login, messageSubject, messageBody + countMessages);
    }

    @AfterTest
    public void afterTestMethod(){
        logger.info("закрытие браузера");
        driver.quit();
    }

}
