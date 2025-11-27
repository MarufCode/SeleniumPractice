package ActionClass;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class draganddrop {


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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

//        actions.dragAndDrop(from, to).perform();
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

        Thread.sleep(3000);

        driver.get("https://the-internet.herokuapp.com/upload");

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        WebElement upload_File = driver.findElement(By.id("file-upload"));
        upload_File.sendKeys(dir + "\\src\\test\\java\\ActionClass\\to_Upload.txt");

        driver.findElement(By.id("file-submit")).click();
        System.out.println("File Uploaded Successfully");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
