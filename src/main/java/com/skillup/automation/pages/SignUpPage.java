package com.skillup.automation.pages;

import com.skillup.automation.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private static final String FIRST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='first-name']";
    private static final String LAST_NAME_INPUT_XPATH_LOCATOR = "//input[@id='last-name']";
    private static final String EMAIL_INPUT_XPATH_LOCATOR = "//input[@name='emailAddress']";
    private static final String PASSWORD_INPUT_XPATH_LOCATOR = "//li[contains(@class, 'password-field')]//input";
    private static final String JOIN_BUTTON_XPATH_LOCATOR = "//*[contains(@class, 'join-btn')]";
    private static final String FACEBOOK_BUTTON_XPATH_LOCATOR = "//*[@class = 'fb-btn']";
    private static final String SIGN_IN_BUTTON__CSS_LOCATOR  = ".signin-link > a";
    private static final String ERROR_ALERT_MESSAGE_CSS_LOCATOR = ".uno-alert strong";

    private WebDriver driver;
    private ElementHelper helper = new ElementHelper();

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String name) {
        WebElement input = driver.findElement(By.xpath(FIRST_NAME_INPUT_XPATH_LOCATOR));
        helper.enterText(input, name);
    }

    public void enterLastName(String lastName) {
        WebElement input = driver.findElement(By.xpath(LAST_NAME_INPUT_XPATH_LOCATOR));
        helper.enterText(input, lastName);
    }

    public void enterPassword(String password) {
        WebElement input = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH_LOCATOR));
        helper.enterText(input, password);
    }

    public void enterEmail(String email) {
        WebElement input = driver.findElement(By.xpath(EMAIL_INPUT_XPATH_LOCATOR));
        helper.enterText(input, email);
    }

    public void clickJoinButton() {
        WebElement button = driver.findElement(By.xpath(JOIN_BUTTON_XPATH_LOCATOR));
        button.click();
    }

}
