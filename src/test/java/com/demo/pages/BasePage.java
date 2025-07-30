package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[href='/products']")
    private WebElement products;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLogin;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cart;

    public void navigateToProducts(){
        products.click();
    }

    @FindBy(css = "a[href='/']")
    private WebElement homeButton;

    public void clickHomeButton(){
        homeButton.click();
    }
    @FindBy(css = "a[href='/contact_us']")  // locator sayfana göre değişebilir
    public WebElement contactUsButton;

    public void clickContactUsButton() {
        contactUsButton.click();
    }


    public void navigateToCart(){
        cart.click();
    }

}
