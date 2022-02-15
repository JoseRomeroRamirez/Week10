package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.MainPage;

public class GoToSocialMediaFacebook extends BasePageObject {
    public GoToSocialMediaFacebook(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.goToSocialMediaFacebook();
    }
}
