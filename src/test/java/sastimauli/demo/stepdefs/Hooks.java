package sastimauli.demo.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sastimauli.demo.utils.BaseTest;

public class Hooks {

    @Before("@web") // Tambahkan tag agar API test tidak ikut buka browser
    public void setUp() {
        // Panggil method dari BaseTest, jangan bikin "new ChromeDriver" lagi di sini
        BaseTest.getDriver();
    }

    @After("@web")
    public void tearDown(Scenario scenario) {
        if (BaseTest.driver != null) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot_Failed_Step");
            }
            BaseTest.quitDriver();
        }
    }
}