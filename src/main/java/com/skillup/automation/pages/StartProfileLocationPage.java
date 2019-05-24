package com.skillup.automation.pages;

import com.skillup.automation.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StartProfileLocationPage extends CommonPage {

    private final static String START_PROFILE_LOCATION_PAGE_URL =
            "https://www.linkedin.com/onboarding/start/profile-location/new/";

    public StartProfileLocationPage(WebDriver driver) {
        super(driver);
    }

    public void assertStartProfileLocationUrlContain(String expectedUrl) {
        Assert.assertTrue(getUrl().contains(expectedUrl));
    }

}
