package com.demo.step_definitions;

import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.SignupPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SignupStepDef {
    private static final Logger LOG = LogManager.getLogger();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();


    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homePage.verifyHomePage();
        LOG.info("Landed on the home page");
    }
    @Given("user click SignupLogin page")
    public void user_click_signup_login_page() {
        homePage.clickSignupLoginPage();
    }
    @Then("user should see New User Signup! title")
    public void user_should_see_new_user_signup_title() {
        loginPage.verifySignupHeader();
    }

    @And("user enters name and email under New User Signup!")
    public void userEntersNameAndEmailUnderNewUserSignup() {
        loginPage.inputNameEmail();
    }
    @Given("user clicks Signup button")
    public void user_clicks_signup_button() {
        loginPage.clickSignUpButton();
    }
    @Then("user should land on signup form page")
    public void user_should_land_on_signup_form_page() {
        signupPage.verifyAccountInfoHeader();
    }

    @And("user fills valid account info and address and click create account")
    public void user_fills_valid_account_info_and_address_and_click_create_account() {
        signupPage.fillInfoAndClickCreateAccount();
    }
    @Then("user sees {string} text in header")
    public void user_sees_text_in_header(String header) {
        signupPage.verifyAccountCreatedHeader(header);
    }
    @Then("user sees {string} message")
    public void user_sees_message(String message) {
        signupPage.verifyAccountCreationMessage(message);
    }
    @Then("user clicks continue button")
    public void user_clicks_continue_button() {
        signupPage.clickContinueButton();
    }
    @Then("user should land on home page and see their name beside Logged in as <name>")
    public void user_should_land_on_home_page_and_see_their_name_beside_logged_in_as_name() {

    }


}
