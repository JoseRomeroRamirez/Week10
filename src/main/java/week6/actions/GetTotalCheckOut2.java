package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.CheckOut2Page;

public class GetTotalCheckOut2 extends BasePageObject {
    public GetTotalCheckOut2(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public double execute(){
        CheckOut2Page CheckOut2Page = new CheckOut2Page(driver, log);
        return CheckOut2Page.totalCheckout2();
    }
}
