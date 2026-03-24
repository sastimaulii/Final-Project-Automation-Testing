package sastimauli.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // 1. Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMsg = By.xpath("//h3[@data-test='error']");

    // 2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions/Methods
    public void inputUsername(String user) {
        driver.findElement(usernameField).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}