package com.demo.pages;

import com.demo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginLink;

    public void clickSignupLoginPage(){
        signupLoginLink.click();
    }

    public void verifyHomePage(){
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
    }
}
