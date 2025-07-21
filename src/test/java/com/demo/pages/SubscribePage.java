package com.demo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
}
