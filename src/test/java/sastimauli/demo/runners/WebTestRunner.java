package sastimauli.demo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "sastimauli.demo.stepdefs.web",
        plugin = {
                "pretty",
                "html:build/cucumber-reports/web-report.html",
                "json:build/cucumber-reports/web-report.json"
        },
        tags = "@web"
)
public class WebTestRunner extends AbstractTestNGCucumberTests {
    // Optional: Aktifkan ini jika ingin menjalankan skenario secara paralel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}