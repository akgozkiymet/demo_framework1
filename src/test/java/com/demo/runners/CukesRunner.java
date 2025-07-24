package com.demo.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber.html"},
features = "src/test/resources/features",
        glue = "com/demo/step_definitions",
        tags = "@addToCart",
        dryRun = false
)


public class CukesRunner {
}

