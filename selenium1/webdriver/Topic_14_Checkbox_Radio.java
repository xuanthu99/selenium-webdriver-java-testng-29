package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;

    JavascriptExecutor jsExcutor;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        jsExcutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Telerik() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        //verìfy checkbox/ radio is enabled/ disabled
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        //Verify checkbox/ radio is selected/ deselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());

        //Select to 'Dual-zone air conditioning' checkbox
//        driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).click();
        By dualZoneAirBy = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

//        //Scroll xuống thêm 1 đoạn 30px
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        //Nếu như chưa chọn thì mới click
        if (!driver.findElement(dualZoneAirBy).isSelected()) { //dấu chấm than trong lập trình java là phủ định lai 1 đièu kiệu
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneAirBy).isSelected());

        //De-select to 'Dual-zone air conditioning' checkbox (bỏ chọn)
        if (driver.findElement(dualZoneAirBy).isSelected()) { //đang chọn
            driver.findElement(dualZoneAirBy).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneAirBy).isSelected());

        //radio button
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By twoPetroBy = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        if (!driver.findElement(twoPetroBy).isSelected()) {
            driver.findElement(twoPetroBy).click();
        }
        Assert.assertTrue(driver.findElement(twoPetroBy).isSelected());
    }

    @Test
    public void TC_02_Multiple() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        //select all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        //Click all checkboxes
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        //Verify all checkboxes selected
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        //Deselect all checkboxes
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        // Verify all checkboxes deselected
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Venereal Disease']")).click();
        driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Venereal Disease']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='High Blood Pressure']")).isSelected());

        // Select 1 in all + verify
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected() && checkbox.getAttribute("value").equals("Heart Attack")) {
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Heart Attack']")).isSelected());


    }

    @Test
    public void TC_03_Ubuntu() {
    driver.get("https://login.ubuntu.com/");

    // Thẻ input: dùng có thể click
    // Dùng để verify: isSelected()

//    By newUserRadio = By.cssSelector("input#id_new_user");

    //1- Dùng thể input để click -> fail
    //Dùng thẻ input này để verify -> pass
//    driver.findElement(newUserRadio).click();
//    Assert.assertFalse(driver.findElement(newUserRadio).isSelected());

//    newUserRadio = By.cssSelector("label.new-user");
    //2- Dùng 1 thẻ khác input để click -> Pass
    //Dùng thẻ input này để verify -> Fail
    //isSelected() -> dùng cho thẻ input/option
//    driver.findElement(newUserRadio).click();
//    Assert.assertFalse(driver.findElement(newUserRadio).isSelected());


    //3- Dùng 1 thẻ khác input để click -> pass
    //Dùng thẻ này để verify -> pass
//    By newUserRadioLabel =By.cssSelector("label.new-user");
//    By newUserRadioInput =By.cssSelector("input#id_new_user");

//    driver.findElement(newUserRadioLabel).click();
//    Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());
//    //Thoả mãn được iu cầu

//    jsExcutor.executeScript("arguments[0].click()" , driver.findElement(newUserRadioInput));
//    Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

    //4 Dùng duy nhất thẻ input để click/verify dùng JS Executor
    By newUserRadioInput =By.cssSelector("input#id_new_user");
    jsExcutor.executeScript("arguments[0].click();", driver.findElement(newUserRadioInput));
    Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());

    By termCheckbox = By.cssSelector("input#id_accept_tos");
    jsExcutor.executeScript("arguments[0].click();", driver.findElement(termCheckbox));
    Assert.assertTrue(driver.findElement(termCheckbox).isSelected());
}

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
