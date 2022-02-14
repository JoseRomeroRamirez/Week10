package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.MainPage;

public class GoToSocialMedia extends BasePageObject {
    public GoToSocialMedia(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String socialMedia, String url){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.goToSocialMedia(socialMedia, url);
    }
}
