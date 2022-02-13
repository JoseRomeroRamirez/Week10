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
    By pricesTextLocator = By.xpath("//div[@class='inventory_item_price']");
    String url = "https://www.saucedemo.com/cart.html";
    public void removeItemsToCart(){
        openUrl(url);
        List<WebElement> removeButton = findElements(removeButtonLocator);
        for (int j=(removeButton.size()-1); j >= 0 ; j--) {
            removeButton.get(j).click();
            if (j==0){
                AssertTrue(findElements(removeButtonLocator).size() == 0,"Se encontro elementos cuando se esperaba que el carrito estuviese vacio");}
            else{AssertEqual(String.valueOf(j),getText(cartCounterLocator),"El Contador de remover al carrito fallo");}
            log.info("Item removed");
        }
    }
    public int sumAllPrices(){
        int sum = 0;
        String str;
        openUrl(url);
        List<WebElement> prices = findElements(pricesTextLocator);
        for (WebElement price:prices) {
            str = price.getText();
            str = str.replace("$", "");
            log.info(str);
            sum = sum + Integer.parseInt(str);
        }
        return sum;
    }
}
