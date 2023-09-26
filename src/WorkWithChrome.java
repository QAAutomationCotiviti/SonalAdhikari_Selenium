import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;

import javax.swing.*;

public class WorkWithChrome {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

//        WebElement search = driver.findElement(By.id("APjFqb"));
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys("automation using selenium");
//        search.sendKeys(Keys.ENTER);
        Actions action = new Actions(driver);
        action.moveByOffset(10, 10).click().build().perform();
//        WebElement button = driver.findElement(By.name("btnK"));

//        driver.close();

    }
}
