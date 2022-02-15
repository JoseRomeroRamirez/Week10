package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.CartPage;

public class RemoveItemsFromCart extends BasePageObject {
    public RemoveItemsFromCart(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute() {
        CartPage CartPage = new CartPage(driver, log);
        CartPage.removeItemsToCart();
    }
}