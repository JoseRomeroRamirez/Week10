package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.CheckOutCompletePage;

public class VerifyOrderWasCompleted extends BasePageObject{
    public VerifyOrderWasCompleted(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        CheckOutCompletePage CheckOutCompletePage = new CheckOutCompletePage(driver, log);
        CheckOutCompletePage.verifyOrderWasCompleted();
    }

}
