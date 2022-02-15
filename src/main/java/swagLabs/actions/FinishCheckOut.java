package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.CheckOut2Page;

public class FinishCheckOut extends BasePageObject {
    public FinishCheckOut(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        CheckOut2Page CheckOut2Page = new CheckOut2Page(driver, log);
        CheckOut2Page.finishCheckOut();
    }
}
