package SeleniumException;

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

public class NoSuchElementException {


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

//        // Switch to iframe
//        driver.switchTo().frame("result");

        // Will throw NoSuchElementException
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        submit.click();

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
