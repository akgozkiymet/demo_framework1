package com.demo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        glue = "com/demo/api",
        features = "src/test/resources/features/api",
        plugin = {},
        tags = "")


public class APITestRunner {
}
