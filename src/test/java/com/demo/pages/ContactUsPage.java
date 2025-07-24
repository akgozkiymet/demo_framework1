package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "subject")
    public WebElement subjectInput;

    @FindBy(name = "message")
    public WebElement messageInput;

    @FindBy(name = "upload_file")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitButton;

    @FindBy(css = "div.contact-form h2.title.text-center")
    public WebElement contactHeader;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement successMessage;

    public void fillContactForm(String name, String email, String subject, String message) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        chooseFile.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
