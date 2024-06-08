package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    WebDriver driver;

    @Given("^browser is open2")
    public void browserIsOpen2() {
        System.out.println("Starting browser");
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath+ "/src/main/resources/browser/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        System.out.println("Ending browser");
    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://camposcoffee.com/my-account/");
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("ganesh20215@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Codetester@1");
        driver.findElement(By.name("login")).click();
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        driver.getPageSource().contains("Hello ganesh20215");
        driver.close();
        driver.quit();
    }
}
