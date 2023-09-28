package BlazeSingUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class BlazeSignupElements {
    WebDriver driver;

    public BlazeSignupElements (WebDriver driver){
        this.driver = driver;
    }

    private final By SignupBtn =By.id("signin2");
    private final By SignUser = By.id("sign-username");
    private final By SignPass = By.id("sign-password");
    private final By SignUp = By.xpath("//*[@onclick='register()']");

    public void clickSignup(){
        driver.findElement(SignupBtn).click();
    }
    public void SignUp(String username, String password){
        utility.sleep();
        driver.findElement(SignUser).sendKeys(username);
        driver.findElement(SignPass).sendKeys(password);
        driver.findElement(SignUp).click();
    }


}
