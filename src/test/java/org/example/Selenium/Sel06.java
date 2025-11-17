package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sel06 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close(); // -> Session id is not null - Invalid Session ID
        driver.quit(); //-> session id is null -  Error- Session ID is null










    }

}
