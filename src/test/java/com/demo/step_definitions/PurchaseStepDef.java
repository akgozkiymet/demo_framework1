package com.demo.step_definitions;

import com.demo.pages.PurchasePage;
import com.demo.pages.SignupPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseStepDef extends PurchasePage {

    @When("the user clicks on View Cart link")
    public void theUserClicksOnViewCartLink() {
        clickViewCart();
    }

    @And("user clicks Proceed To Checkout button")
    public void the_user_clicks_proceed_to_checkout_button() {
        clickProceedCheckout();
    }

    @And("user clicks RegisterLogin on the Checkout modal")
    public void user_clicks_register_login_on_the_checkout_modal() {
        clickRegisterLogin();
    }

    @When("user creates a new account")
    public void user_creates_a_new_account() {
        SignupPage signupPage = new SignupPage();
        signupPage.createAccount();
    }

    @When("user clicks Place Order button")
    public void user_clicks_place_order_button() {
        clickPlaceOrder();
    }

    @When("user enters valid payment information")
    public void user_enters_valid_payment_information() {
        fillCardInfo();
    }

    @When("user clicks Pay and Confirm Order button")
    public void user_clicks_pay_and_confirm_order_button() {
        clickPayButton();
    }

    @Then("user should see  {string} header")
    public void user_should_see_header(String expectedHeader) {
        verifyOrderPlacedHeader(expectedHeader);
    }

    @Then("user should see Download Invoice and Continue buttons")
    public void user_should_see_download_invoice_and_continue_buttons() {
        verifyInvoiceAndContinueButton();
    }


    @When("the user clicks on Cart on homepage")
    public void theUserClicksOnCartOnHomepage() {
        navigateToCart();
    }
}

