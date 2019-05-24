package com.skillup.automation;

import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.pages.StartProfileLocationPage;
import com.skillup.automation.pages.WallPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.skillup.automation.configuration.Waits.FIVE_SECONDS;

public class TestRunner {

    protected WebDriver driver = null;
    protected SignUpPage signUpPage;
    protected StartProfileLocationPage startProfileLocationPage;
    protected LoginPage loginPage;
    protected WallPage wallPage;

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("Before Suit");
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        //second variant
//        driver.manage().deleteAllCookies();

        //first variant
        System.out.println("Before Method");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        signUpPage = new SignUpPage(driver);
        startProfileLocationPage = new StartProfileLocationPage(driver);
        loginPage = new LoginPage(driver);
        wallPage = new WallPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");

        //first variant
        driver.quit();
        //second variant
//        closeNotUseTabs();


    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("After Suit");
        //second variant
//        driver.quit();
    }

    private  void closeNotUseTabs(){
        String currentTab = driver.getWindowHandle();
        List<String> allTabs = new ArrayList<String>(driver.getWindowHandles());

        for (int i = 0; i < allTabs.size(); i++) {
            String tab = allTabs.get(0);
            if (!tab.equals(currentTab)){
                driver.switchTo().window(tab);
                driver.close();
            }
        }

        driver.switchTo().window(currentTab);
    }

}
