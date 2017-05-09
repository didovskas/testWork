package com.dd.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "pretty", "html:target/cucumber", "json:target_json/cucumber.json", "junit:taget_junit/cucumber.xml" },
        features = "src/test/resources/cucumber",
        glue = "com.dd.bdd.steps",
        tags = "@mobile"
)
public class RunTest {
}

