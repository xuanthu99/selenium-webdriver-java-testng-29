package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_17_Action {
    WebDriver driver;
    Actions action;

    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void initialBrowser() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
        //WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

       // Select select = new Select(driver.findElement(By.cssSelector("select#day")));

    }
    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip//");

        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        action.moveToElement(ageTextbox).perform();
        Thread.sleep(2000);

        //Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");


        }

//    @Test
//    public void TC_02_Hover_Myntra() throws InterruptedException {
//        driver.get("https://www.myntra.com/");
//        action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"))).perform();
//        Thread.sleep(2000);
//
////        // web element click()
////        driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();
//
//        //Action click()
//        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();
//        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(),"Kids Home Bath");
//    }

    @Test
    public void TC_03_Hover_Fahasha() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
//        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.xpath("//span[@class='menu-title' and text()='FOREIGN BOOKS']"))).perform();
        action.click(driver.findElement(By.xpath("//a[text()='Romance']")));
        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Romance']")).getText(),"Romance");


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
