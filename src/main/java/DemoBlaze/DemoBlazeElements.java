package DemoBlaze;

import org.openqa.selenium.*;
import utilities.utility;

import java.util.concurrent.TimeUnit;

public class DemoBlazeElements {
    WebDriver driver;
    private final By loginBtn = By.id("login2");
    private final By user = By.id("loginusername");
    private final By pass = By.id("loginpassword");
    private final By login = By.xpath("//*[@onclick='logIn()']");
    private final By logClose = By.xpath("//button[@class='btn btn-secondary']");


//----creating constructor to initialize driver, or else its value will be null
    public DemoBlazeElements(WebDriver driver) {
        this.driver = driver;
    }

    public void login(){
        driver.findElement(loginBtn).click();
    }
    public void loginForm(String username, String password){
        utility.sleep();
        driver.findElement(user).sendKeys(username);
        driver.findElement(pass).sendKeys(password);
    }
    public void loginClick(){
        driver.findElement(login).click();

    }
    public void loginClose(){
        utility.sleep();
//        problem block
        JavascriptExecutor javaClose = (JavascriptExecutor) driver;
        javaClose.executeScript("arguments[0].click();",driver.findElement(logClose));
        System.out.println("helloo");

    }

}
