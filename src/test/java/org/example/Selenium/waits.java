package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class waits {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }


    @Test
    public void testWaitsInSelenium() {

        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Global wait to all the elements which we don't use

       driver.findElement(By.id("login-username")).sendKeys("maruf.sherkar.ext@nmims.edu");

        driver.findElement(By.id("login-password")).sendKeys("Mahibhai@7");

        driver.findElement(By.id("js-login-btn")).click();

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa=\"lufexuloga\"]")));
        WebElement loggedIn_username = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]"));


        System.out.println("LoggedIn Username will be printed" + loggedIn_username.getText());



        // Fluent Wait
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement loggedIn_username = driver.findElement(By.cssSelector("[data-qa=\"lufexuloga\"]"));
//
//        System.out.println("LoggedIn Username will be printed" + loggedIn_username.getText());
    }




    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}
