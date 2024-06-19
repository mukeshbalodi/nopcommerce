package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class Orderflow_Step_def {
	 WebDriver driver;

	    @Before
	    public void setUp() throws InterruptedException, AWTException {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	        driver.get("https://demo.nopcommerce.com/");
	        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();	   
	        driver.findElement(By.name("Email")).sendKeys("allu@mail.com");
	        driver.findElement(By.name("Password")).sendKeys("Allu@123");
	        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
	        Thread.sleep(3000);
	        Robot robot = new Robot();
	        robot.keyPress(34);
	        robot.keyRelease(34);
	        robot.keyPress(34);
	        robot.keyRelease(34);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//div[@class='page-body']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")).click();
		      Thread.sleep(2000);
		      driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
		    	Thread.sleep(2000);
		    	WebElement ele = driver.findElement(By.name("product_attribute_2"));
		    	Select slt = new Select (ele);
		    	slt.selectByValue("5");
		    	
		    	driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();
		    	driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
		    	Thread.sleep(5000);
		    	driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		    	Thread.sleep(2000);
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    @Then("fill the entries before clicking on checkout button")
	    public void fill_the_entries_before_clicking_on_checkout_button() {
	    	WebElement ele = driver.findElement(By.name("checkout_attribute_1"));
	    	Select slt = new Select(ele);
	    	slt.selectByValue("2");
	    	
	    	driver.findElement(By.xpath("//input[@id='discountcouponcode']")).sendKeys("MUK123");
	    	driver.findElement(By.xpath("//input[@id='giftcardcouponcode']")).sendKeys("ABC123");
	    	driver.findElement(By.name("termsofservice")).click();
	    	
	        
	    }

	    @Then("click on checkout button")
	    public void click_on_checkout_button() {
	    	driver.findElement(By.xpath("//button[@id='checkout']")).click();

	       
	    }

	  

	    @Then("fill the Fill address form on Billing Address page")
	    
	    public void fill_the_fill_address_form_on_billing_address_page() {
	    	WebElement ele211 = driver.findElement(By.id("BillingNewAddress_FirstName"));
			ele211.sendKeys("Mukesh");
			
			

			WebElement ele2112 = driver.findElement(By.id("BillingNewAddress_LastName"));
			ele2112.sendKeys("Balodi");
			
			
			
			WebElement ele21122 = driver.findElement(By.id("BillingNewAddress_Email"));
			ele21122.clear();
			ele21122.sendKeys("zoudoppuddoza-9266@yopmail.com");
			
			
			WebElement ele2122 = driver.findElement(By.id("BillingNewAddress_Company"));
			ele2122.sendKeys("ABC Ltd.");
			
			
			WebElement ele1112 = driver.findElement(By.name("BillingNewAddress.CountryId"));
			Select slt1112 = new Select(ele1112);
			slt1112.selectByValue("133");
			
			

			WebElement ele212 = driver.findElement(By.id("BillingNewAddress_City"));
			ele212.sendKeys("Delhi");
			
			
			WebElement ele101 = driver.findElement(By.id("BillingNewAddress_Address1"));
			ele101.sendKeys("Delhi 92");
			
			
			
			WebElement ele102 = driver.findElement(By.id("BillingNewAddress_Address2"));
			ele102.sendKeys("Delhi 110092 ");
			
			
			WebElement ele103 = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]"));
			ele103.sendKeys("110092 ");
			
			
			
			WebElement ele104 = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"));
			ele104.sendKeys("123456789 ");
			
			driver.findElement(By.name("save")).click();
			
	        
	    }

	    @Then("select shipping method")
	    public void select_shipping_method() {
	    	driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
	       
	    }

	    @Then("click on continue button on shipping method page")
	    public void click_on_continue_button_on_shipping_method_page() {
	    	driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
	       
	    }

	    @Then("select payment method")
	    public void select_payment_method() throws InterruptedException {
	    	driver.findElement(By.id("paymentmethod_0")).click();
	    	Thread.sleep(2000);
	        
	    }

	    @Then("click on continue button on payment method page")
	    public void click_on_continue_button_on_payment_method_page() throws InterruptedException {
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
	    	
	       
	    }

	    @Then("click on continue on payment information page")
	    public void click_on_continue_on_payment_information_page() {
	    	driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
	      
	    }

	    @Then("click on confirm  button on confirm order page")
	    public void click_on_confirm_button_on_confirm_order_page() {
	    	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	       
	    }

	    @Then("order will place successfully")
	    public void order_will_place_successfully() throws InterruptedException {
	    	String expectedURL = "https://demo.nopcommerce.com/checkout/completed";
	    	String actualURL = driver.getCurrentUrl();
	    	if (expectedURL.equals(actualURL)) {
	    		System.out.println("ordder placed successfully");
	    		Thread.sleep(3000);
	    	}
	    	
	    	
	    	
	    	
	      
	    }
}
