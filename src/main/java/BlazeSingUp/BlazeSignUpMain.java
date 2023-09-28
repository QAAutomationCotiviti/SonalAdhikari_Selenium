package BlazeSingUp;

import DemoBlaze.DemoBlazeElements;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class BlazeSignUpMain {
    static final WebDriver driver = utility.Webdriver("chrome");
    static BlazeSignupElements Sign_source = new BlazeSignupElements(driver);

    public static void main(String[] args) {
       driver.manage().window().maximize();
       driver.get("https://www.demoblaze.com/");
        Sign_source.clickSignup();
        Sign_source.SignUp("Selsonaladh","hello");
        utility.acceptAlert();
    }
}
