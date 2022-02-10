package testproject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week6.actions.Login;
import week6.base.TestUtilities;

public class SwagLabsTest  extends TestUtilities {
    @Test
    @Parameters({"user","pass"})
    public void LoginTest(String user, String pass){
        Login Login = new Login(driver, log);
        log.info("Login in to the E-commerce");
        Login.execute(user, pass);
        Login.AssertEqual(Login.GetUrl(driver), "https://www.saucedemo.com/inventory.html", "No coincide la URL de la pagina principal");
    }
}