package sastimauli.demo.stepdefs.web;

import io.cucumber.java.en.*;
import org.testng.Assert;
import sastimauli.demo.pages.InventoryPage;
import sastimauli.demo.pages.LoginPage;
import sastimauli.demo.utils.BaseTest;

public class LoginSteps {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("user opens the login page")
    public void userOpensLoginPage() {
        loginPage = new LoginPage(BaseTest.getDriver());
        BaseTest.getDriver().get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String user, String pass) {
        loginPage.inputUsername(user);
        loginPage.inputPassword(pass);
    }

    @And("user clicks the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("user should see the {string}")
    public void validateResult(String result) {
        if (result.equals("products page")) {
            inventoryPage = new InventoryPage(BaseTest.getDriver());
            Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
            Assert.assertTrue(inventoryPage.isCartDisplayed());
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
        }

    }
}