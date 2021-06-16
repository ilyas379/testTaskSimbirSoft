import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleAuth {

    private static final Logger logger = LogManager.getLogger(GoogleAuth.class);

    private static final String MAIL_URL = "https://mail.google.com";
    private static final String LOGIN_INPUT_FIELD = "//*[@id=\"identifierId\"]";
    private static final String LOGIN_NEXT_FIELD = "//*[@id=\"identifierNext\"]";
    private static final String PASS_INPUT = "//*[@id=\"password\"]//div[1]/input";
    private static final String PASS_NEXT = "//*[@id=\"passwordNext\"]";

    public GoogleAuth(WebDriver driver) {
        driver.get(MAIL_URL);
    }

    @FindBy(xpath = LOGIN_INPUT_FIELD)
    private WebElement loginInput;

    @FindBy(xpath = LOGIN_NEXT_FIELD)
    private WebElement loginNext;

    @FindBy(xpath = PASS_INPUT)
    private WebElement passInput;

    @FindBy(xpath = PASS_NEXT)
    private WebElement passNext;


    @Step("Авторизация на сайте под пользователем {0}")
    public void authorization(String login, String password) {
        logger.info("Ввод логина: " + login);
        loginInput.sendKeys(login);
        loginNext.click();
        passInput.sendKeys(password);
        logger.info("Ввод пароля: " + password);
        passNext.click();
    }
}
