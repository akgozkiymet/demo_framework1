package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {

    //view cart link on Added modal
    @FindBy(xpath = "//div[@id='cartModal']//a")
    private WebElement viewCartLink;

    @FindBy(xpath = "//section[@id='do_action']//a")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@id='checkoutModal']//a[@href='/login']")
    public WebElement registerLoginFromModal;

    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement placeOrderButton;

    @FindBy(name = "name_on_card")
    public WebElement inputNameOnCard;

    @FindBy(xpath = "//input[@data-qa='card-number']")
    public WebElement inputCardNumber;

    @FindBy(name = "cvc")
    public WebElement inputCVC;

    @FindBy(name = "expiry_month")
    public WebElement inputExpiryMonth;

    @FindBy(name = "expiry_year")
    public WebElement inputExpiryYear;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement payButton;

    @FindBy(xpath = "//h2/b")
    public WebElement orderPlaceHeader;

    @FindBy(xpath = "//*[@id='form']//a[.='Download Invoice']")
    public WebElement downloadInvoiceButton;

    @FindBy(xpath = "//*[@id='form']//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//li/a[@href='/view_cart']")
    public WebElement cartPageLink;

    public void clickViewCart() {
        viewCartLink.click();
    }

    public void clickProceedCheckout() {
        proceedToCheckoutButton.click();
    }

    public void clickRegisterLogin() {
        registerLoginFromModal.click();
    }

    public void clickPlaceOrder() {
        BrowserUtils.scrollToElement(placeOrderButton);
        placeOrderButton.click();
    }

    public void fillCardInfo() {
        Faker faker = new Faker();

        inputNameOnCard.sendKeys(faker.name().firstName());
        inputCardNumber.sendKeys(faker.finance().creditCard());
        inputCVC.sendKeys(String.valueOf(faker.number().numberBetween(100, 999)));
        inputExpiryMonth.sendKeys("11");
        inputExpiryYear.sendKeys("2027");
    }

    public void clickPayButton() {
        payButton.click();
    }

    public void verifyOrderPlacedHeader(String header) {
        Assert.assertEquals(header,orderPlaceHeader.getText());
    }

    public void verifyInvoiceAndContinueButton() {
        Assert.assertTrue(downloadInvoiceButton.isDisplayed());
        Assert.assertTrue(continueButton.isDisplayed());
    }

    public void navigateToCart(){
        cartPageLink.click();
    }


}
