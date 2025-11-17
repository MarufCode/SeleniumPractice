package org.example.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Sel05 {

    public static void main(String[] args) {

//        WebDriver dr = new EdgeDriver();
//        WebDriver web = new EdgeDriver();

        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);
        options.addArguments("--incognito");


        // Page Load strategy

        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver.get("https:youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();





    }
}
