//import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GoogleAuth {

    private static final Logger logger = LogManager.getLogger(GoogleAuth.class);

    private static final String MAIL_URL = "https://mail.google.com";
    private static final String LOGIN_INPUT_FIELD = "//*[@id=\"identifierId\"]";
    private static final String LOGIN_NEXT_FIELD = "//*[@id=\"identifierNext\"]";
    private static final String PASS_INPUT = "//*[@id=\"password\"]//div[1]/input";
    private static final String PASS_NEXT = "//*[@id=\"passwordNext\"]";

    private final WebDriver driver;

    private WebElement loginInput;
    private WebElement loginNext;

    private WebElement passInput;
    private WebElement passNext;


    public GoogleAuth(WebDriver driver) {
        this.driver = driver;
        this.driver.get(MAIL_URL);
    }

    private WebElement getLoginInput() {
        if (loginInput == null) {
            loginInput = driver.findElement(By.xpath(LOGIN_INPUT_FIELD));
        }
        return loginInput;
    }

    private WebElement getLoginNext() {
        if (loginNext == null) {
            loginNext = driver.findElement(By.xpath(LOGIN_NEXT_FIELD));
        }
        return loginNext;
    }

    private WebElement getPassInput() {
        if (passInput == null) {
            passInput = driver.findElement(By.xpath(PASS_INPUT));
        }
        return passInput;
    }

    private WebElement getPassNext() {
        if (passNext == null) {
            passNext = driver.findElement(By.xpath(PASS_NEXT));

        }
        return passNext;
    }
    @Step("Авторизация на сайте под пользователем {0}")
    public void authorization(String login, String password) {
        logger.info("Ввод логина: " + login);
        getLoginInput().sendKeys(login);
        getLoginNext().click();
        getPassInput().sendKeys(password);
        logger.info("Ввод пароля: " + password);
        getPassNext().click();
    }


}
