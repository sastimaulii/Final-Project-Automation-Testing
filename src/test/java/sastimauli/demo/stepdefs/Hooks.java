package sastimauli.demo.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sastimauli.demo.utils.BaseTest;

public class Hooks {

    @Before("@web")
    public void setUp() {
        // 1. Konfigurasi Chrome agar bisa jalan di Server (Tanpa Layar)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // 2. Inisialisasi Driver
        BaseTest.driver = new ChromeDriver(options);
    }

    @After("@web")
    public void tearDown(Scenario scenario) {
        // 3. Otomatis ambil Screenshot jika Test Gagal (Agar muncul di Report)
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot_Failed_Step");
        }

        // 4. Tutup Browser
        BaseTest.quitDriver();
    }
}