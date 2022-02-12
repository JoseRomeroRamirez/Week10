package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.CartPage;
import week6.pageobjects.MainPage;

public class RemoveItemsFromCart extends BasePageObject {
    public RemoveItemsFromCart(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute() {
        CartPage CartPage = new CartPage(driver, log);
        CartPage.removeItemsToCart();
    }
}