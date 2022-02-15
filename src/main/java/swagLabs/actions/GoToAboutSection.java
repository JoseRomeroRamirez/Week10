package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.MainPage;

public class GoToAboutSection extends BasePageObject {
    public GoToAboutSection(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.goToAboutSection();
    }
}
