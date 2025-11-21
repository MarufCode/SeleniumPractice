package org.example.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BTandATExample {


    // Atomic Test Cases
    // Means who dont have any dependency
    // They serve single purpose



    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        driver = new EdgeDriver();
    }

    @Test
    @Description()
    public void testLoginPositive(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        // CSS Selector format or syntax -> tagName id -> #, class -> ., Custom [@attribute=value]
        // * means contains, ^ means start with,












    }

    @Test
    @Description()
    public void testLoginNegative(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }




    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
