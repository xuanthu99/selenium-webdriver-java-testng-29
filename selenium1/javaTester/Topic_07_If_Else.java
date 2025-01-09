package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_07_If_Else {
    public static void main (String[] args) {
        WebDriver driver;
        String osName = System.getProperty("os.Name");
        String browserName = "Chrome";

        //biểu thức điều kiện
        //if (đúng 1 điều kiện)
        if (browserName.equals("IE")){
            System.out.println("Click to SUBMIT button");
        }

        //if-else (có 2 đk)
        if (osName.contains("Windows")){
            System.out.println("Window OS");

        } else {
            System.out.println("MAC or LinuxOS");
        }
        System.out.println(osName);

        //if-else-if-else (hơn 2 điều kiện)
        if (browserName.equals("Chome")){
            driver = new ChromeDriver();
        }else if (browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        }else{
            driver = new EdgeDriver();
        }
        // switch-case
        switch (browserName){
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Chome":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }

    }
}
