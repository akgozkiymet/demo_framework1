package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{
    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//b[text()='Availability:']")
    private WebElement availability;

    @FindBy(css = "a[href='#reviews']")
    private WebElement writeReviewSectionTitle;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "review")
    private WebElement reviewField;

    @FindBy(id = "button-review")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='review-section']//span")
    private WebElement confirmationMessage;

    public void verifyPDP(){
        Assert.assertTrue(availability.isDisplayed());
        LOG.info("User is on PDP");
    }

    public void verifyReviewFormFields() {
        Assert.assertTrue(nameField.isDisplayed());
        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(reviewField.isDisplayed());
    }

    public void verifySubmitButton() {
        BrowserUtils.scrollToElement(submitButton);
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
    }

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterReview(String review) {
        reviewField.sendKeys(review);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void verifyConfirmationMessage(String message) {
        Assert.assertEquals(message,confirmationMessage.getText());
    }

}
