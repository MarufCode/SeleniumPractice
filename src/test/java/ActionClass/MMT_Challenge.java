package ActionClass;

import com.beust.ah.A;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MMT_Challenge {


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
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));


        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("Mumbai").build().perform();

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//*[@class=\"react-autosuggest__suggestions-container react-autosuggest__suggestions-container--open\"]/div/ul/li"));


        for (WebElement e: list_auto_complete){
            if (e.getText().contains("BOM")){
                e.click();
                break;
            }
        }




        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
