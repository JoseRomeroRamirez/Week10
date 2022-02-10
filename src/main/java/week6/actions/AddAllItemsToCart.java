package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.LoginPage;
import week6.pageobjects.MainPage;

public class AddAllItemsToCart extends BasePageObject {
    public AddAllItemsToCart(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.addAllItemsToCart();
    }
}
