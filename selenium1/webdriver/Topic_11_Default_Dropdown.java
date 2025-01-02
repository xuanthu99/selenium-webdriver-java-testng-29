package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;

public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    Actions actions;
    JavascriptExecutor jsExecutor;
    WebDriverWait expliciWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");


    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new ChromeDriver();
        // Nhận driver làm tham số
        // actions = new Actions(driver);
       // expliciWait = new WebDriverWait(driver, Duration.ofSeconds(15));
       // jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_01_Facebook_SignUp() {
        driver.get("https://www.facebook.com/r.php?entry_point=login");

//        // Ko giống hành vi của End User
//        driver.findElement(By.xpath("//select[@id='day']/option[text()='28']")).click();

        //dropdown xuất hiện
        select = new Select(driver.findElement(By.cssSelector("select#day")));

//        //select.selectByIndex(20);
//        // 1.Index
//        // đọc code ko biết tỉnh nào -> chạy fail khó reproduce lại
//        //Index thay đổi vị trí
//
//       // select.selectByValue("9433");
//        // 2. Value
//        // Option không bắt buộc phải có attribute value
//        //Đọc code ko biết tỉnh nào -> chạy fail khó reproduce lại
//        // Thêm một số bước để đi tìm nó là cái gì/ ở đâu
//
//        //select.selectByVisibleText("thành phố Hà Nội");
//        //3. Text
//        // Giống như EndUser chọn
//        // Không bị trùng dữ liệu/Ko để trống dữ liệu
//        // Ko thay đổi text nếu có đổi
//        // chạy fail dễ reproduce lại
//
        //Chọn 1 item
        select.selectByVisibleText("25");

        //Chọn xong verify đã chọn thành công hay chưa?
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");

//        //Verify cái dropdown có phải là multiple select hay không?
//        //Nếu là multiple -> trả về là true
//        //Nếu là single -> trả về là false
//        Assert.assertFalse(select.isMultiple());
//
//        //Verify tổng số lượng items trong dropdown này là bao nhiêu?
//        Assert.assertEquals(select.getOptions().size(),31);

        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Jun");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Jun");

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("2006");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "2006");

    }

    @Test
    public void TC_02_NopCommerce(){
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("");

        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("");

        driver.findElement(By.cssSelector("input#Email")).sendKeys("");
        driver.findElement(By.cssSelector("input#Company")).sendKeys("");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("");
        driver.findElement(By.cssSelector("input#ConfỉmPassword")).sendKeys("");
        driver.findElement(By.cssSelector("button#register-button")).click();



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
