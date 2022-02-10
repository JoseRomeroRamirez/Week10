package testproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week6.actions.Login;
import week6.base.TestUtilities;

public class SwagLabsTest  extends TestUtilities {
    @DataProvider(name="user-data")
    Object[][] userData(){
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
    }
    @Test(dataProvider = "user-data")
    public void LoginTest(String user, String pass){
        Login Login = new Login(driver, log);
        log.info("Login in to the E-commerce");
        Login.execute(user, pass);
        Login.AssertEqual(Login.GetUrl(driver), "https://www.saucedemo.com/inventory.html", "No coincide la URL de la pagina principal");
    }
}