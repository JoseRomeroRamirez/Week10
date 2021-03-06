package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.CartPage;

public class SumAllPrices extends BasePageObject {
    public SumAllPrices(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public double execute(){
        CartPage CartPage = new CartPage(driver, log);
        return CartPage.sumAllPrices();
    }
}
