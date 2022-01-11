package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumBase.MyBrowser;

import java.time.Duration;
import java.util.*;

public class WelcomePage extends MyBrowser {
    List<String> stringList;
    List<WebElement> searchList;
    List<WebElement> priceList;
    WebElement showedContent;
    WebDriverWait wait;

    public boolean urlCheck() {
        if (driver.getCurrentUrl().equals(properties.getProperty("Url"))) {
            return true;
        }
        return false;
    }

    public boolean logoIsDisplayed() {
        return driver.findElement(By.xpath(properties.getProperty("LogoXpath"))).isDisplayed();
    }

    public boolean womenButton() {
        return driver.findElement(By.xpath(properties.getProperty("WomenButton"))).isDisplayed();
    }

    public boolean dressesButton() {
        return driver.findElement(By.xpath(properties.getProperty("DressButton"))).isDisplayed();
    }

    public boolean tShirtButton() {
        return driver.findElement(By.xpath(properties.getProperty("T-ShirtButton"))).isDisplayed();

    }

    public WelcomePage searchBox(String searchText) {
        WebElement searchBox = driver.findElement(By.xpath(properties.getProperty("searchBox")));
        searchBox.sendKeys(searchText + Keys.ENTER);
        return this;
    }


    public List<String> verifySearchContent() {
        showedContent = driver.findElement(By.xpath(properties.getProperty("ShowedResult")));
        searchList = driver.findElements(By.xpath(properties.getProperty("SearchList")));
        System.out.println(showedContent.getText());
        stringList = new ArrayList<>();
        for (WebElement element : searchList) {
            System.out.println(element.getText());
            stringList.add(element.getText());
        }

        return stringList;
    }

    public LinkedHashMap<String, Double> searchProduct() {
        List<String> priceInString = new ArrayList<>();
        priceList = driver.findElements(By.xpath(properties.getProperty("priceXpath")));
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();
        List<Double> priceInNum = new ArrayList<>();
        for (WebElement element1 : priceList) {
            System.out.println(element1.getText());
            priceInString.add(element1.getText().replaceAll("[$]", ""));
        }
        System.out.println(priceInString);
        for (String list : priceInString) {
            priceInNum.add(Double.valueOf(list));
        }
        for (int i = 0; i < stringList.size(); i++) {
            map.put(stringList.get(i), priceInNum.get(i));
        }
        System.out.println(map);
        System.out.println("Maximum Price " + Collections.max(map.values()) + " is for " + Collections.max(map.keySet()));
        System.out.println("Minimum Price " + Collections.min(map.values()) + "is for " + Collections.min(map.keySet()));
        return map;
    }

}


