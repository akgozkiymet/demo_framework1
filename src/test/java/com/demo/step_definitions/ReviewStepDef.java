package com.demo.step_definitions;
import com.demo.pages.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ReviewStepDef {
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Given("user is on the product detail page")
    public void user_is_on_the_product_detail_page() {
        productDetailPage.verifyPDP();
    }
    @Then("user should see the {string} section")
    public void user_should_see_the_section(String sectionTitle) {
        productDetailPage.verifySectionTitle(sectionTitle);
    }
    @Then("user should see form with fields for {string},{string},{string}")
    public void user_should_see_form_with_fields_for_and(String name, String email, String review) {

    }
    @Then("user should see submit button")
    public void user_should_see_submit_button() {

    }

    @When("user enters name {string}")
    public void user_enters_name(String name) {

    }
    @When("user enters email {string}")
    public void user_enters_email(String email) {

    }
    @When("user enters review {string}")
    public void user_enters_review(String reviewDetails) {

    }
    @When("user submits the review")
    public void user_submits_the_review() {

    }
    @Then("user should see confirmation message {string}")
    public void user_should_see_confirmation_message(String confirmationMessage) {

    }


}
