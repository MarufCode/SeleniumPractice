package org.example.Dropdown;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class webtables {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    @Owner("Maruf")
    public void testPositive() throws InterruptedException {
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";

        String second_part = "]/td[";

        String third_part = "]";

        int row = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();

        int col = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i = 2; i <=row ; i++) {
            for (int j = 1; j <=col; j ++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);
                if(data.contains("Helen Bennett")){

                    String country_path = dynamic_xpath + "/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("---------");
                    System.out.println("Helen Bennett is in -> " + country_text);
                }
            }
        }




        Thread.sleep(5000);

//









    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
