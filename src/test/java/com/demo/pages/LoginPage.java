package com.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupHeader;

    public void verifySignupHeader(){
        Assert.assertTrue("New user signup header not displayed", signupHeader.isDisplayed());
    }

}
