package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import seleniumBase.MyBrowser;


import static Reusables.Use.inputText;
import static Reusables.Use.driver;

public class WelcomePage extends MyBrowser {



    public boolean urlCheck() {
        return driver.getCurrentUrl().equals(properties.getProperty("Url"));
    }

    public boolean logoIsDisplayed() {
        return driver.findElement(By.xpath(properties.getProperty("LogoXpath"))).isDisplayed();
    }

    public boolean searchButton() {
        return driver.findElement(By.xpath(properties.getProperty("SearchButton"))).isDisplayed();
    }

    public boolean orderButton() {
        return driver.findElement(By.xpath(properties.getProperty("OrderButton"))).isDisplayed();
    }


    public void searchBox() {
        WebElement searchBox = driver.findElement(By.xpath(properties.getProperty("SearchBox")));
        inputText(searchBox, properties.getProperty("SearchText"));
    }


}


