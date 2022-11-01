package net.crmly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                // "pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber-reports/Cucumber.json"

        },
        features = "src/test/resources/features",
        glue = "net/crmly/step_definitions",
        dryRun = false,
        tags = "@CRMLYEUG-1433", //@WIP @Regression
        publish = true
)
public class CukesRunner {
}


