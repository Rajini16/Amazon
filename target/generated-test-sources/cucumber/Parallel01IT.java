import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Selenium Framework/eclipse-workspace/AmazonSearch/src/test/resources/features/ProductSearch.feature"},
        plugin = {"json:C:/Selenium Framework/eclipse-workspace/AmazonSearch/target/1.json"},
        monochrome = true,
        tags = {"not @Ignore"},
        glue = {"your.step.definition.package"})
public class Parallel01IT {
}
