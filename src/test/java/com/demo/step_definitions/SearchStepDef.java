package com.demo.step_definitions;

import com.demo.pages.ProductSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef {

    ProductSearchPage productSearchPage = new ProductSearchPage();

    @Given("user searches for {string}")
    public void user_searches_for(String searchTerm) {

    }

    @Then("user should see {string} related products in the resulting page")
    public void user_should_see_related_products_in_the_resulting_page(String searchTerm) {

    }

    @And("user navigate to Products page")
    public void userNavigateToProductsPage() {
        productSearchPage.navigateToProducts();
    }

    @Then("user should see a search input field with the placeholder text {string}")
    public void user_should_see_a_search_input_field_with_the_placeholder_text(String placeholder) {

    }

    @Then("user should see a search button next to the input field")
    public void user_should_see_a_search_button_next_to_the_input_field() {

    }

    @Then("user should see the heading {string}")
    public void user_should_see_the_heading(String headjng) {

    }

    @Then("user should see products that contain {string} in their name or description")
    public void user_should_see_products_that_contain_in_their_name_or_description(String searchTerm) {

    }

    @Then("I should see no products are displayed")
    public void i_should_see_no_products_are_displayed() {

    }

    @Given("I have clicked on a product detail page")
    public void i_have_clicked_on_a_product_detail_page() {

    }

    @When("I navigate back using the browser back button")
    public void i_navigate_back_using_the_browser_back_button() {

    }

    @Then("the search term {string} should still be in the search bar")
    public void the_search_term_should_still_be_in_the_search_bar(String searchTerm) {

    }

    @Then("I should see the same searched products displayed")
    public void i_should_see_the_same_searched_products_displayed() {

    }

}
