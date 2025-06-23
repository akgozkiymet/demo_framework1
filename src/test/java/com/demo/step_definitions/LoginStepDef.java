package com.demo.step_definitions;

import com.demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
LoginPage loginPage;

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        loginPage=new LoginPage();

    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {

    }
    @When("clicks the login button")
    public void clicks_the_login_button() {

    }
    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {

    }

}
