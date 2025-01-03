package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    Actions actions;
    JavascriptExecutor jsExecutor;
    WebDriverWait expliciWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    Random rand;
    String firstName, lastName, emailAddress, companyName, password, date, month, year;

    @BeforeClass
    public void initialBrowser() {

        driver = new ChromeDriver();
        // Nhận driver làm tham số
        // actions = new Actions(driver);
        // expliciWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // jsExecutor = (JavascriptExecutor) driver;

        rand = new Random();

        firstName = "Scot";
        lastName = "Wathan";
        emailAddress = "abc" + rand.nextInt(99999) + "@gmail.com";
        companyName = "Flashdog";
        date ="12";
        month = "August";
        year = "1996";
        password = "Abcd@1234";
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
    public void TC_02_NopCommerce() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);

        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText(date);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText(year);

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#registPasswordr-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.registration-result-page div.result")).getText(), "Your registration completed");

        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password );
        driver.findElement(By.cssSelector("button.login-button")).click();

        driver.findElement(By.cssSelector("a.ico-account")).sendKeys("");

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

        //cách viết tách ra (mình chỉ dùng 1 lần ko nên khai báo biến)
        Select dateDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay]")));
        Assert.assertEquals(dateDropdown.getFirstSelectedOption().getText(), "");

        //cách viết gộp lai các
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay]"))).getFirstSelectedOption().getText(), date);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth]"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear]"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);


        //Login
        driver.findElement(By.cssSelector("input#Email")).sendKeys("");

        //My account
        driver.findElement(By.cssSelector("input#Email")).sendKeys("");


    }

    @Test
    public void TC_03_Rode() {
        driver.get("https://rode.com/en/support/where-to-buy#");

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("VietNam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.cssSelector("button.btn.default")).click();

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));

        Assert.assertEquals(dealers.size(),82);

        for(WebElement element: dealers){
            System.out.println(element.getText());
        }

    }
//        //for classic
//        for (int i = 0; i < dealers.size(); i++){
//           System.out.println(dealers.get(i).getText());
//        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
