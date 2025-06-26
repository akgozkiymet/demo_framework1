package com.demo.pages;

import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(css = "div[class='login-form'] h2")
    public WebElement loginHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//li[contains(text(),'Logged in as')]")
    public WebElement loggedInAsText;

    @FindBy(css = "a[href='/delete_account']")
    public WebElement deleteAccountButton;
    @FindBy(css = "a[href='/logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    public WebElement accountDeletedHeader;

    @FindBy(css = "div.signup-form h2")
    public WebElement signupHeader;

    @FindBy(css = "input[placeholder='Name']")
    public WebElement signupNameBox;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement signupEmailBox;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signupButton;

    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public void verifyLoginHeader() {
        Assert.assertTrue(loginHeader.isDisplayed());
    }

    public void enterEmail(String email) {
        emailInputBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInputBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoggedInText() {
        return loggedInAsText.getText();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void verifyAccountDeletedMessage(String expectedMsg) {
        Assert.assertEquals(expectedMsg , accountDeletedHeader.getText());
    }

    public void verifySignupHeader() {
        Assert.assertTrue(signupHeader.isDisplayed());
    }

    public void inputNameEmail() {
        signupNameBox.sendKeys(ConfigurationReader.getProperty("name"));
        signupEmailBox.sendKeys(ConfigurationReader.getProperty("username"));
    }

    public void clickSignUpButton() {
        signupButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}

