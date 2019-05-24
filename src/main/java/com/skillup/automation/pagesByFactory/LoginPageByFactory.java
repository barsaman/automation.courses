package com.skillup.automation.pagesByFactory;

import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.skillup.automation.configuration.Urls.LOGIN_URL;

public class LoginPageByFactory {

    @FindBy
    private WebElement errorFormMessage;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class = 'login__form']//button")
    private WebElement loginButton;

    private WebDriver driver;
    private ElementHelper elementHelper = new ElementHelper();

    public LoginPageByFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageByFactory open() {
        driver.get(LOGIN_URL);
        return this;
    }


    public LoginPageByFactory enterEmail(String email) {
        elementHelper.enterText(emailInput, email);
        return this;
    }

    public LoginPageByFactory enterPassword(String password) {
        elementHelper.enterText(passwordInput, password);
        return this;
    }

    public LoginPageByFactory clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPageByFactory assertEmailErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = errorFormMessage.getText();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not match");
        return this;
    }


}
