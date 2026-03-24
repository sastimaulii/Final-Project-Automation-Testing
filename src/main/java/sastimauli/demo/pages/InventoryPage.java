package sastimauli.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    // Locators (Poin 5: Element & Locator)
    private By productTitle = By.className("title");
    private By shoppingCart = By.className("shopping_cart_link");
    private By firstItemName = By.xpath("(//div[@class='inventory_item_name '])");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getPageTitle() {
        return driver.findElement(productTitle).getText();
    }

    public boolean isCartDisplayed() {
        return driver.findElement(shoppingCart).isDisplayed();
    }

    public String getFirstNameOfProduct() {
        return driver.findElement(firstItemName).getText();
    }
}