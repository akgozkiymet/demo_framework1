package com.demo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * get date and current time as a string
     * @return date and time as string
     */

    public static String getTimeStamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMMddHHmm");

        String dateTimeString = now.format(formatter);
        return dateTimeString;
    }

    /**
     * verify page title
     * @param title of the page
     */
    public static void verifyTitle(String title){
        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }

    /**
     *
     * @param webElements list elements to extract text from
     * @return list of string containing the text of web elements
     */
    public static List<String> extractText(List<WebElement> webElements){
        List<String> elementsText = new ArrayList<>();

        for (WebElement date : webElements) {
            elementsText.add(date.getText());
        }
        return elementsText;
    }

    /**
     *
     * @param element to wait for until visible in the page
     */
    public static void waitElementVisibility(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
