package week4.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week4.pageobjects.BasePageObject;
import week4.pageobjects.HeaderPage;

public class ClickHeaderButtonsUrls extends BasePageObject {
    public ClickHeaderButtonsUrls(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        HeaderPage HeaderPage = new HeaderPage(driver, log);
        HeaderPage.clickHeadersButtons();
    }
}