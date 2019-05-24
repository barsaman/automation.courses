package com.skillup.automation.login;

import com.skillup.automation.TestRunner;
import com.skillup.automation.data.LoginTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.skillup.automation.pages.LoginPage;


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
//        Assert.assertEquals(loginPage.getEmailErrorMessage(), EXPECTED_ERROR_MESSAGE, "Error message not match");

        loginPage
                .open()
                .enterEmail("dcsdcsdc@sdcs.dcs")
                .enterPassword("")
                .clickLoginButton()
                .assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);

    }

//    @DataProvider(name = "SetEnviroonment")
//    public  Object[][] getData() {
//        Object[][] browserProperty = new Object[][]{
//                {"meemail.com", "", "Please enter password"},
//                {"meemail.com", "_!slkdcj32ls", "Please enter password"}
//        };
//        return  browserProperty;
//    }

    @Test(dataProvider = "dataLogin", dataProviderClass = LoginTestData.class)
    public void ddtLoginTest(String email, String pass, String expectedError) {
        loginPage
                .open()
                .waitPageToLoad()
                .enterEmail(email)
                .enterPassword(pass)
                .clickLoginButton()
                .assertEmailErrorMessage(expectedError);
    }
}
