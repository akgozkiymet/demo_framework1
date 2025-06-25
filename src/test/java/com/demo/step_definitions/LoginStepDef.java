package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on Signup \\/ Login button")
    public void user_clicks_on_signup_login_button() {
        loginPage.clickSignupLoginButton();
    }

    @Then("login form should be displayed")
    public void login_form_should_be_displayed() {
        loginPage.verifyLoginHeader();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/login");
    }

    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {
        loginPage.enterEmail(ConfigurationReader.getProperty("username"));
        loginPage.enterPassword(ConfigurationReader.getProperty("password"));
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getLoggedInText());
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/login");
        loginPage.enterEmail(ConfigurationReader.getProperty("username"));
        loginPage.enterPassword(ConfigurationReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @When("user clicks on Delete Account button")
    public void user_clicks_on_delete_account_button() {
        loginPage.clickDeleteAccountButton();
    }

    @Then("user should see {string} message")
    public void user_should_see_account_deleted_message(String expectedMessage) {
        loginPage.verifyAccountDeletedMessage(expectedMessage);
    }
}

