//import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendMessage {

    private static final Logger logger = LogManager.getLogger(SendMessage.class);

    private static final String WRITE_BUTTON = "T-I-KE";
    private static final String RECIPIENT = "vO";
    private static final String THEME_MESSAGE = "aoT";
    private static final String BODY_MESSAGE = "//*[contains(@class, 'Am')]";
    private static final String SEND_BUTTON = "//*[contains(@class, 'dC')]";

    private final WebDriver driver;
    private WebElement writeButton;
    private WebElement sendWhom;
    private WebElement sendTheme;
    private WebElement sendBody;
    private WebElement sendButton;

    private WebElement getWriteButton() {
        if(writeButton == null){
            writeButton = driver.findElement(By.className(WRITE_BUTTON));
        }
        return writeButton;
    }

    private WebElement getSendWhom(){
        if(sendWhom ==null){
            sendWhom = driver.findElement(By.className(RECIPIENT));
        }
        return sendWhom;
    }

    private WebElement getSendTheme(){
        if(sendTheme == null) {
            sendTheme = driver.findElement(By.className(THEME_MESSAGE));
        }
        return sendTheme;
    }

    private WebElement getSendBody(){
        if(sendBody == null) {
            sendBody = driver.findElement(By.xpath(BODY_MESSAGE));
        }
        return sendBody;
    }

    private WebElement getSendButton(){
        if(sendButton == null) {
            sendButton = driver.findElement(By.xpath(SEND_BUTTON));
        }
        return sendButton;
    }

    public SendMessage (WebDriver driver){
        this.driver = driver;
    }

    @Step("Отправка сообщения на адрес {0}")
    public void sendMail(String address, String subject, String body) throws InterruptedException {
        logger.info("Нажатие кнопки \"Написать\"");
        getWriteButton().click();
        logger.info("Заполнение адреса: " + address);
        getSendWhom().sendKeys(address);
        logger.info("Заполнение темы письма: " + subject);
        getSendTheme().sendKeys(subject);
        logger.info("Заполнение тела письма");
        getSendBody().sendKeys(body);
        logger.info("Отправка письма");
        getSendButton().click();
        Thread.sleep(3000);
    }





}
