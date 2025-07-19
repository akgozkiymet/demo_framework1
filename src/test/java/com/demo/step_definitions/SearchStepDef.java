package com.demo.step_definitions;

import com.demo.pages.HomePage;
import com.demo.pages.ProductSearchPage;
import com.demo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;

public class SearchStepDef {

    ProductSearchPage productSearchPage = new ProductSearchPage();
    HomePage homePage = new HomePage();
    static Set<String>  titlesSet;

    @Given("user searches for {string}")
    public void user_searches_for(String searchTerm) {
        productSearchPage.performSearch(searchTerm);
    }

    @Then("user should see {string} related products in the resulting page")
    public void user_should_see_related_products_in_the_resulting_page(String searchTerm) {
        titlesSet = productSearchPage.verifySearchResults(searchTerm);
    }

    @And("user navigate to Products page")
    public void userNavigateToProductsPage() {
        BrowserUtils.waitElementVisibility(homePage.getCarouselHeader());
        productSearchPage.navigateToProducts();
    }

    @Then("user should see a search input field with the placeholder text {string}")
    public void user_should_see_a_search_input_field_with_the_placeholder_text(String placeholder) {
        productSearchPage.verifyPlaceholder(placeholder);
    }

    @Then("user should see the heading {string}")
    public void user_should_see_the_heading(String heading) {
        productSearchPage.verifySearchedHeader(heading);
    }

    @Then("user should see no products are displayed")
    public void user_should_see_no_products_are_displayed() {
        productSearchPage.verifyNoResults();
    }

    @Given("user click view product on an item")
    public void user_clicked_view_product_on_an_item() {
        productSearchPage.navigateToPDP();
    }

    @When("user navigate back using the browser back button")
    public void user_navigate_back_using_the_browser_back_button() {
        productSearchPage.navigateBackToPage();
    }

    @Then("the search term {string} should still be in the search bar")
    public void the_search_term_should_still_be_in_the_search_bar(String searchTerm) {
        productSearchPage.verifySearchTermInSearchBar(searchTerm);
    }

    @Then("user should see the same searched {string} products displayed")
    public void userShouldSeeTheSameSearchedProductsDisplayed(String searchTerm) {
        //depended on  "user_should_see_related_products_in_the_resulting_page" step
        productSearchPage.verifySearchResultsAfterNavigation(searchTerm, titlesSet);

    }
}
