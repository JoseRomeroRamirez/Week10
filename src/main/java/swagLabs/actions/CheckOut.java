package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.CheckOutPage;

public class CheckOut extends BasePageObject {
    public CheckOut(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String firstName,String lastName, String zipCode){
        CheckOutPage CheckOutPage = new CheckOutPage(driver, log);
        CheckOutPage.CheckOut(firstName, lastName, zipCode);
    }
}
