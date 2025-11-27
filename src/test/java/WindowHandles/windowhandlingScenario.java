package WindowHandles;

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

import java.util.Set;

public class windowhandlingScenario {


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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
//        driver.manage().window().maximize();


        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before click " + mainWindowHandle);

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles){
            driver.switchTo().window(handle);
            System.out.println("After Click " + handle);
            if (driver.getPageSource().contains("New Window")){
                System.out.println("TC is Passed");
                Thread.sleep(2000);
            }
        }

        driver.switchTo().window(mainWindowHandle);
//        driver.quit();
        Thread.sleep(3000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
