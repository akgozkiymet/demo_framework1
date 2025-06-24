package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDef {


    @Given("the user clicks Signup \\/ Login from the home page")
    public void the_user_clicks_signup_login_from_the_home_page() {
        Driver.getDriver().get("https://www.automationexercise.com/");

    }
    @When("the user enters invalid credentials and clicks Login")
    public void the_user_enters_invalid_credentials_and_clicks_login() {
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys("wrong@example.com");
        loginPage.passwordInput.sendKeys("invalidPassword");
        loginPage.loginButton.click();

    }
    @Then("{string} error message should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
