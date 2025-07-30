package com.demo.pages;

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

    public void verifyPDP(){
        Assert.assertTrue(availability.isDisplayed());
        LOG.info("User is on PDP");
    }

    public void verifySectionTitle(String expectedSectionTitle){
        String actualTitle = writeReviewSectionTitle.getText();

        Assert.assertEquals(expectedSectionTitle,actualTitle);
    }

}
