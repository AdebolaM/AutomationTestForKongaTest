import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class kongaProject {
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {

        // Set the path to the ChromeDriver executable
        String s = System.setProperty("webdriver.chrome.driver", "Webdriver/chromedriver.exe");

        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        driver.get("https://www.konga.com");

        // Maximize the browser window if needed
        driver.manage().window().maximize();

        // Navigate to the desired URL

        Thread.sleep(1000);
    }



    @Test (priority = 0)
    // Sign in to Konga Successfully-

    public void Login() throws InterruptedException {
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //verify the username textbox has the appropriate placeholder

        // Find the username input element
        WebElement usernameInput = driver.findElement(By.name("username"));

        // Get the placeholder attribute value
        String usernameplaceholderText = usernameInput.getAttribute("placeholder");

        // Assert if the placeholder text matches the expected value
        String usernameExpectedPlaceholder = "Enter Email Address OR Phone Number";
        Assert.assertEquals(usernameplaceholderText, usernameExpectedPlaceholder);

        //input Email address
        driver.findElement(By.name("username")).sendKeys("adebola.oritu@yahoo.com");
        //verify the password textbox has the appropriate placeholder

        // Find the password input element
        WebElement passwordInput = driver.findElement(By.name("password"));

        // Get the placeholder attribute value
        String placeholderText = passwordInput.getAttribute("placeholder");

        // Assert if the placeholder text matches the expected value
        String expectedPlaceholder = "Enter Password";
        Assert.assertEquals(placeholderText, expectedPlaceholder);

        // Verify user can see the test "please fill in your password" when hovering on the textbox
        //input password
        passwordInput.sendKeys("Meticulous1");
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(2000);
        //confirm the user is logged in with the success message
        WebElement successmessage = driver.findElement( By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]"));
        // Check if the element is displayed
        if (successmessage.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login not successful!.");
        }

    }



    @Test (priority =1)
    // From the Categories, click on the “Computers and Accessories”-
    public void ClickOnComputersNaccessories() throws InterruptedException {
        //click on Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        //wait for it to load completely
        Thread.sleep(5000);
        //get and printout the url
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        // Print the current URL
        System.out.println("Current URL: " + currentUrl);



    }
    @Test (priority = 2)
    // Click on the Laptop SubCategory-
    public void ClickOnLaptopSubCategory() throws InterruptedException {
        //click on laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        //wait for it to load completely
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    // Click on the Apple MacBooks-

    public void clickOnMacbooks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        //Verify Apple Macbooks is selected
        //verify the title of the page
        //wait for it to load completely
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    // Add an item to the cart-
    public void Addtocart() throws InterruptedException {
        //additemtocart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[10]/div/div/div[2]/form/div[3]/button")).click();
        //Verify successmessage xpath(//*[@id="app-content-wrapper"]/div[1]) undefined <p class="_12da4_1baq-">MacBook Pro M2 Pro chip wit... has been added to your cart</p>
        //wait for it to load completely
        Thread.sleep(2000);
        //Click on Mycart icon
        //verify item is added to cart

    }

    @Test (priority = 5)
    //Checkout
    public void CheckOut() throws InterruptedException {
        //view cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        //verify item is in the Cart
        WebElement Cartitem = driver.findElement(By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[1]"));
        Cartitem.isDisplayed();
        System.out.println("Item present!");
        // click on checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);

        }
    @Test (priority = 6)
    // Select Address-
    public void ChooseAddress() throws InterruptedException {
        try {
            // Attempt to click the first button
            WebElement firstButton =  driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button"));
            firstButton.click();

            // Code to execute if the first button was clicked successfully
            WebElement secondButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button"));
            secondButton.click();
            driver.findElement(By.name("selectDeliveryAddress")).click();
            Thread.sleep(2000);
            //click on use the address button
            WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a"));
            addressButton.click();
            Thread.sleep(2000);

        }
        catch (NoSuchElementException e) {
            // If the first button is not found, click the second button
            WebElement secondButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button"));
            secondButton.click();
            //select the first address
            driver.findElement(By.name("selectDeliveryAddress")).click();
            //click on use the address button
            WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a"));
            addressButton.click();
            Thread.sleep(2000);
        }
    }

    @Test  (priority = 7)
    //choose pay now
    public void PayNow () throws InterruptedException {
        //click on paynow radio button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        //Click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 8)
    public void selectcardmethod () throws InterruptedException {
        //9 select a card payment method
        //9a change from default to iframe
        WebElement paymethod;
        paymethod = driver.findElement(By.id("kpg-frame-component"));
        WebDriver frame;
        frame = driver.switchTo().frame("kpg-frame-component");
        //9b select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("select card method");
        Thread.sleep(5000);
    }

    @Test (priority = 9)
    public void inputcarddetails () throws InterruptedException {
        //10. input individual card details
        //10a input card number in its field
        driver.findElement(By.id("card-number")).sendKeys("1234567890006532");
        Thread.sleep(3000);
        //10b input date in its field
        driver.findElement(By.id("expiry")).sendKeys("1224");
        Thread.sleep(3000);
        //10c input CVV in its field
        driver.findElement(By.id("cvv")).sendKeys("456");
        Thread.sleep(5000);
        System.out.println("input card details");
    }
    @Test (priority = 10)
    public void errormessage () throws InterruptedException {
        //11 print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
    }
    @Test (priority = 11)
    public void closeframe () throws InterruptedException {
        //12 close the Iframe that displays input card details
        driver.findElement(By.className("data-card__close")).click();
        System.out.println("exit iframe");
        Thread.sleep(5000);
    }



    @AfterTest
    // Quit the browser
    public void closeBrowser(){
        //quit browser
        driver.quit();
    }

}


