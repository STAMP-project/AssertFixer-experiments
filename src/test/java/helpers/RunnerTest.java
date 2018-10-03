package helpers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report"},
        features = "src/test/resources/features"
        ,glue={""}
        ,dryRun=false
        ,monochrome=true
        ,format={"html:WALKLondon"}
)
public class RunnerTest {

}
