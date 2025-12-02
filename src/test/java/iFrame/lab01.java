package iFrame;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class lab01 {


    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description()
    @Owner("Maruf")
    public void testPositive() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Switch to iframe
        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        submit.click();


        WebElement username = driver.findElement(By.id("username"));
        WebElement err_element = driver.findElement(with(By.tagName("small")).below(username));
        String err_text = err_element.getText();
        Assert.assertEquals(err_text, "Username must be at least 3 characters");


        WebElement email = driver.findElement(By.id("email"));
        WebElement err_element_email = driver.findElement(with(By.tagName("small")).below(email));
        String err_txt_email = err_element_email.getText();
        Assert.assertEquals(err_txt_email, "Email is not invalid");

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
