import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Weather {
    static WebDriver driver = new ChromeDriver();
    public static void getWeather(String s){
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.clear();
        search.sendKeys(s+" weather in kathmandu");
        search.sendKeys(Keys.ENTER);
        String temp = driver.findElement(By.id("wob_tm")).getText();
        String day = driver.findElement(By.id("wob_dts")).getText();
        String status = driver.findElement(By.id("wob_dcp")).getText();
        WebElement deg = driver.findElement(By.xpath("//*[@aria-label='°Celsius']"));
        String celsius = deg.getText();
        System.out.println("\n"+"Weather: " +day + "\n"+
                "temperature: "+temp + celsius + "\n"+"status: "+ status);
    }
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        WebElement translate = driver.findElement(By.xpath("//*[@id='SIvCob']/a"));
        translate.click();

        getWeather("today's");
        getWeather("tomorrow's");
    }
}