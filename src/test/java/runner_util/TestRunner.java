package runner_util;

import config.APIConfigurater;
import config.AppConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(dryRun = false,
                features = "src/test/resources/feature_files",
                glue = {"definations"},
                plugin = { "html:target/cucumber-reports.html" })
@RunWith(Cucumber.class)
public class TestRunner {

}
