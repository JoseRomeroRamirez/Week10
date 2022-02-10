package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePageObject{
    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By addToCartButtonLocator = By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn_primary')]");
    By cartCounterLocator = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");

    public void addAllItemsToCart(){
        List<WebElement> addButton = findElements(addToCartButtonLocator);
        for (int j = 0; j < addButton.size(); j++) {
            addButton.get(j).click();
            System.out.println(j+"    "+getText(cartCounterLocator));
            AssertEqual(String.valueOf(j),getText(cartCounterLocator),"El Contador de agregar al carrito fallo");
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
