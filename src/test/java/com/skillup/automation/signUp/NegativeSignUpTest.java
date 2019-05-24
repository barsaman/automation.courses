package com.skillup.automation.signUp;

import com.skillup.automation.TestRunner;
import com.skillup.automation.pages.SignUpPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeSignUpTest extends TestRunner {
    public final static String LINKED_IN_JOIN_PAGE_URL = "https://www.linkedin.com/start/join";
    public final static String EXPECTED_ERROR_EMAIL = "Please enter your email address";
    public final static String EXPECTED_ERROR_PASSWORD = "Please enter your password";

//    private ElementHelper elementHelper = new ElementHelper();
    private SignUpPage signUpPage;

    @BeforeMethod
    private void before(){
        signUpPage = new SignUpPage(driver);
    }


    @Test
    public void verifyNotSignUpWithEmptyEmailField() {

//        driver.get(LINKED_IN_JOIN_PAGE_URL);

//        WebElement firstNameInput = driver.findElement(By.xpath(SingUpPageLocators.FIRST_NAME_INPUT_XPATH_LOCATOR));
//        WebElement lastNameInput = driver.findElement(By.xpath(SingUpPageLocators.LAST_NAME_INPUT_XPATH_LOCATOR));
//        WebElement emailInput = driver.findElement(By.xpath(SingUpPageLocators.EMAIL_INPUT_XPATH_LOCATOR));
//        WebElement passwprdInput = driver.findElement(By.xpath(SingUpPageLocators.PASSWORD_INPUT_XPATH_LOCATOR));

//        elemHelp.enterText(firstNameInput, "firstName");
//        elemHelp.enterText(lastNameInput, "lastName");
//        elemHelp.enterText(emailInput, "");
//        elemHelp.enterText(passwprdInput, "123243");


//        signUpPage.enterFirstName("firstName");
//        signUpPage.enterLastName("lastName");
//        signUpPage.enterEmail("");
//        signUpPage.enterPassword("123243");
//        signUpPage.clickJoinButton();

//        signUpPage.
//                open()
//                .enterFirstName("Serhii")
//                .enterLastName("Lucky")
//                .enterEmail("")
//                .enterPassword("Q1w2e3r4t5")
//                .clickJoinButton()
//                .asserErrorSignUpMessage(EXPECTED_ERROR_EMAIL);




//        firstNameInput.clear();
//        firstNameInput.sendKeys("firstName");
//
//        lastNameInput.clear();
//        lastNameInput.sendKeys("lastName");
//
//        emailInput.clear();
//        emailInput.sendKeys("");
//
//        passwprdInput.clear();
//        passwprdInput.sendKeys("123456");

//        WebElement joinButton = driver.findElement(By.xpath(SingUpPageLocators.JOIN_BUTTON_XPATH_LOCATOR));
//        joinButton.click();
//
//        WebElement alertMessage = driver.findElement(By.cssSelector(SingUpPageLocators.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
//        String alertMessageText = alertMessage.getText();

//        Assert.assertEquals(alertMessageText, EXPECTED_ERROR_EMAIL, "Alert massage is incorrect");
    }

    @Test
    public void verifyErrorForEmptyPasswordField() {

//        driver.get(LINKED_IN_JOIN_PAGE_URL);
//
//        WebElement firstNameInput = driver.findElement(By.xpath(SingUpPageLocators.FIRST_NAME_INPUT_XPATH_LOCATOR));
//        WebElement lastNameInput = driver.findElement(By.xpath(SingUpPageLocators.LAST_NAME_INPUT_XPATH_LOCATOR));
//        WebElement emailInput = driver.findElement(By.xpath(SingUpPageLocators.EMAIL_INPUT_XPATH_LOCATOR));
//        WebElement passwprdInput = driver.findElement(By.xpath(SingUpPageLocators.PASSWORD_INPUT_XPATH_LOCATOR));

//        elemHelp.enterText(firstNameInput, "firstName");
//        elemHelp.enterText(lastNameInput, "lastName");
//        elemHelp.enterText(emailInput, "sdjgcjds@ds.com");
//        elemHelp.enterText(passwprdInput, "");

//        signUpPage.enterFirstName("firstName");
//        signUpPage.enterLastName("lastName");
//        signUpPage.enterEmail("sdjgcjds@ds.com");
//        signUpPage.enterPassword("");
//        signUpPage.clickJoinButton();

        signUpPage
                .open()
                .enterFirstName("Serhii")
                .enterLastName("Lucky")
                .enterEmail("barsa@gmail.com")
                .enterPassword("")
                .clickJoinButton()
                .asserErrorSignUpMessage(EXPECTED_ERROR_PASSWORD);

//        firstNameInput.clear();
//        firstNameInput.sendKeys("firstName");
//
//        lastNameInput.clear();
//        lastNameInput.sendKeys("lastName");
//
//        emailInput.clear();
//        emailInput.sendKeys("sdgc@asxa.xs");
//
//        passwprdInput.clear();
//        passwprdInput.sendKeys("");
//
//        WebElement joinButton = driver.findElement(By.xpath(SingUpPageLocators.JOIN_BUTTON_XPATH_LOCATOR));
//        joinButton.click();
//
//        WebElement alertMessage = driver.findElement(By.cssSelector(SingUpPageLocators.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
//        String alertMessageText = alertMessage.getText();
//
//        Assert.assertEquals(alertMessageText, EXPECTED_ERROR_PASSWORD, "Alert massage is incorrect");

    }

}
