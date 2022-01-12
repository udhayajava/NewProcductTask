package com.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seleniumBase.MyBrowser.driver;
import static seleniumBase.MyBrowser.properties;

public class SearchTest {
    List<WebElement> stringList;
    List<String> productList;
    List<WebElement> priceList;
    WebElement showedContent;
    LinkedHashMap<String, Double> map;
    Double maxValue;
    Double minValue;

    public void verifySearchContent() {
        showedContent = driver.findElement(By.xpath(properties.getProperty("ShowedResult")));
        stringList = driver.findElements(By.xpath(properties.getProperty("SearchList")));
        System.out.println("-----" + showedContent.getText() + "-----");
        productList = new ArrayList<String>();
        for (WebElement element : stringList) {
            System.out.println(element.getText());
            productList.add(element.getText());
        }

    }

    public void searchProduct() {
        List<String> priceInString = new ArrayList<>();
        priceList = driver.findElements(By.xpath(properties.getProperty("priceXpath")));
        map = new LinkedHashMap<>();
        List<Double> priceInNum = new ArrayList<>();
        for (WebElement element1 : priceList) {
            System.out.println(element1.getText());
            priceInString.add(element1.getText().replaceAll("[₹,]", ""));
        }
        for (String list : priceInString) {
            priceInNum.add(Double.valueOf(list));
        }
        for (int i = 0; i < stringList.size(); i++) {
            map.put(productList.get(i), priceInNum.get(i));
        }
    }

    public void verifySearchResult() {
        for (WebElement str1 : stringList) {
            String checkSearch = str1.getText();
           boolean isPresent = checkSearch.toLowerCase().indexOf(properties.getProperty("SearchText"))!=1;
           if (isPresent){
               System.out.println("Search product result is correct");
           }else{
               System.out.println("Search product related to-->"+properties.getProperty("SearchText"));
           }
            }

        }




    public void findMaxAndMinPriceOfProduct() {
        maxValue = Collections.max(map.values());
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println(
                        "Maximum price is ₹" + Collections.max(map.values()) +
                                "for the product " + entry.getKey());
            }
        }
        minValue = Collections.min(map.values());
        for (Map.Entry<String, Double> minEntry : map.entrySet()) {
            if (minEntry.getValue().equals(minValue)) {
                System.out.println(
                        "Minimum Price  is ₹" + Collections.min(map.values()) +
                                "for the product " + minEntry.getKey());
            }
        }
    }
    public void addToCart(){


    }



}
