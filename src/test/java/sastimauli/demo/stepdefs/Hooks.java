package sastimauli.demo.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import sastimauli.demo.utils.BaseTest;

public class Hooks {
    @After("@web") // Hanya dijalankan untuk test dengan tag @web
    public void tearDown(Scenario scenario) {
        // Jika test fail, browser bisa otomatis screenshot (opsional)
        BaseTest.quitDriver();
    }
}