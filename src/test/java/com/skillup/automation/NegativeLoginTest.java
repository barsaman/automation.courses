package com.skillup.automation;

import com.skillup.automation.data.LoginTestData;
import com.skillup.automation.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestRunner {
    private static final String EXPECTED_ERROR_MESSAGE = "Please enter a password.";

    private LoginPage loginPage;

    @BeforeMethod
    public void before() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void wrongEmailTest() {
//        driver.get(LOGIN_URL);
//        driver.get(LoginPage.LOGIN_URL);

//        loginPage.open();
//        loginPage.enterEmail("myemail@email.com");
//        loginPage.enterPassword("");
//        loginPage.clickLoginButton();

        loginPage
                .open()
                .enterEmail("myemail@email.com")
                .enterPassword("")
                .clickLoginButton()
                .assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);

//        loginPage.assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);
//        Assert.assertEquals(loginPage.getEmailErrorMessage(), EXPECTED_ERROR_MESSAGE, "Error message not match");
    }

    @Test(dataProvider = "dataLogin", dataProviderClass = LoginTestData.class)
    public void ddtLoginTest(String email, String password, String errorMassage) {

        loginPage.open()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .assertEmailErrorMessage(errorMassage);
    }
}

