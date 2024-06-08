package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
    WebDriver driver;
    @Given("^browser is open$")
    public void browserIsOpen() {
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

    @And("^user is on googlge search page$")
    public void userIsOnGooglgeSearchPage() {
        driver.navigate().to("https://www.google.com");
    }


    @When("^user entersma text in google search box$")
    public void userEntersmaTextInGoogleSearchBox() {
         driver.findElement(By.name("q")).sendKeys("tuoitre.com");
    }

    @And("^hits Enter$")
    public void hitsEnter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^user is navigated to the Search Result page$")
    public void userIsNavigatedToTheSearchResultPage() {
        driver.getPageSource().contains("Báo Tuổi Trẻ - Tin tức mới nhất, tin nhanh, tin nóng 24h");
        driver.close();
        driver.quit();
    }
}
