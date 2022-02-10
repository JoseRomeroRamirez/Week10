package testproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week6.actions.Login;
import week6.base.TestUtilities;

public class SwagLabsTest  extends TestUtilities {
    @DataProvider(name="user-data-success")
    Object[][] userData(){
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
        };
    }
    @DataProvider(name="user-data-fail")
    Object[][] userDataFail(){
        return new Object[][] {
                {"locked_out_user", "secret_sauce"},
                {"WrongUser","secret_sauce"},
                {"standard_user","WrongPass"}
        };
    }
    @Test(dataProvider = "user-data-success")
    public void LoginTestSuccess(String user, String pass){
        Login Login = new Login(driver, log);
        log.info("Login in to the E-commerce with: " +user+" password: "+ pass);
        Login.execute(user, pass);
        Login.AssertEqual(Login.GetUrl(driver), "https://www.saucedemo.com/inventory.html", "No coincide la URL de la pagina principal");
    }
    @Test(dataProvider = "user-data-fail")
    public void LoginTestFail(String user, String pass){
        Login Login = new Login(driver, log);
        log.info("Login in to the E-commerce with: " +user+" password: "+ pass);
        Login.execute(user, pass);
        Login.AssertEqual(Login.GetUrl(driver), "https://www.saucedemo.com/", "No coincide la URL del login");
    }
}