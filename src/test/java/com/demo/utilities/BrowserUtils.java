package com.demo.utilities;

import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
