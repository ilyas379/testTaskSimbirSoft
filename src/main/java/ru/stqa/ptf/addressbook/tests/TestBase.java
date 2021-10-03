package ru.stqa.ptf.addressbook.tests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.stqa.ptf.addressbook.appManager.ApplicationManager;


public class TestBase {

    static {
        System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
    }

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeTest
    public void setUp() {
        app.init();
    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }

}
