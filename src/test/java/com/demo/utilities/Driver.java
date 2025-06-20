package com.demo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browser = ConfigurationReader.getProperty("browser");

        if (driver == null) {
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            } else if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
