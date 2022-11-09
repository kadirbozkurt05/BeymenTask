package com.kadirbozkurt.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/kadirbozkurt/step_defs",
        dryRun = false,
        plugin = "html:cucumberReport.html",
        tags = ""
)
public class CukesRunner {
}
