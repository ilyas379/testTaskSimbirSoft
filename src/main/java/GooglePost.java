import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePost {

    private static final Logger logger = LogManager.getLogger(GooglePost.class);

    private static final String FIND_MESSAGES = "//table[contains(@class, 'zt')]" +
            "//tr[contains(@class, 'zA')]/td[contains(@class, 'a4W')]//span[contains(@class, 'bog')]/span";

    @FindBy(xpath = FIND_MESSAGES)
    private List<WebElement> messageList;

    @Step("Поиск количества входящих сообщений")
    public long getMessagesCount(String findText) {
        long messagesCount = messageList.stream()
                .filter(webElement -> webElement.getText().equals(findText))
                .count();
        logger.info("Найдено сообщений, с темой пиcьма \"" + findText + "\": " + messagesCount);
        return messagesCount;
    }
}
