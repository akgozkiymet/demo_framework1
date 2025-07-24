package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy(xpath = "(//*[text()='Add to cart'])[1]")
    public WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@href='/view_cart']")
    public WebElement viewCartBtn;

    @FindBy(xpath = "//a[text()='Blue Top']")
    public WebElement productName;

    @FindBy(xpath = "//td[@class='cart_price']")
    public WebElement productPrice;

    @FindBy(xpath = "//td[@class='cart_total']/p")
    public WebElement totalPrice;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantityInput;
    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    public WebElement productQuantity;

}
