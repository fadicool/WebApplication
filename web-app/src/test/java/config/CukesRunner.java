package config;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by Johannes on 11/4/2018.
 */
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//        format = {"pretty", "lv.ctco.cukes.core.formatter.CukesJsonFormatter:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"stepDefs"},
        strict = true
)


public class CukesRunner {

}
