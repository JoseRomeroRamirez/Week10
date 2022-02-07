package week5.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week5.pageobjects.BasePageObject;
import week5.pageobjects.herokuappMainPage;

public class ScrollWebElement extends BasePageObject {
    public ScrollWebElement(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        herokuappMainPage herokuappMainPage = new herokuappMainPage(driver, log);
        herokuappMainPage.scrollWebElement();
    }
}