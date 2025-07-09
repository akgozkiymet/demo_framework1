package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchPage extends BasePage{
    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id="submit_search")
    private WebElement searchButton;
}
