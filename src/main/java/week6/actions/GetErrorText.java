package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.LoginPage;

public class GetErrorText extends BasePageObject {
    public GetErrorText(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public String execute(){
        LoginPage LoginPage = new LoginPage(driver, log);
        return LoginPage.GetErrorBoxText();
    }
}
