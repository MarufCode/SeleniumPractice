package RelativeLocators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class lab02 {


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
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement searchElement = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchElement.sendKeys("India" + Keys.ENTER);

        Thread.sleep(5000);

        List<WebElement> list_of_states = driver.findElements(By.xpath("//div[@class=\"flex flex-col max-sm:gap-[0.5em]\"]/a"));

        for (WebElement l: list_of_states){
            String s1 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();

            System.out.println(l.getText() + " -> " + s1 + " -> " + s2);
        }


        Thread.sleep(13000);



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
