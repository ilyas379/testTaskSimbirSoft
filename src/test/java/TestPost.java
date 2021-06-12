import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPost {


    static {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
    }

    WebDriver driver;

    @BeforeTest
    public void beforeTestMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

@Test
    public void testSendPost() {
        GoogleAuth googleAuth = new GoogleAuth(driver);
        System.out.println("пошло поехало");
        googleAuth.authorization("autotestsimbir@gmail.com", "795880asDd");
    }

}
