package com.skillup.automation.login;

import com.skillup.automation.TestRunner;
import com.skillup.automation.pagesByFactory.LoginPageByFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginByPageFactory extends TestRunner {
   private LoginPageByFactory loginPageByFactory;
   private final String EXPECTED_ERROR_MESSAGE = "qweer";

    @BeforeMethod
    public void before(){
        loginPageByFactory = new LoginPageByFactory(driver);
    }

    @Test
    public void wrongEmail() {
        loginPageByFactory.
                open()
                .enterEmail("asdas@dsc.dc")
                .enterPassword("sdcsdcsdcsd")
                .clickLoginButton()
                .assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);

    }

}
