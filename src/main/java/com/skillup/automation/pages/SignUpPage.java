package com.skillup.automation.pages;

//import com.skillup.utils.ElementHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SignUpPage extends CommonPage {
    private static final String FIRST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='first-name']";
    private static final String LAST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='last-name']";
    private static final String EMAIL_INPUT_XPATH_LOCATOR = "//input[@name='emailAddress']";
    private static final String PASSWORD_INPUT_XPATH_LOCATOR = "//li[contains(@class, 'password-field')]//input";
    private static final String JOIN_BUTTON_XPATH_LOCATOR = "//*[contains(@class, 'join-btn')]";
    private static final String FACEBOOK_BUTTON_XPATH_LOCATOR = "//*[@class = 'fb-btn']";
    private static final String SIGN_IN_BUTTON__CSS_LOCATOR = ".signin-link > a";
    private static final String ERROR_ALERT_MESSAGE_CSS_LOCATOR = ".uno-alert strong";
    public static final String REGISTER_URL = "https://www.linkedin.com/start/join";

//    private WebDriver driver;
//    private ElementHelper elementHelper = new ElementHelper();

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage open() {
        driver.get(REGISTER_URL);
        return this;
    }




    public SignUpPage enterFirstName(String firstName) {
//        WebElement input = driver.findElement(By.cssSelector(FIRST_NAME_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, firstName);
        enterText(FIRST_NAME_INPUT_XPATH_LOCATOR, firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
//        WebElement input = driver.findElement(By.cssSelector(LAST_NAME_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, lastName);
        enterText(LAST_NAME_INPUT_XPATH_LOCATOR, lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
//        WebElement input = driver.findElement(By.cssSelector(EMAIL_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, email);
        enterText(EMAIL_INPUT_XPATH_LOCATOR, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
//        WebElement input = driver.findElement(By.cssSelector(PASSWORD_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, password);
        enterText(PASSWORD_INPUT_XPATH_LOCATOR, password);
        return this;
    }

    public SignUpPage clickJoinButton() {
//        WebElement button = driver.findElement(By.cssSelector(JOIN_BUTTON_XPATH_LOCATOR));
//        button.click();
        click(JOIN_BUTTON_XPATH_LOCATOR);
        return this;
    }

    public SignUpPage asserErrorSignUpMessage(String expectedErrorMessage) {
        WebElement alertMessage = driver.findElement(By.cssSelector(SignUpPage.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
        String alertMessageText = alertMessage.getText();

        Assert.assertEquals(alertMessageText, expectedErrorMessage, "Error message not match");
        return this;
    }

    public String getErrorEmailMessage() {
        WebElement alertMessage = driver.findElement(By.cssSelector(SignUpPage.ERROR_ALERT_MESSAGE_CSS_LOCATOR));
        return alertMessage.getText();
    }

}
