package testproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import week6.actions.*;
import week6.base.TestUtilities;

public class SwagLabsTest  extends TestUtilities {
    @DataProvider(name="user-data-success")
    Object[][] userData(){
        return new Object[][] {
                {"standard_user","secret_sauce","Jose","Romero","10001"},
                {"problem_user", "secret_sauce","Antonio","Ramirez","1101"},
                {"performance_glitch_user","secret_sauce","Eduardo","Morales","3401"},
        };
    }
    @DataProvider(name="user-data-fail")
    Object[][] userDataFail(){
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"WrongUser","secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user","WrongPass", "Epic sadface: Username and password do not match any user in this service"},
                {"","secret_sauce", "Epic sadface: Username is required"},
                {"standard_user","", "Epic sadface: Password is required"}
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
    public void LoginTestFail(String user, String pass, String mensaje){
        Login Login = new Login(driver, log);
        GetErrorText GetErrorText = new GetErrorText(driver, log);
        log.info("Login in to the E-commerce with: " +user+" password: "+ pass);
        Login.execute(user, pass);
        Login.AssertEqual(Login.GetUrl(driver), "https://www.saucedemo.com/", "No coincide la URL del login");
        Login.AssertEqual(GetErrorText.execute(),mensaje, "Mensaje de error Erroneo");
    }
    @Test(dataProvider = "user-data-success")
    public void RemoveItemsFromCart(String user, String pass){
        Login Login = new Login(driver, log);
        AddItemsToCart AddItemsToCart = new AddItemsToCart(driver, log);
        RemoveItemsFromCart RemoveItemsFromCart = new RemoveItemsFromCart(driver, log);
        Login.execute(user, pass);
        AddItemsToCart.execute();
        RemoveItemsFromCart.execute();
    }
    @Test(dataProvider = "user-data-success")
    public void E2ETest(String user, String pass, String firstName, String lastName, String zipCode){
        Login Login = new Login(driver, log);
        AddItemsToCart AddItemsToCart = new AddItemsToCart(driver, log);
        RemoveItemsFromCart RemoveItemsFromCart = new RemoveItemsFromCart(driver, log);
        CheckOut CheckOut = new CheckOut(driver, log);
        Login.execute(user, pass);
        AddItemsToCart.execute();
        RemoveItemsFromCart.execute();
        CheckOut.execute(firstName, lastName, zipCode);
    }
}