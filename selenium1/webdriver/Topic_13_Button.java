package webdriver;

//import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Topic_13_Button {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void initicalBrowser() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Fahasha() {
        driver.get("https://www.fahasa.com/customer/account/login/referer/aHR0cHM6Ly93d3cuZmFoYXNhLmNvbS9jdXN0b21lci9hY2NvdW50L2luZGV4Lw,,/");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        //isEnabled: nếu element mà nó enable thì trả về true/disable thì trả về false
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

//        // Viết từng step môt
//        String loginBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
//        Color loginColor = Color.fromString(loginBackgroundColor);
//        Assert.assertEquals(loginColor.asHex().toUpperCase(),"#000000");

        //Cách viết 1 step
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("dao@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");

        //Mong đợi enable
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

        driver.findElement(loginButton).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");

        Assert.assertEquals(driver.findElement(loginButton).getText(),"Đăng nhập");


//        WebElement loginButtonElement = driver.findElement(loginButton);
//        String loginButtonRGBA = loginButtonElement.getCssValue("background-color");
//
//        //RGBA
//        Color loginButtonColor =Color.fromString(loginButtonRGBA);
//        String loginButtonHexa = loginButtonColor.asHex();
//
//        //#C92127
//        String loginButtonHexaUpperCase = loginButtonHexa.toUpperCase();

    }

    @Test
    public void TC_02_Url() throws InterruptedException {
        driver.get("https://play.goconsensus.com/u5d5156df");
        Thread.sleep(10000);

        Assert.assertFalse(driver.findElement(By.cssSelector("button[data-testid='lead form continue']")).isEnabled());

        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
