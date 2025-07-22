package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscribePage extends BasePage{
    private static final Logger LOG = LogManager.getLogger();

    @FindBy(id = "susbscribe_email")
    private WebElement inputEmail;

    @FindBy(id = "subscribe")
    private WebElement buttonSubscribe;

    //@FindBy(xpath = "//div[@id='success-subscribe']/div")
    @FindBy(css = "div#success-subscribe")
    private WebElement messageSuccess;

    public void enterEmailToSubscribe(String email){
        BrowserUtils.scrollToElement(inputEmail);
        inputEmail.sendKeys(email);
        BrowserUtils.waitElementVisibility(buttonSubscribe);
        buttonSubscribe.click();
    }

    public void verifySuccessMessage(String messageExpected){
        Assert.assertEquals("Success message does NOT match",messageExpected,messageSuccess.getText());
    }
}
