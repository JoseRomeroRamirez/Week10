package swagLabs.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{
    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By UsernameTextBoxLocator = By.xpath("//input[@id='user-name']");
    By PasswordTextBoxLocator = By.xpath("//input[@id='password']");
    By LoginButtonLocator = By.xpath("//input[@id='login-button']");
    By ErrorBox = By.tagName("h3");
    //Este metodo permite ingresar al sitio brindando usuario y contraseña
    public void Login(String user, String pass){
        log.info("Ingresando con los siguientes datos: user "+user+" password "+pass);
        type(user,UsernameTextBoxLocator);
        type(pass, PasswordTextBoxLocator);
        click(LoginButtonLocator);
    }
    public String GetErrorBoxText(){
        return getText(ErrorBox);
    }

}
