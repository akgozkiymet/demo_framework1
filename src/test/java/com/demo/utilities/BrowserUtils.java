package com.demo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
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
     * @param title
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
}
