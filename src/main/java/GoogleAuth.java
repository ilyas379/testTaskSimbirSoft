import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class GoogleAuth {

    private static final String MAIL_URL = "https://mail.google.com";
    public static final String LOGIN_INPUT_FIELD = "//*[@id=\"identifierId\"]";
    public static final String LOGIN_NEXT_FIELD = "//*[@id=\"identifierNext\"]";
    public static final String PASS_INPUT = "//*[@id=\"password\"]//div[1]/input";
    public static final String PASS_NEXT = "//*[@id=\"passwordNext\"]";
    WebElement loginInput;
    WebElement loginNext;

    WebElement passInput;
    WebElement passNext;

    private WebElement getLoginInput() {
        if(loginInput==null) {
        loginInput = driver.findElement(By.xpath(LOGIN_INPUT_FIELD));
        }
            return loginInput;
    }

    private WebElement getLoginNext() {
        if (loginNext==null){
            loginNext = driver.findElement(By.xpath(LOGIN_NEXT_FIELD));
        }
        return loginNext;
    }

    private WebElement getPassInput() {
        if(passInput==null){
            passInput = driver.findElement(By.xpath(PASS_INPUT));
        }
        return passInput;
    }

    private WebElement getPassNext() {
        if(passNext==null){
            passNext = driver.findElement(By.xpath(PASS_NEXT));

        }
        return passNext;
    }

    public GoogleAuth(WebDriver driver){
        this.driver = driver;
        this.driver.get(MAIL_URL);
    }
    WebDriver driver;

    public void authorization(String login, String password) {
        getLoginInput().sendKeys(login);
        getLoginNext().click();
        getPassInput().sendKeys(password);
        getPassNext().click();
        getPassNext().click();
    }


}
