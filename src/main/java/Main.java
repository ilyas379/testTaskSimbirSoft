import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        String mailUrl = "https://mail.google.com";

        WebDriver driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger.info("переходит на сайт " + mailUrl);
        driverChrome.get(mailUrl);
        System.out.println("драйвер перешел");
        WebElement inputLogin = driverChrome.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        inputLogin.sendKeys("autotestsimbir@gmail.com" + Keys.ENTER);
        WebElement inputPass = driverChrome.findElement(By.xpath("//*[@id=\"password\"]//div[1]/input"));
        inputPass.sendKeys("795880asDd" + Keys.ENTER);
        List<WebElement>webElementList = driverChrome.findElements(By.xpath("//span[@class='bqe']"));
        System.out.println(webElementList);
        System.out.println("");

        System.out.println(webElementList.size());
        List<WebElement>sortList = webElementList.stream()
                .filter(webElement -> webElement.getText().contains("Simbirsoft Тестовое задание"))
                .collect(Collectors.toList());
        System.out.println(sortList.size());

//        WebElement write = driverChrome.findElement(By.xpath(""))
//        input.
//        driverChrome.

    }
}
