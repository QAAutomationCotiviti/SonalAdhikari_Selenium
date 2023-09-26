import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// test cases
//        wrong username wrong pass
//        wrong username right pass
//        right user wrong pass
//        right user right pass
//
//        empty user empty pass
//        empty user correct pass
//        right user empty pass

//       check for all users

//check invalid characters , case sensitivity



public class Login {
    static WebDriver driver = new ChromeDriver();

    public static void Cases(String user, String pass){
        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(pass);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String nextPageUrl = "https://www.saucedemo.com/inventory.html";
        String url = driver.getCurrentUrl();
//        System.out.println("current url : "+url);
        if (url.equals(nextPageUrl)) {

            System.out.println("login successful\n");
            System.out.println("Item Details: \n");
            for (int i=1; i<=5; i++)
            {
                details(i);
            }
            sort(3);

            System.out.println("Displaying Price and Name of product");
            getItemList();

            addToCart();
            checkFromCart();

            openCart();
            removeFromCart();
            addToCart();
            openCart();

            checkout();

            form();
            finish();




        }
        else {
            String err_msg = driver.findElement(By.xpath("//*[@class='error-message-container error']")).getText();
            System.out.println(user+" : "+err_msg);
        }


    }
    public static void form(){
        WebElement fName = driver.findElement(By.id("first-name"));
        fName.sendKeys("sonal");
        WebElement lName = driver.findElement(By.id("last-name"));
        lName.sendKeys("adhikari");
        WebElement pCode = driver.findElement(By.id("postal-code"));
        pCode.sendKeys("42503");
        WebElement continues = driver.findElement(By.id("continue"));
        continues.click();

    }
    public static void finish(){
        WebElement fin = driver.findElement(By.id("finish"));
        fin.click();
    }
    public static void checkout(){
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
    }
    public  static void openCart(){
        WebElement checkCart = driver.findElement(By.className("shopping_cart_link"));
        checkCart.click();
    }
    public static void addToCart() {
        System.out.println("in add to cart");
        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cart.click();
    }

    public static void checkFromCart(){
        String checkcart = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        if (checkcart.equals("Remove")){
            System.out.println("Added to cart Successfullyy!!!!");
        }
        else {
            System.out.println("Not Added!!!");
        }
    }
    public static void removeFromCart(){
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        remove.click();
        System.out.println("Item Removed from cart.");
        delay();
        WebElement continueShop = driver.findElement(By.id("continue-shopping"));
        continueShop.click();

    }

    public static void getItemList(){
        List<WebElement> getElement = driver.findElements(By.className("inventory_item"));

        for (WebElement getElements : getElement) {
            String name = getElements.findElement(By.className("inventory_item_name")).getText();
            System.out.println("\n"+name);
            String price = getElements.findElement(By.className("inventory_item_price")).getText();
            System.out.println(price);
        }

    }
    public static void delay(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Logout(){
        WebElement hamburger_icon = driver.findElement(By.id("react-burger-menu-btn"));
        hamburger_icon.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement clicking = driver.findElement(By.xpath("//*[@id='logout_sidebar_link']"));
        clicking.click();
    }
    public static void details(int x){
        String items = driver.findElement(By.xpath("//*[@id='item_"+x+"_title_link']/div")).getText();
        System.out.println(items);
    }

    public static void sort(int value){
        WebElement sort = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        sort.click();

        WebElement selectElement = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select select = new Select(selectElement);
//        select.selectByValue(value);
        select.selectByIndex(value);
    }

//    public static void addToCart(String title) {
//        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//        cart.click();
//        String checkouturl = "https://www.saucedemo.com/cart.html";
//        String url = driver.getCurrentUrl();
//        WebElement titleCart = null;
//        if (checkouturl == url) {
//            titleCart = driver.findElement(By.className("inventory_item_name"));
//            System.out.println(titleCart);
//            if (title= titleCart){
//                System.out.println("Added to cart Successfullyy!!!");
//            }
//        }
//    }



    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
//        Cases("userabc","abc");
//        Cases("sonal", "passwordtest");
        Cases("standard_user", "secret_sauce");
    }
}

//        Cases("","");
//        Cases("", "secret_sauce");
//      Cases("standard_user","");
//        Cases("performance_glitch_user", "wrong");
//        Cases("wrong_user", "secret_sauce");

//        Cases("problem_user","secret_sauce");