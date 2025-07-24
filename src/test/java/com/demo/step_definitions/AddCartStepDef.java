package com.demo.step_definitions;

import com.demo.pages.CartPage;
import com.demo.pages.HomePage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddCartStepDef {

    CartPage cartPage = new CartPage();
    HomePage homePage = new HomePage();

    @Given("the user is on the Products page")
    public void the_user_is_on_the_products_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("productsPageUrl"));
    }

    @When("the user hovers over a product and clicks {string}")
    public void the_user_hovers_over_a_product_and_clicks(String buttonName) {
        BrowserUtils.hover(cartPage.firstProductAddToCartButton);
        try {
            cartPage.firstProductAddToCartButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();" , cartPage.firstProductAddToCartButton);
        }
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        BrowserUtils.waitForVisibility(cartPage.continueShoppingBtn , 5);
        Assert.assertTrue(cartPage.continueShoppingBtn.isDisplayed());
    }

    @Then("the user should see options to {string} or {string}")
    public void the_user_should_see_options_to_or(String option1 , String option2) {
        Assert.assertTrue(cartPage.continueShoppingBtn.isDisplayed());
        Assert.assertTrue(cartPage.viewCartBtn.isDisplayed());
    }

    @Given("the user has added items to the cart")
    public void the_user_has_added_items_to_the_cart() {
        Driver.getDriver().get(ConfigurationReader.getProperty("productsPageUrl"));
        BrowserUtils.scrollToElement(cartPage.firstProductAddToCartButton);
        BrowserUtils.waitForVisibility(cartPage.firstProductAddToCartButton , 3);
        try {
            cartPage.firstProductAddToCartButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();" , cartPage.firstProductAddToCartButton);
        }
        BrowserUtils.waitForVisibility(cartPage.continueShoppingBtn , 3);
        cartPage.continueShoppingBtn.click();
    }

    @When("the user clicks on {string}")
    public void the_user_clicks_on(String buttonName) {
        if (buttonName.equalsIgnoreCase("Cart")) {
            homePage.cartButton.click();
        }
    }

    @Then("the cart should display each item with name, price, quantity, and total price")
    public void the_cart_should_display_each_item_with_name_price_quantity_and_total_price() {
        Assert.assertTrue(cartPage.productName.isDisplayed());
        Assert.assertTrue(cartPage.productPrice.isDisplayed());
        Assert.assertTrue(cartPage.productQuantity.isDisplayed());
        Assert.assertTrue(cartPage.totalPrice.isDisplayed());
    }

    @Given("the user is on a product detail page")
    public void the_user_is_on_a_product_detail_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("productDetailPageUrl"));
    }

    @When("the user sets the quantity to {int} and clicks {string}")
    public void the_user_sets_the_quantity_to_and_clicks(Integer quantity , String buttonName) {
        cartPage.quantityInput.clear();
        cartPage.quantityInput.sendKeys(quantity.toString());

        if (buttonName.equalsIgnoreCase("Add to cart")) {
            cartPage.firstProductAddToCartButton.click();
        }
    }

    @Then("the cart should reflect the quantity as {int} for that product")
    public void the_cart_should_reflect_the_quantity_as_for_that_product(Integer expectedQuantity) {
        String actualQuantity = cartPage.quantityInput.getAttribute("value");
        Assert.assertEquals(String.valueOf(expectedQuantity) , actualQuantity);
    }
    @When("the user removes the item from the cart")
    public void the_user_removes_the_item_from_the_cart() {

    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Cart is empty"));
    }

}

