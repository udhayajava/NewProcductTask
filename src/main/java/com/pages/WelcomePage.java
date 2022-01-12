package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumBase.MyBrowser;

import java.util.*;

public class WelcomePage extends MyBrowser {

    WebDriverWait wait;

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


    public void searchBox(String searchText) {
        WebElement searchBox = driver.findElement(By.xpath(properties.getProperty("searchBox")));
        searchBox.sendKeys(searchText + Keys.ENTER);
    }




}


