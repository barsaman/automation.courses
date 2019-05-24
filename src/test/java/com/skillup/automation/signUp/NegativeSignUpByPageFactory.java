package com.skillup.automation.signUp;

import com.skillup.automation.TestRunner;
import com.skillup.automation.pagesByFactory.SignUpPageByFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeSignUpByPageFactory extends TestRunner {
    private SignUpPageByFactory signUpPageByFactory;
    private final String EXPECTED_ERROR_MESSAGE = "Укажите свой адрес эл. почты";

    @BeforeMethod
    public void before(){
        signUpPageByFactory = new SignUpPageByFactory(driver);
    }

    @Test
    public void wrongMessage(){
        signUpPageByFactory
                .open()
                .enterFirstName("Serhii")
                .enterLastName("Lychko")
                .enterEmail("")
                .enterPassword("12345qwert")
                .clickJoinButton()
                .asserErrorSignUpMessage(EXPECTED_ERROR_MESSAGE);

    }
}
