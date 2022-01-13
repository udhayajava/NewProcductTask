package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static Reusables.Use.*;
import static seleniumBase.MyBrowser.properties;

public class SearchTest {
    List<WebElement> stringList;
    List<String> productList;
    List<WebElement> priceList;
    WebElement showedContent;
    LinkedHashMap<String, Double> map;
    Double minValue;
    static String str1;


    public void verifySearchContent() {
        showedContent = driver.findElement(By.xpath(properties.getProperty("ShowedResult")));
        stringList = driver.findElements(By.xpath(properties.getProperty("SearchList")));
        System.out.println("-----" + showedContent.getText() + "-----");
        productList = new ArrayList<>();
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
        for (int count = 0; count < stringList.size(); count++) {
            map.put(productList.get(count), priceInNum.get(count));
        }

    }

    public void verifySearchResult() {
        for (WebElement str1 : stringList) {
            String checkSearch = str1.getText();
            boolean isPresent = checkSearch.toLowerCase().indexOf(properties.getProperty("SearchText")) != 1;
            if (isPresent) {
                System.out.println("Search product result is correct");
            } else {
                System.out.println("Search product related to-->" + properties.getProperty("SearchText"));
            }
        }

    }


    public void findMaxAndMinPriceOfProduct() {
        minValue = Collections.min(map.values());
        for (Map.Entry<String, Double> minEntry : map.entrySet()) {
            if (minEntry.getValue().equals(minValue)) {
                System.out.println(
                        "Minimum Price  is ₹" + Collections.min(map.values()) +
                                "for the product " + minEntry.getKey());
                str1 = minEntry.getKey();
            }
        }
    }

    public void productInStock() {
        driver.findElement(By.xpath(properties.getProperty("ProductIsInStock") + str1 + "']")).click();
        myWindowsHandle();
        WebElement click = driver.findElement(By.xpath(properties.getProperty("PinCode")));
        jsClick(click);
        WebElement pinCodeBox = driver.findElement(By.xpath(properties.getProperty("PinCodeBox")));
        inputText(pinCodeBox, properties.getProperty("NumCode"));
        String outOfStock = driver.findElement(By.xpath("//h2[starts-with(text(),'Sorry, product sold out')]")).getText();
        boolean isInStock = outOfStock.toLowerCase().contains("sold out");
        if (isInStock) {
            System.out.println("Sorry, product sold out-->out of stock in your PinCode");
        } else {
            System.out.println("product is in stock and available in your area");
        }


    }
    public void addToCart(){

    }

}
