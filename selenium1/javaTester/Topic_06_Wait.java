package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_06_Wait {
        WebDriver driver;

        WebDriverWait explicitWait;

        FluentWait<WebDriver> fluentWait;

        @BeforeClass
        public void initialBrowser() {

            driver = new ChromeDriver();

            //Explicit Wait
            explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

            //Implicit Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();

            // Fluent Wait
            fluentWait = new FluentWait<WebDriver>(driver);


        }
        @Test
        public void TC_01_() {
           // List<WebElement> allitems = driver.findElements(By.cssSelector(""));
            explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

            //nội bộ của testcase 1 thôi
            fluentWait = new FluentWait<WebDriver>(driver);


        }
    @Test
    public void TC_02_() throws InterruptedException {
            //Thread.sleep("3000");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
    }
}
