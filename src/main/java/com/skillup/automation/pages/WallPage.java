package com.skillup.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WallPage extends CommonPage {
    public WallPage(WebDriver driver) {
        super(driver);
    }

    public void assertIsOnPage (String expectedUrl){
        Assert.assertTrue(getUrl().contains(expectedUrl));
    }
}
