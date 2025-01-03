package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
      public void initialBrowser() {

        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() {
        //Hành vi để thao tác lên Dropdown
        // 1- chờ cho dropdown có thể thao tác lên được (clickable)
        // 2- Click vào element nào để nó xổ ra cái dropdown ra
        // 3- Chờ cho tất cả các item được load ra
        // 4- Tìm cái item nào đúng với mong đợi
        // 5- Click lên item đó

        }

    @Test
    public void TC_02_Url(){

        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
