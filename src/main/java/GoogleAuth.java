import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleAuth {

    private static final Logger logger = LogManager.getLogger(GoogleAuth.class);

    public static GoogleAuth getInstance(WebDriver driver, String mailUrl){
       driver.get(mailUrl);
       return PageFactory.initElements(driver, GoogleAuth.class);
    }

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    private WebElement loginNext;

    @FindBy(xpath = "//*[@id=\"password\"]//div[1]/input")
    private WebElement passInput;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]")
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
