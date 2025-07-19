package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class HomePage extends BasePage{
    private static final Logger LOG = LogManager.getLogger();

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a//b")
    private WebElement loggedInName;

    @FindBy (xpath = "//div[@id='slider-carousel']//h2")
    private WebElement carouselHeader;

    public void clickSignupLoginPage(){
        signupLoginLink.click();
    }

    public void verifyHomePage(){
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
    }

    public void verifyUsernameOnHomepage(Map<String, String> info){
        BrowserUtils.verifyTitle("Automation Exercise");
        Assert.assertEquals(info.get("name"), loggedInName.getText());
        LOG.info("Logged in as {}",loggedInName.getText());
        LOG.info("Expected logged in as {}",info.get("name"));
    }

    public WebElement getCarouselHeader() {
        return carouselHeader;
    }
}
