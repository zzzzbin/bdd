package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = {"StepDefinitions"}, monochrome = true,
plugin = {"pretty", "html:target/HtmlReports.html"})
public class TestRunner {
}
