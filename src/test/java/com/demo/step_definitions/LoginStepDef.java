package com.demo.step_definitions;

import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @When("user clicks on SignupLogin button")
    public void user_clicks_on_signup_login_button() {
        homePage.clickSignupLoginPage();
    }

    @Then("login form should be displayed")
    public void login_form_should_be_displayed() {
        loginPage.verifySignupHeader();
    }

}
