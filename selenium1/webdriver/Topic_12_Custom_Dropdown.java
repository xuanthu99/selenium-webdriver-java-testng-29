package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
      public void initialBrowser() {
        Assert.assertNull(driver);

        driver = new ChromeDriver();

        Assert.assertNotNull(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().maximize();
    }
    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");


        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Slower");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Slower");

        selectItemInCustomDropdown("span#number-button", "ul#number-menu>li>div", "10");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"10");

        selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu>li>div", "Mrs.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");
    }
    // Dự án thực tế: 1 hàm đẻ thao tác lên 1 dropdown chỉ dùng cho 1 site/app
    // Ko dùng cho nhiều application khác
    // Cơ chế của dropdown giống nhau

    private void selectItemInCustomDropdown(String parentCss, String childCss,  String textItem) throws InterruptedException {
        //Hành vi để thao tác lên Dropdown
//        // 1- chờ cho dropdown có thể thao tác lên được (clickable)
//        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss)));
//
//        // 2- Click vào element nào để nó xổ ra cái dropdown ra
//        driver.findElement(By.cssSelector(parentCss)).click();

        // cách gộp 1 và 2 thành 1 dòng:
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();

        Thread.sleep(2000);

//        // 3- Chờ cho tất cả các item được load ra
//        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
//
//
//        // 4- Tìm cái item nào đúng với mong đợi
//        List<WebElement> allItems = driver.findElements(By.cssSelector(childCss));

        //Gộp 3 và 4 thành 1 dòng
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        // 5- Click lên item đó
        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                item.click();
               break;
            }
        }
    }

    @Test
        public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectOptionInCustomDropdown("div.dropdown","div.item>span","Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Matt");

        selectOptionInCustomDropdown("div.dropdown","div.item>span","Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Stevie Feliciano");
    }
    private void selectOptionInCustomDropdown(String parentCss, String childCss,  String textItem) throws InterruptedException {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }
    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectOptionInCustomDropdownTC3("li.dropdown-toggle","ul.dropdown-menu>li>a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

        selectOptionInCustomDropdownTC3("li.dropdown-toggle","ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");

        selectOptionInCustomDropdownTC3("li.dropdown-toggle","ul.dropdown-menu>li>a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");
    }
    private void selectOptionInCustomDropdownTC3(String parentCss, String childCss,  String textItem) throws InterruptedException {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

@Test
public void TC_04_Editable() throws InterruptedException {
    driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

    EnterOptionInCustomDropdown("input.search","div.item>span","Albania");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Albania");

    EnterOptionInCustomDropdown("input.search","div.item>span","Australia");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Australia");
}
    private void EnterOptionInCustomDropdown(String parentCss, String childCss,  String textItem) throws InterruptedException {
        // 1. Chờ cho dropdown có thể thao tác lên đươc visible
        // 2. Sendkey vào dropdown
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);

        Thread.sleep(2000);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        for (WebElement item: allItems){
            if(item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
