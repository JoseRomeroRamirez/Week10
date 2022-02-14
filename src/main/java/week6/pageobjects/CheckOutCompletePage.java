package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePageObject{
    public CheckOutCompletePage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By checkOutCompleteTextLocator = By.xpath("//span[@class='title']");
    By headerTextLocator = By.xpath("//h2[@class='complete-header']");
    public void verifyOrderWasCompleted(){
        AssertEqual(getText(checkOutCompleteTextLocator),"CHECKOUT: COMPLETE!", "Se muestra mensaje equivocado en el titulo");
        AssertEqual(getText(headerTextLocator),"THANK YOU FOR YOUR ORDER","Se muestra mensaje equivocado en el encabezado");
    }
}
