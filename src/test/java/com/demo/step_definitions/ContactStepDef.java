package com.demo.step_definitions;

import com.demo.pages.ContactUsPage;
import com.demo.pages.HomePage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactStepDef {

    ContactUsPage contactPage = new ContactUsPage();
    HomePage homePage = new HomePage();

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user clicks on Contact Us")
    public void the_user_clicks_on_contact_us() {
        homePage.clickContactUsButton();
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String string) {
        BrowserUtils.waitElementVisibility(contactPage.contactHeader);
        Assert.assertEquals(string, contactPage.contactHeader.getText());
    }

    @When("the user enters name, email, subject, and message")
    public void the_user_enters_name_email_subject_and_message() {
        contactPage.fillContactForm("Kıymet", "akgozkiymet@gmail.com", "Return fee", "Fee taken for return");
    }

    @When("the user uploads a file")
    public void the_user_uploads_a_file() {
        contactPage.uploadFile("/Users/kiymet/IdeaProjects/demo_framework");
    }

    @When("clicks Submit")
    public void clicks_submit() {
        contactPage.clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }


    @Then("an alert should appear with {string}")
    public void an_alert_should_appear_with(String expectedMessage) {
        BrowserUtils.waitElementVisibility(contactPage.successMessage);
        String actualMessage = contactPage.successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("the user clicks Home")
    public void the_user_clicks_home() {
        homePage.clickHomeButton();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String expectedUrl = ConfigurationReader.getProperty("url");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
