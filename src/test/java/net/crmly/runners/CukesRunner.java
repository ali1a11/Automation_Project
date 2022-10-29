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
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
        features = "src/test/resources/features",
        glue = "net/crmly/step_definitions",
        dryRun = false,
        tags = "@Regression", //@WIP1@WIP
        publish = true
)
public class CukesRunner {
}

/*
"pretty" plugin:
basically it just prints out additional information about the scenario that is being executed.
 */


/*
publish = true;
    --> will enable a functionality from cucumber to generate a public link for the report of our final execution of our code
    --> the link will be automatically generated and printed in the console
    --> it will be ready to share with anyone
 */