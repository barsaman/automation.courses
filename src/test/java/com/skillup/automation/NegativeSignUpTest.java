package com.skillup.automation;

import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeSignUpTest extends TestRunner {
    private static final String LINKED_IN_JOIN_PAGE_URL = "https://www.linkedin.com/start/join";
    private static final String EXPECTED_EMAIL_ERROR_MESSAGE = "Please enter your email address";
    private static final String EXPECTED_PASSWORD_ERROR_MESSAGE = "Please enter your password";

    private ElementHelper helper = new ElementHelper();
    private SignUpPage signUpPage;

    @BeforeMethod
    private void before() {
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void verifyNotSignUpWithInvalidCredentials() {
        driver.get(LINKED_IN_JOIN_PAGE_URL);

        signUpPage.enterFirstName("firstName");
        signUpPage.enterLastName("lastName");
        signUpPage.enterEmail("");
        signUpPage.enterPassword("pasword1234");
        signUpPage.clickJoinButton();

        WebElement alertMessage = driver.findElement(By.cssSelector(SingUpPageLocators.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
        String alertMessageText = alertMessage.getText();

        Assert.assertEquals(alertMessageText, EXPECTED_EMAIL_ERROR_MESSAGE, "Alert Message is incorrect");
    }

    @Test
    public void verifyErrorMessageForEmptyPasswordField() {
        driver.get(LINKED_IN_JOIN_PAGE_URL);

        WebElement firstNameInput = driver.findElement(By.xpath(SingUpPageLocators.FIRST_NAME_INPUT_XPATH_LOCATOR));
        WebElement lastNameInput = driver.findElement(By.xpath(SingUpPageLocators.LAST_NAME_INPUT_XPATH_LOCATOR));
        WebElement emailInput = driver.findElement(By.xpath(SingUpPageLocators.EMAIL_INPUT_XPATH_LOCATOR));
        WebElement passwordInput = driver.findElement(By.xpath(SingUpPageLocators.PASSWORD_INPUT_XPATH_LOCATOR));

        helper.enterText(firstNameInput, "firstName");
        helper.enterText(lastNameInput, "lastName");
        helper.enterText(emailInput, "someemail@email.com");
        helper.enterText(passwordInput, "");

        WebElement joinButton = driver.findElement(By.xpath(SingUpPageLocators.JOIN_BUTTON_XPATH_LOCATOR));
        joinButton.click();

        WebElement alertMessage = driver.findElement(By.cssSelector(SingUpPageLocators.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
        String alertMessageText = alertMessage.getText();

        Assert.assertEquals(alertMessageText, EXPECTED_PASSWORD_ERROR_MESSAGE, "Alert Message is incorrect");
    }

}
