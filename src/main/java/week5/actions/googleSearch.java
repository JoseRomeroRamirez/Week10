package week5.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week5.pageobjects.BasePageObject;
import week5.pageobjects.GooglePage;

public class googleSearch extends BasePageObject {
    public googleSearch(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String text){
        GooglePage GooglePage = new GooglePage(driver, log);
        GooglePage.search(text);
        GooglePage.clickUrlResult();
    }
}