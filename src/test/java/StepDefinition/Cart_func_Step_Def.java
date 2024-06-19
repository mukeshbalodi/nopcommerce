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
import io.cucumber.java.en.When;

public class Cart_func_Step_Def {
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
	        
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	   
	    
	    @When("user select any product from the items")
	    public void user_select_any_product_from_the_items() throws InterruptedException {
	    	driver.findElement(By.xpath("//div[@class='page-body']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")).click();
	      Thread.sleep(2000);
	      
	    }

	    @When("click on add to cart button")
	    public void click_on_add_to_cart_button() throws InterruptedException {
	    	driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
	    	Thread.sleep(2000);
	    	WebElement ele = driver.findElement(By.name("product_attribute_2"));
	    	Select slt = new Select (ele);
	    	slt.selectByValue("5");
	    	
	    	driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();
	    	driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
	    	Thread.sleep(5000);
	    
	    }

	    @Then("user see a message item added into the cart")
	    public void user_see_a_message_item_added_into_the_cart() {
	    	System.out.println("item added into the cart successfully");
	    	
	    	
	        
	    }

	    @Then("user can verify it by clicking on Shopping_cart icon")
	    public void user_can_verify_it_by_clicking_on_shopping_cart_icon() throws InterruptedException {
	    	driver.findElement(By.xpath("//span[@class='cart-label']")).click();
	    	Thread.sleep(2000);
	    	
	      
	    }

}
