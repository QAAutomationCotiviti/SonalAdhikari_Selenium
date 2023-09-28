package utilities;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class utility {
    public static WebDriver driver;
    public static WebDriver Webdriver(String browsername){
        driver = new ChromeDriver();
        return driver;
    }

    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }
    public static WebDriver acceptAlert(){
        sleep();
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
        return driver;
    }
}
