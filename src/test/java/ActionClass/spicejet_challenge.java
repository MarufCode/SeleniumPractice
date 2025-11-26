package ActionClass;

import com.beust.ah.A;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class spicejet_challenge {


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
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
//        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input")));

       //  move to element
        WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source).click().perform();
        actions.moveToElement(source).click().sendKeys("MUM").build().perform();


        WebElement destination = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div/div/input"));
        actions.moveToElement(destination).click().perform();
        actions.moveToElement(destination).sendKeys("DEL").build().perform();

        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
