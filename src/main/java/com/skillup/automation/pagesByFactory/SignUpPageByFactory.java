package com.skillup.automation.pagesByFactory;

import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.skillup.automation.configuration.Urls.REGISTER_URL;

public class SignUpPageByFactory {
    @FindBy(css = ".uno-alert strong")
    private WebElement errorFormMessage;


    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailInput;

    @FindBy(xpath = "//li[contains(@class, 'password-field')]//input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(@class, 'join-btn')]")
    private WebElement signUpButton;

    private WebDriver driver;
    private ElementHelper elementHelper = new ElementHelper();

    public SignUpPageByFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPageByFactory open() {
        driver.get(REGISTER_URL);
        return this;
    }

    public SignUpPageByFactory enterFirstName(String firstName) {
        elementHelper.enterText(firstNameInput, firstName);
        return this;
    }

    public SignUpPageByFactory enterLastName(String lastName) {
        elementHelper.enterText(lastNameInput, lastName);
        return this;
    }

    public SignUpPageByFactory enterEmail(String email) {
        elementHelper.enterText(emailInput, email);
        return this;
    }

    public SignUpPageByFactory enterPassword(String password) {
        elementHelper.enterText(passwordInput, password);
        return this;
    }

    public SignUpPageByFactory clickJoinButton() {
        signUpButton.click();
        return this;
    }

    public SignUpPageByFactory asserErrorSignUpMessage(String expectedErrorMessage) {

        String actualErrorMessage = errorFormMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not match");
        return this;
    }


}
