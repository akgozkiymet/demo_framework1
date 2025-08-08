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

    @Then("user should see form with fields for name, email and review")
    public void user_should_see_form_with_fields_for_and() {
        productDetailPage.verifyReviewFormFields();
    }

    @Then("user should see submit button")
    public void user_should_see_submit_button() {
        productDetailPage.verifySubmitButton();
    }

    @When("user enters name {string}")
    public void user_enters_name(String name) {
        productDetailPage.enterName(name);
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        productDetailPage.enterEmail(email);
    }

    @When("user enters review {string}")
    public void user_enters_review(String reviewDetails) {
        productDetailPage.enterReview(reviewDetails);
    }

    @When("user submits the review")
    public void user_submits_the_review() {
        productDetailPage.clickSubmitButton();
    }

    @Then("user should see confirmation message {string}")
    public void user_should_see_confirmation_message(String confirmationMessage) {
        productDetailPage.verifyConfirmationMessage(confirmationMessage);
    }


}
