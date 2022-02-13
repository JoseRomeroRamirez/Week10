package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.CartPage;

public class SumAllPrices extends BasePageObject {
    public SumAllPrices(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public int execute(){
        CartPage CartPage = new CartPage(driver, log);
        return CartPage.sumAllPrices();
    }
}
