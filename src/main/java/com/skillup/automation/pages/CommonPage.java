package com.skillup.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonPage {
    protected WebDriver driver;

    public  CommonPage (WebDriver driver){
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    private String getTitle(){
        return driver.getTitle();
    }

    public void enterText(String locator, String text){
        WebElement input = driver.findElement(By.xpath(locator));
        input.clear();
        input.sendKeys(text);
    }

    public void click(String locator) {
        driver.findElement(find(locator)).click();
    }

    protected By find(String locator) {
        if (locator.contains("//") || locator.startsWith("./")){
            return By.xpath(locator);
        }
        return By.cssSelector(locator);
    }

}
