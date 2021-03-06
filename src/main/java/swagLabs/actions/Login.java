package swagLabs.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import swagLabs.pageobjects.BasePageObject;
import swagLabs.pageobjects.LoginPage;

public class Login extends BasePageObject {
    public Login(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String user, String pass){
        LoginPage LoginPage = new LoginPage(driver, log);
        LoginPage.Login(user, pass);
    }
}