package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    @When("user clicks on Signup \\/ Login button")
    public void user_clicks_on_signup_login_button() {
        loginPage.clickSignupLoginButton();
    }

    @Then("login form should be displayed")
    public void login_form_should_be_displayed() {
        loginPage.verifySignupHeader();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

    }
    @When("user enters valid email and password")
    public void user_enters_valid_email_and_password() {

    }
    @When("clicks on login button")
    public void clicks_on_login_button() {

    }
    @Then("user should see {string} message")
    public void user_should_see_message(String string) {

    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
    }
}
