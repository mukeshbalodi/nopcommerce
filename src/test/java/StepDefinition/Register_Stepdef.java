package StepDefinition;

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

public class Register_Stepdef {
	WebDriver driver;
	@Before
	public void setup() {
		  driver = new ChromeDriver();
		  driver.get("https://demo.nopcommerce.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	@When("user click on Register button on Header")
	public void user_click_on_register_button_on_header() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
	  
	}

	@Then("user should redirect to Register page")
	public void user_should_redirect_to_register_page() {
		String expectedURL = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		String actualURL = driver.getCurrentUrl();
		
		if (expectedURL.equals(actualURL)) {
			System.out.println("user redirected to Register page successfully");
		}
	   
	}

	@Then("user fill the form")
	public void user_fill_the_form() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='radio' and @value='M']")).click();
		driver.findElement(By.name("FirstName")).sendKeys("chai");
		driver.findElement(By.name("LastName")).sendKeys("wala");
		
		WebElement ele = driver.findElement(By.name("DateOfBirthDay"));
		Select slt = new Select(ele);
		slt.selectByValue("5");
		Thread.sleep(2000);
		
		WebElement ele1 = driver.findElement(By.name("DateOfBirthMonth"));
		Select slt1 = new Select(ele1);
		slt1.selectByValue("11");
		Thread.sleep(2000);
		
		WebElement ele2 = driver.findElement(By.name("DateOfBirthYear"));
		Select slt2 = new Select(ele2);
		slt2.selectByValue("1993");
		Thread.sleep(2000);
	   
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("chai@mail.com");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("abc Ltd");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Chai@123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Chai@123");
		
		
	}

	@Then("click on REGISTER button")
	public void click_on_register_button() {
		driver.findElement(By.name("register-button")).click();
	   
	}

	@Then("user should be register successfully")
	public void user_should_be_register_successfully() {
		String expectedURL = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
		String actualURL= driver.getCurrentUrl();
		if (expectedURL.equals(actualURL)) {
			System.out.println("user is register successfully");
		}
		else  {
			System.err.println("URL not same");
		}
	}


}
