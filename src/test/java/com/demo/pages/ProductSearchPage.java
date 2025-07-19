package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import io.restassured.internal.common.assertion.Assertion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductSearchPage extends BasePage {
    private static final Logger LOG = LogManager.getLogger();

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='cartModal']/following-sibling::div//div[@class='productinfo text-center']/p")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//div[@id='cartModal']/preceding-sibling::h2")
    private WebElement searchedProductHeader;

    @FindBy(xpath = "//a[text()='View Product']")
    private WebElement viewProduct;

    public void performSearch(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchButton.click();
    }

    public Set<String> verifySearchResults(String searchTerm) {
        //make it lowercase to handle case sensitivity
        searchTerm = searchTerm.toLowerCase();
        //remove duplicates
        Set<String> titles = new HashSet<>(BrowserUtils.extractText(productTitles));
        int count = 0;
        for (String each : titles) {
            if (each.toLowerCase().contains(searchTerm)) {
                count++;
            }
        }
        LOG.info("Product titles are : {}", titles);
        LOG.info("{} product is displayed, {} has the search term in title", titles.size(), count);

        Assert.assertTrue(count > titles.size() / 2); //assume success if more than half of the result titles contain the search term
        return titles;
    }

    public void verifyPlaceholder(String placeholderText) {
        Assert.assertEquals(placeholderText, searchInput.getDomAttribute("placeholder"));
    }

    public void verifySearchedHeader(String header) {
        LOG.info("Expected header {} , actual header {}", header, searchedProductHeader.getText());
        Assert.assertEquals(header, searchedProductHeader.getText());
    }

    public void verifyNoResults() {
        Set<String> titles = new HashSet<>(BrowserUtils.extractText(productTitles));

        LOG.info("titles displayed are {}", titles);

        Assert.assertTrue(titles.isEmpty()); //no titles have been displayed
    }

    public void navigateToPDP(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", viewProduct);
        BrowserUtils.waitElementVisibility(viewProduct);
        viewProduct.click();
    }

    public void navigateBackToPage(){
        Driver.getDriver().navigate().back();
        LOG.info("Navigated back");
    }

    public void verifySearchTermInSearchBar(String searchTerm){
        Assert.assertEquals(searchTerm,        searchInput.getAttribute("value"));
    }

    public void verifySearchResultsAfterNavigation(String searchTerm, Set<String> previousResults ) {
        Set<String> currentResults = new HashSet<>(BrowserUtils.extractText(productTitles));

        Assert.assertEquals(previousResults, currentResults);
        LOG.info("Previous results match with current results");

        LOG.info("Current results {}", currentResults);
        LOG.info("Previous results {}", previousResults);
    }

}
