package DemoBlaze;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class DemoBlazeMain {
   static final WebDriver driver = utility.Webdriver("chrome");
   static DemoBlazeElements source = new DemoBlazeElements(driver);



   public static void main(String[] args){
       driver.manage().window().maximize();
       driver.get("https://www.demoblaze.com/");
       source.login();
//       source.loginForm("Selsonaladh", "hello"); /* valid */
       source.loginForm("sonaladh", "hello"); /* Invalid */

       source.loginClick();
       utility.acceptAlert();
       source.loginClose();



   }

}
