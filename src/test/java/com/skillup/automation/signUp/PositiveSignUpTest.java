package com.skillup.automation.signUp;

import com.skillup.automation.TestRunner;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.pages.StartProfileLocationPage;
import com.skillup.automation.pages.WallPage;
import com.skillup.automation.utils.RandomEmail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveSignUpTest extends TestRunner {
//    private SignUpPage signUpPage;
//    private StartProfileLocationPage startProfileLocationPage;

//    @BeforeMethod
//    public void before(){
//        signUpPage = new SignUpPage(driver);
//        startProfileLocationPage = new StartProfileLocationPage(driver);
//    }

    @Test
    public void positiveSignUpPage (){
        signUpPage.
                open()
                .enterFirstName("Serhii")
                .enterLastName("Lucky")
                .enterEmail(RandomEmail.randomEmail())
                .enterPassword("Q1w2e3r4t5")
                .clickJoinButton();

        startProfileLocationPage.assertStartProfileLocationUrlContain("/start/profile-location/new/");

    }
}
