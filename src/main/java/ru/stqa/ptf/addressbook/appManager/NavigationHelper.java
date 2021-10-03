package ru.stqa.ptf.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroups() {
        click(By.linkText("groups"));
    }
}
