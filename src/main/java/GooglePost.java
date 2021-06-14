import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePost {

    private static final Logger logger = LogManager.getLogger(GooglePost.class);

    private static final String FIND_TEXT = "Simbirsoft Тестовое задание";
    private static final String FIND_MESSAGES = "//*[contains(@class, 'y6')]//*[text() ='" + FIND_TEXT + "']";
    private final WebDriver driver;
    private List<WebElement> messageList;

    public GooglePost(WebDriver driver) {
        this.driver = driver;
    }

    private List<WebElement> getMessageList() {
        if (messageList == null) {
            messageList = driver.findElements(By.xpath(FIND_MESSAGES));
        }
        return messageList;
    }

    @Step("Поиск количества входящих сообщений")
    public int getMessagesCount() {
        logger.info("Найдено сообщений, с темой пиcьма \"" + FIND_TEXT + "\": " + getMessageList().size());
        return getMessageList().size();
    }
}
