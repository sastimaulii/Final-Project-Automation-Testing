package sastimauli.demo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "sastimauli.demo.stepdefs.api",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/api-report.html",
                "json:target/cucumber-reports/api-report.json"
        },
        tags = "@api"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // Set true jika ingin running paralel
    public Object[][] scenarios() {
        return super.scenarios();
    }
}