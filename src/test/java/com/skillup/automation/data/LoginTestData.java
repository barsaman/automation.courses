package com.skillup.automation.data;

import com.skillup.automation.utils.RandomEmail;
import org.testng.annotations.DataProvider;

public class LoginTestData {

    @DataProvider(name = "dataLogin")
    public  Object[][] getData() {
        Object[][] browserProperty = new Object[][]{
                {RandomEmail.randomEmail(), "", "Please enter a password."},
//                {RandomEmail.randomEmail(), "_!slkdcj32ls", "Please enter password"}
        };
        return  browserProperty;
    }
}
