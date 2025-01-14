package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_18_Action_PartII {
    WebDriver driver;
    Actions action;

    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
    }
    @Test
    public void TC_01_Click_And_Hold_Bloc() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        driver.findElement(By.cssSelector("ol#selectable>li"));

        List <WebElement>  allNumber =  driver.findElements(By.cssSelector("ol#selectable>li"));

        Actions action;
        action.clickAndHold(allNumber.get(0)) //click vào số 1 vào giữ chuột
                .moveToElement(allNumber.get(3)) // Di chuyển chuột tới số 4
                .release() //nhả chuột trái ra -kết thúc cho sự kiện clickAndHol()
                .perform();  // Thực thi câu lệnh trên nếu ko có perform ko thực thi

        Thread.sleep(4000);
        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(),20);

        //Nhấn phím contol xuống mà chưa nhả ra
        action.keyDown(Keys.CONTROL).perform();
        action.click(allNumber.get(0))


       // action.clickAndHold(allNumber.get(0));
        }

    @Test
    public void TC_02_Url(){

        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
