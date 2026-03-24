package sastimauli.demo.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sastimauli.demo.utils.BaseTest;

public class Hooks {
    @After("@web") // Hanya dijalankan untuk test dengan tag @web
    public void tearDown(Scenario scenario) {
        // Jika test fail, browser bisa otomatis screenshot (opsional)
        BaseTest.quitDriver();
    }

    ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new"); // Tambahkan ini agar jalan di server GitHub
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
    WebDriver driver = new ChromeDriver(options);
}