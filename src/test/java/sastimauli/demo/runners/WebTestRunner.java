package sastimauli.demo.runners;

import io.cucumber.java.nl.Stel;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "sastimauli.demo.stepdefs",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/web-report.html",
                "json:target/cucumber-reports/web-report.json"
        },
        tags = "@web"
)

@Test
public class WebTestRunner extends AbstractTestNGCucumberTests {

   // @Override
   // @DataProvider(parallel = true)
   // public Object[][] scenarios() {
     //   return super.scenarios();
   // }
}