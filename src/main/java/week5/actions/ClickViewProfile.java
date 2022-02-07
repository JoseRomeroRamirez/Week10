package week5.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week5.pageobjects.BasePageObject;
import week5.pageobjects.herokuappHoverPage;

public class ClickViewProfile extends BasePageObject {
    public ClickViewProfile(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        herokuappHoverPage herokuappHoverPage = new herokuappHoverPage(driver, log);
        herokuappHoverPage.clickViewProfileUserThree();
    }
}
