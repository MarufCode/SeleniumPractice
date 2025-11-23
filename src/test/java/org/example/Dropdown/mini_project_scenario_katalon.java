package org.example.Dropdown;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mini_project_scenario_katalon {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify the book appointment is confirmed by valid data")
    @Owner("Maruf")
    public void testPositive() throws InterruptedException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("btn-make-appointment")).click();

        driver.findElement(By.id("txt-username")).sendKeys("John Doe");

        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(2000);

        WebElement facility = driver.findElement(By.xpath("//select[@id=\"combo_facility\"]"));
        Select select = new Select(facility);
        select.selectByIndex(2);

        driver.findElement(By.id("txt_visit_date")).sendKeys("23/11/2025");

        driver.findElement(By.id("txt_comment")).sendKeys("comment Hello Automation 123");

        driver.findElement(By.id("btn-book-appointment")).click();

        WebElement confirm = driver.findElement(By.id("summary"));

        String confirm_msg_txt = confirm.getText();
        Assert.assertTrue(confirm_msg_txt.contains("comment"));
        System.out.println(confirm_msg_txt);









        Thread.sleep(5000);

//









    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
