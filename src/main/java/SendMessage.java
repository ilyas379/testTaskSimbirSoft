import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendMessage {

    private static final Logger logger = LogManager.getLogger(SendMessage.class);

    private static final String WRITE_BUTTON = "T-I-KE";
    private static final String RECIPIENT = "vO";
    private static final String THEME_MESSAGE = "aoT";
    private static final String BODY_MESSAGE = "//*[contains(@class, 'Am')]";
    private static final String SEND_BUTTON = "//*[contains(@class, 'dC')]";
    private static final String CLOSE_BUTTON = "//*[@id=\"link_vsm\"]";

    private final WebDriver driver;
    public SendMessage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = WRITE_BUTTON)
    private WebElement writeButton;

    @FindBy(className = RECIPIENT)
    private WebElement sendWhom;

    @FindBy(className = THEME_MESSAGE)
    private WebElement sendTheme;

    @FindBy(xpath = BODY_MESSAGE)
    private WebElement sendBody;

    @FindBy(xpath = SEND_BUTTON)
    private WebElement sendButton;

    @FindBy(xpath = CLOSE_BUTTON)
    private WebElement closeButton;

    public void waitHideElement (By elementName) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(elementName));
    }

    @Step("Отправка сообщения на адрес {0}")
    public void sendMail(String address, String subject, String body) {
        logger.info("Нажатие кнопки \"Написать\"");
        writeButton.click();
        logger.info("Заполнение адреса: " + address);
        sendWhom.sendKeys(address);
        logger.info("Заполнение темы письма: " + subject);
        sendTheme.sendKeys(subject);
        logger.info("Заполнение тела письма: " + body);
        sendBody.sendKeys(body);
        logger.info("Отправка письма");
        sendButton.click();
        logger.info("Проверка отображения элемента");
        waitHideElement(By.xpath("SEND_BUTTON"));
        logger.info("Закрытие окна уведомления");
        closeButton.click();
    }
}


