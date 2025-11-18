package org.example.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class miniChallenge {

    @Test
    @Description()
    public void testChallenge()  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        WebElement email_Address =  driver.findElement(By.id("login-username"));
        email_Address.sendKeys("ADMIN");

        WebElement password =  driver.findElement(By.id("login-password"));
        password.sendKeys("ADMIN");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
        String err_msg_text = error_msg.getText();

        Assert.assertEquals(err_msg_text, "Your email, password, IP address or location did not match");

        driver.quit();




    }
}
