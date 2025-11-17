package org.example.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Sel07 {
    public static void main(String[] args) throws MalformedURLException {


        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");
        driver.navigate().to("https://youtube.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
