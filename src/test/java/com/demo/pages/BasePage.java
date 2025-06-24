package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
