package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePageObject{
    public CartPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By removeButtonLocator = By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn_secondary') and contains(@class, 'cart_button')]");
    By cartCounterLocator = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");
    public void removeItemsToCart(){
        openUrl("https://www.saucedemo.com/cart.html");
        List<WebElement> removeButton = findElements(removeButtonLocator);
        for (int j=(removeButton.size()-1); j >= 0 ; j--) {
            removeButton.get(j).click();
            if (j>0){AssertEqual(String.valueOf(j),getText(cartCounterLocator),"El Contador de remover al carrito fallo");}
            else{AssertTrue(findElements(cartCounterLocator).size() == 0,"Se encontro elementos cuando se esperaba que el carrito estuviese vacio");}
            log.info("Item removed");
        }
    }
}
