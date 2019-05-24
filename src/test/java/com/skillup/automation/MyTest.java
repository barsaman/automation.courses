package com.skillup.automation;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyTest extends TestRunner {
    private static final String EXPECTED_TITLE = "Google";
    private static final String URL = "https://www.google.com";


    @Test
    public void myTest() {
        driver.get(URL);
        String actualTitle = driver.getTitle();

       Assert.assertEquals("Bing", EXPECTED_TITLE, "Title is wrong");

    }
}
