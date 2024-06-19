package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Step_def {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Add an implicit wait
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user is on Home page")
    public void user_is_on_home_page() {
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
    }

    @Then("user should redirect to login page")
    public void user_should_redirect_to_login_page() {
        // You can add an assertion here to verify the URL or a specific element on the login page
    }

    @Then("user fill the data into email and password fields")
    public void user_fill_the_data_into_email_and_password_fields() {
        driver.findElement(By.name("Email")).sendKeys("allu@mail.com");
        driver.findElement(By.name("Password")).sendKeys("Allu@123");
    }

    @Then("clicks on LOG_IN Button")
    public void clicks_on_log_in_button() {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }

    @Then("user should nevigate to Home page")
    public void user_should_nevigate_to_home_page() {
       System.out.println("login successful");
    }
}
