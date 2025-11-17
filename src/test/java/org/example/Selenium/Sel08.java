package org.example.Selenium;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sel08 {


        // Open app.vwo.com
        // print the title and get the current url
        // verify the current url is app.vwo.com

    @Test()
    @Owner("Maruf")
    @Description("Verify the current URL amd Title of Youtube App")
    public void testLogin(){

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Youtube");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/");
        driver.close();



    }
}
