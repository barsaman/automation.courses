package com.skillup.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.skillup.automation.configuration.Waits.TEN_SECONDS;

public class LoginPage extends CommonPage {
    private static final String EMAIL_OR_PHONE_INPUT_XPATH_LOCATOR = "//input[@id='username']";
    private static final String PASSWORD_INPUT_XPATH_LOCATOR = "//input[@id='password']";
    private static final String PASSWORD_TOGGLE_XPATH_LOCATOR = "//span[@id='password-visibility-toggle']";
    private static final String SIGN_IN_BUTTON_XPATH_LOCATOR = "//*[@class = 'login__form']//button";
    private static final String FORGOT_PASSWORD_LINK_XPATH_LOCATOR = "//a[contains(@href, 'request-password-reset')]";
    private static final String JOIN_NOW_LINK_XPATH_LOCATOR = "//a[@href ='/start/join']";
    private static final String ERROR_PASSWORD_DIV_CSS_LOCATOR = "#error-for-password";
    public static final String LOGIN_URL = "https://www.linkedin.com/uas/login";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(LOGIN_URL);
        return this;
    }

  //  private ElementHelper elementHelper = new ElementHelper();

    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }

    public  LoginPage waitPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, TEN_SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(find(SIGN_IN_BUTTON_XPATH_LOCATOR)));
        return this;
    }


    public LoginPage enterEmail(String email) {
//        WebElement input = driver.findElement(By.xpath(EMAIL_OR_PHONE_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, email);
        enterText(EMAIL_OR_PHONE_INPUT_XPATH_LOCATOR, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
//        WebElement input = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH_LOCATOR));
//        elementHelper.enterText(input, password);
        enterText(PASSWORD_INPUT_XPATH_LOCATOR, password);
        return this;
    }

    public LoginPage clickLoginButton() {
//        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH_LOCATOR)).click();
        click(SIGN_IN_BUTTON_XPATH_LOCATOR);
        return this;
    }

    public LoginPage assertEmailErrorMessage(String expectedErrorMessage) {
        WebElement errorMessage = driver.findElement(By.cssSelector(LoginPage.ERROR_PASSWORD_DIV_CSS_LOCATOR));
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not match");
        return this;
    }

    public String getEmailErrorMessage() {
        WebElement errorMessage = driver.findElement(By.cssSelector(LoginPage.ERROR_PASSWORD_DIV_CSS_LOCATOR));
        return errorMessage.getText();
    }
}
