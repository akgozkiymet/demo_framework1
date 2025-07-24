package com.demo.step_definitions;

import com.demo.pages.SubscribePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class SubscribeStepDef {
    SubscribePage subscribePage = new SubscribePage();

    @And("user enters valid email {string} to subscribe to email updates")
    public void userEntersValidToSubscribeToEmailUpdates(String email) {
        subscribePage.enterEmailToSubscribe(email);
    }

    @Then("user should see the subscription success message {string}")
    public void user_should_see_the_subscription_success_message(String message) {
        subscribePage.verifySuccessMessage(message);
    }

    @And("user navigates to cart")
    public void user_navigates_to_cart() {
        subscribePage.navigateToCart();
    }
}
