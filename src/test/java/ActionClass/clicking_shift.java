package ActionClass;

import com.beust.ah.A;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class clicking_shift {


    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description
    @Owner("Maruf")
    public void testPositive() throws InterruptedException {
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();


//        Shift Keydown -> MARUF + Keydown
        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName, "maruf")
                .keyUp(Keys.SHIFT)
                .build().perform();


        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
