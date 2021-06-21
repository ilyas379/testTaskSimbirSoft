import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendMessage {

    private static final Logger logger = LogManager.getLogger(SendMessage.class);

    private final WebDriver driver;
    @FindBy(className = "T-I-KE")
    private WebElement writeButton;
    @FindBy(className = "vO")
    private WebElement sendWhom;
    @FindBy(className = "aoT")
    private WebElement sendTheme;
    @FindBy(xpath = "//*[contains(@class, 'Am')]")
    private WebElement sendBody;
    @FindBy(xpath = "//*[contains(@class, 'dC')]")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"link_vsm\"]")
    private WebElement closeButton;

    public static SendMessage getInstance (WebDriver driver){
        return PageFactory.initElements(driver, SendMessage.class);
    }

    public SendMessage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitHideElement(By elementName) {
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


