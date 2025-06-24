package com.demo.pages;
import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(css = "div[class='login-form'] h2")
    public WebElement signupHeader;

    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public void verifySignupHeader() {
        Assert.assertTrue(signupHeader.isDisplayed());
    }
}