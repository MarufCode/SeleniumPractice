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

public class StaleElementException {


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
        driver.get("https://google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement el = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        el.sendKeys("SVKM NMIMS");



        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
