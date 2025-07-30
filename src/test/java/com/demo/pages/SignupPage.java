package com.demo.pages;


import com.demo.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class SignupPage extends BasePage{
    Faker faker = new Faker();
    private static final Logger LOG = LogManager.getLogger();

    //signup form page
    @FindBy(xpath = "//h2/b[text()='Enter Account Information']")
    private WebElement accountInfoHeader;
    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement gender;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;
    @FindBy(id = "days")
    private WebElement daysDropdown;
    @FindBy(id = "months")
    private WebElement monthsDropdown;
    @FindBy(id = "years")
    private WebElement yearsDropdown;
    @FindBy(id = "country")
    private WebElement countryDropdown;
    @FindBy(id = "first_name")
    private WebElement firstName;
    @FindBy(id = "last_name")
    private WebElement lastName;
    @FindBy(id = "address1")
    private WebElement address;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "zipcode")
    private WebElement zipcode;
    @FindBy(id = "mobile_number")
    private WebElement mobileNum;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//h2/b")
    private WebElement accountCreatedHeader;

    @FindBy(xpath = "//h2/following-sibling::p")
    private WebElement accountCreationMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public void verifyAccountInfoHeader(){
        Assert.assertTrue(accountInfoHeader.isDisplayed());
    }

    public void fillInfoAndClickCreateAccount(){
        Random random = new Random();
        Select days = new Select(daysDropdown);
        Select months = new Select(monthsDropdown);
        Select years = new Select(yearsDropdown);
        Select country = new Select(countryDropdown);

        gender.click();
        password.sendKeys(ConfigurationReader.getProperty("password"));

        days.selectByValue(String.valueOf(random.nextInt(1,29)));
        months.selectByValue(String.valueOf(random.nextInt(1,13)));
        years.selectByVisibleText("1993");

        LOG.info("Selected day: {} and month: {}",days.getFirstSelectedOption().getText(), months.getFirstSelectedOption().getText());

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        address.sendKeys(faker.address().fullAddress());
        country.selectByVisibleText("Canada");
        state.sendKeys(faker.address().state());
        city.sendKeys(faker.address().city());
        zipcode.sendKeys(faker.address().zipCode());
        mobileNum.sendKeys(faker.phoneNumber().phoneNumber());
        createAccountButton.click();

    }

    public void verifyAccountCreationMessage(String message){
        Assert.assertEquals(message, accountCreationMessage.getText());
    }

    public void verifyAccountCreatedHeader(String headerText){
        Assert.assertEquals(headerText, accountCreatedHeader.getText());
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
