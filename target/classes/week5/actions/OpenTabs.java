package week5.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week5.pageobjects.BasePageObject;
import week5.pageobjects.GooglePage;

public class OpenTabs extends BasePageObject {
    public OpenTabs(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(int numberOfTabs){
        GooglePage GooglePage = new GooglePage(driver, log);
        GooglePage.OpenTabs(numberOfTabs);
    }
}