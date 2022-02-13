package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.CheckOut2Page;
import week6.pageobjects.CheckOutPage;

public class FinishCheckOut extends BasePageObject {
    public FinishCheckOut(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        CheckOut2Page CheckOut2Page = new CheckOut2Page(driver, log);
        CheckOut2Page.finishCheckOut();
    }
}
