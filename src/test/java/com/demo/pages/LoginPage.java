package com.demo.pages;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final Logger LOG = LogManager.getLogger();
    Faker faker = new Faker();

    //login and initial signup page
    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupHeader;

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    public void verifySignupHeader(){
        Assert.assertTrue("New user signup header not displayed", signupHeader.isDisplayed());
    }

    public void inputNameEmail(){
        String dateTime = BrowserUtils.getTimeStamp();
        String name = faker.name().firstName();
        String email = ConfigurationReader.getProperty("email_base") + "+" + dateTime + "@gmail.com";
        signupName.sendKeys(name);
        LOG.info("signup name: {}", name);
        signupEmail.sendKeys(email);
        LOG.info("email: {}", email);
    }

    public void clickSignUpButton(){
        signupButton.click();
    }

}
