package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("Inside user is on login page");
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
        System.out.println("Inside user enters username and password");
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        System.out.println("Inside click on login button");
    }

    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {
        System.out.println("Inside user is navigated to the home page");
    }
}
