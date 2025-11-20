package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Sel09 {

   @Test
   public void testAnchorTag(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

//        WebElement anchor_tag = driver.findElement(By.partialLinkText("Start a "));
//        Object anchor_attribute = anchor_tag.getAttribute("href");
//        anchor_tag.click();
//        Assert.assertEquals(anchor_attribute, "https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");


        // Now i want to print all the anchor tag present on the website

       List<WebElement> all_aTags = driver.findElements(By.tagName("a"));
       all_aTags.get(0).click();
//     all_aTags.get(1).click();
       all_aTags.size();
       for (WebElement webElement : all_aTags){
           System.out.println(webElement.getText());
       }



        driver.close();



    }
}
