package testproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import week6.actions.*;
import week6.base.TestUtilities;
import week6.pageobjects.BasePageObject;

import java.text.DecimalFormat;

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
    @DataProvider(name="socialMedia")
    Object[][] socialMedia(){
        return new Object[][]{
                {"Twitter","https://twitter.com/saucelabs"},
                {"Facebook","https://www.facebook.com/saucelabs"},
                {"LinkedIn","https://www.linkedin.com/company/sauce-labs/"}
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
        DecimalFormat format = new DecimalFormat("#.00");
        BasePageObject base = new BasePageObject(driver, log);
        Login Login = new Login(driver, log);
        AddItemsToCart AddItemsToCart = new AddItemsToCart(driver, log);
        CheckOut CheckOut = new CheckOut(driver, log);
        SumAllPrices SumAllPrices = new SumAllPrices(driver, log);
        GetItemTotalCheckOut2 GetItemTotalCheckOut2 = new GetItemTotalCheckOut2(driver,log);
        GetTaxCheckOut2 GetTaxCheckOut2 = new GetTaxCheckOut2(driver, log);
        GetTotalCheckOut2 GetTotalCheckOut2 = new GetTotalCheckOut2(driver, log);
        FinishCheckOut FinishCheckOut = new FinishCheckOut(driver, log);
        VerifyOrderWasCompleted VerifyOrderWasCompleted = new VerifyOrderWasCompleted(driver, log);
        Login.execute(user, pass);
        AddItemsToCart.execute();
        double sum = SumAllPrices.execute();
        CheckOut.execute(firstName, lastName, zipCode);
        base.AssertEqual(GetItemTotalCheckOut2.execute(), sum, "Error en la suma total de productos");
        base.AssertEqual(GetTaxCheckOut2.execute(), Double.parseDouble(format.format(GetItemTotalCheckOut2.execute()*0.08)), "Error en el calculo del tax");
        base.AssertEqual(GetTotalCheckOut2.execute(), (GetItemTotalCheckOut2.execute() + GetTaxCheckOut2.execute()), "Error en la suma total de tax y productos");
        FinishCheckOut.execute();
        VerifyOrderWasCompleted.execute();
    }
    @Test()
    public void VerifyAboutSectionTest(){
        GoToAboutSection GoToAbout = new GoToAboutSection(driver, log);
        GoToAbout.execute();
    }
    @Test(dataProvider = "socialMedia")
    public void SocialMediaTest(String socialMedia, String url){
        GoToSocialMedia GoToSocialMedia = new GoToSocialMedia(driver, log);
        GoToSocialMedia.execute(socialMedia, url);
    }
}