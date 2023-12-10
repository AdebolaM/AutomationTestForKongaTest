import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");

        // Initialize the ChromeDriver instance
        driver = new ChromeDriver();

        // Maximize the browser window if needed
        driver.manage().window().maximize();

        // Navigate to the desired URL
        driver.get("https://www.konga.com/");
        Thread.sleep(1000);
    }



    @Test (priority = 0)
    // Sign in to KongaSuccessfully-
         //unsuccessful Login with Email
    public void negLogin() throws InterruptedException {
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //verify the username textbox has the appropriate placeholder
        // Verify user can see the test "please fill in your username" when hovering on the textbox
        //input Email address
        driver.findElement(By.name("username")).sendKeys("aedwergfer@yahoo.com");
        //verify the password textbox has the appropriate placeholder
        // Verify user can see the test "please fill in your password" when hovering on the textbox
        //input password
        driver.findElement(By.name("password")).sendKeys("acbdefrg");
        //Verify that password is encrypted while typing
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //wait for it to load completely
        //Verify error messages //*[@id="app-content-wrapper"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div
        //verify user is  not logged in
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/a/span")).click();
        Thread.sleep(10000);
    }
    @Test (priority = 1)
         //successful login with Google
    public void posLogin () throws InterruptedException {
        //Click on login button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Click on login with google button
        driver.findElement(By.id("google_container")).click();
        //wait for it to load completely
        Thread.sleep(5000);
        //verify that user is logged in

    }
    @Test (priority = 2)
    // From the Categories, click on the “Computers and Accessories”-
    public void ClickOnComputersNaccessories() throws InterruptedException {
        //Click on catergories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
        //click on Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div[1]/ul/li[1]/a")).click();
        //wait for it to load completely
        Thread.sleep(5000);

    }
    @Test (priority = 3)
    // Click on the Laptop SubCategory-
    public void ClickOnLaptopSubCategory() throws InterruptedException {
        //click on laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        //Verify the checkbox to choose the differnt typre pf laptop is displayed
        //verify that user can choose more tghan one type of laptop
        //verify that usr can click on the arrow back button to close the subcatergory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/svg/path")).click();
        //Verify the title of the page
        //wait for it to load completely
        Thread.sleep(5000);
    }
    @Test (priority = 4)
    // Click on the Apple MacBooks-

    public void clickOnMacbooks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        //Verify Apple Macbooks is selected
        //verify the title of the page
        //wait for it to load completely
        Thread.sleep(5000);

    }

    @Test (priority = 5)
    // Add an item to the cart-
    public void Addtocart() throws InterruptedException {
        //addfirstitemtocart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        //Verify successmessage xpath(//*[@id="app-content-wrapper"]/div[1]) undefined <p class="_12da4_1baq-">MacBook Pro M2 Pro chip wit... has been added to your cart</p>
        //wait for it to load completely
        Thread.sleep(2000);
        //Click on Mycart icon
        //verify item is added to cart

    }

    @Test (priority = 6)
    //Checkout
    public void CheckOut() {

        //Printout the url https://www.konga.com/checkout/complete-order
        //verify the page title

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        //complete address form2
        driver.findElement(By.name("firstname")).sendKeys("Adebola");
        driver.findElement(By.name("lastname")).sendKeys("Testify");
        driver.findElement(By.name("telephone")).sendKeys("08025437452");
        driver.findElement(By.name("street")).sendKeys("Ibadan, Nigeria");
        driver.findElement(By.name("city")).sendKeys("Ibadan");
        driver.findElement(By.name("regionId")).sendKeys("Oyo");
        driver.findElement(By.name("areaId")).sendKeys("Egbeda");
        driver.findElement(By.name("saveDeliveryAddress")).click();
        //Close address form.
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[1]/div/a")).click();
        //Verify success message <p class="_12da4_1baq-">New Delivery Address saved successfully!</p>
        }

    @Test (priority = 7)
    // Select Address-
    public void selectAddress() {

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        //select the first address
        driver.findElement(By.name("selectDeliveryAddress")).click();
        //verify the address is selected
        // verify the use the address button appears

        //click on use the address button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
    }
    @Test (priority = 8)
    //Paymenttest
    public void paymentTest() {
            // continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        driver.findElement(By.name("placeOrder")).click();
            //Verify the floating page to select payment method is displayed- <section class="page-container"><section class="konga-pg-sdk"><div class="page-header"><a onclick="UIHelper.returnToMerchantPage()" href="javascript:void(0);">Return to merchant site</a></div><div class="data-card"><div class="data-card__header"><aside class="data-card__close" onclick="UIHelper.returnToMerchantPage()">×</aside><div class="header-top"><div class="header-top__logo"><img src="https://stkongapaysharedxftn.blob.core.windows.net/kongapay/logo/1551262859863-Konga%20Logo.png"></div></div><div class="header-bottom"><div class="header-bottom__reference">R993838110</div><div class="header-bottom__amount"><span class="discount-amt" id="discount-amount"></span><span class="original-amt-block"><span class="amt-parenthesis" style="display:none;">(</span><span class="original-amt" id="original-amount">₦3,341,445.00</span><span class="amt-parenthesis" style="display:none;">)</span></span></div></div></div><div id="card-progress" style="display:none;" class="data-card__progress-bar"><div id="progress" class="progress"><span id="outstanding" class="outstanding"><span id="naira-sign">₦</span><span id="outstanding-amount"></span> <span id="left">left</span></span></div></div><div class="content-part"><div id="channel-template"><div class="data-card__title"><span>SELECT PAYMENT METHOD</span></div><div class="data-card__content"><div class="dashboard-card-holder"><div class="dashboard-card">  <button onclick="UIHelper.loadTemplate('kongapay/form', null, {channel_id: '1', identifier: 'kongapay', name: 'KongaPay' })" class="dashboard-card__button KongaPay"><div class="payment-option-content"><span class="payment-option-name">KongaPay</span><span class="payment-option-info">Pay with your kongaPay Wallet</span><span class="payment-option-promo"></span></div><img src="/img/kpaybrand/kongapay-wallet-logo.png" class="payment-option_image retina"></button></div><div class="dashboard-card">  <button onclick="UIHelper.loadTemplate('transfer/form', null, {channel_id: '9', identifier: 'transfer', name: 'Bank Transfer' })" class="dashboard-card__button Bank Transfer"><div class="payment-option-content"><span class="payment-option-name">Bank Transfer</span><span class="payment-option-info">Make payments using bank transfer.</span><span class="payment-option-promo"></span></div><img src="/img/transfer-icon.svg" class="payment-option_image retina"></button></div><div class="dashboard-card">  <button onclick="UIHelper.loadTemplate('card/form', null, {channel_id: '2', identifier: 'chn_002_in3sw', name: 'Card', songbird_cardinal_js:'https://songbird.cardinalcommerce.com/cardinalcruise/v1/songbird.js'})" class="dashboard-card__button Card"><div class="payment-option-content"><span class="payment-option-name">Card</span><span class="payment-option-info">Make payments with your credit or debit card.</span><span class="payment-option-promo"></span></div><img src="/img/credit-card.svg" class="payment-option_image retina"></button></div></div></div></div><div class="ui-view"></div></div></div></section></section>
            //Select Card
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]/button")).click();

            // Input invalid card details-
        driver.findElement(By.id("card-number")).sendKeys("5535 6788 7654 3210");

            // Print Out the error message: Invalid card number-

            // Close the iFrame that displays the input card Modal-
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
            //printout confirmation message

        }


    @AfterTest
        // Quit the browser
    public void closeBrowser(){
        //quit browser
        driver.quit();
        }

    }


