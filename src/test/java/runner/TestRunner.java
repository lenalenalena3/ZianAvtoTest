package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
    @CucumberOptions(features = {"src/test/java/features"},
            glue = "stepDefinition",
            tags = "@123",
            plugin={"html:target/cucumber-html-report"}
    )

    public class TestRunner {

    }
