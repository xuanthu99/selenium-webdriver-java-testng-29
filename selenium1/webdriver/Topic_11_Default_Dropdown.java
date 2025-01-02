package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

        driver = new FirefoxDriver();
        // Nhận driver làm tham số
        // actions = new Actions(driver);
       // expliciWait = new WebDriverWait(driver, Duration.ofSeconds(15));
       // jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_01_Facebook_SignUp() {
        driver.get("https://www.facebook.com/r.php?entry_point=login");

        driver.findElement(By.xpath("//select[@id='day']/option["))

//        //dropdown xuất hiện
//        select = new Select(driver.findElement(By.cssSelector("select#day")));
//
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
//        //Chọn 1 item
//        select.selectByVisibleText("25");
//
//        //Chọn xong verify đã chọn thành công hay chưa?
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");
//
//        //Verify cái dropdown có phải là multiple select hay không?
//        //Nếu là multiple -> trả về là true
//        //Nếu là single -> trả về là false
//        Assert.assertFalse(select.isMultiple());
//
//        //Verify tổng số lượng items trong dropdown này là bao nhiêu?
//        Assert.assertEquals(select.getOptions().size(),31);





        }

    @Test
    public void TC_02_Url(){

        }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
