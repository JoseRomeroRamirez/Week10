package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.CheckOut2Page;

public class GetTaxCheckOut2 extends BasePageObject {
    public GetTaxCheckOut2(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public double execute(){
        CheckOut2Page CheckOut2Page = new CheckOut2Page(driver, log);
        return CheckOut2Page.taxCheckout2();
    }
}
