package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.util.List;

public class ebay_App_Challenge {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }


    @Test
    public void testPrintAllTitleOfSearchResult(){

        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        searchBox.sendKeys("macmini");

        WebElement searchBoxButton = driver.findElement(By.cssSelector("button#gh-search-btn"));
        searchBoxButton.click();

        // Wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


       List<WebElement> searchedTitle = driver.findElements(By.cssSelector("div.s-card__title"));
        for (WebElement title : searchedTitle){
            System.out.println(title.getText());
//            System.out.println(title.getSize());
        }

        List<WebElement> titlePrice = driver.findElements(By.xpath("//span[@class=\"su-styled-text primary bold large-1 s-card__price\"]"));
        for (WebElement title_price: titlePrice){
            System.out.println(title_price.getText());
        }


    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }







}