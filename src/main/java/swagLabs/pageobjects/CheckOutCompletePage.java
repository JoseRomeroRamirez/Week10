package swagLabs.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePageObject{
    public CheckOutCompletePage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By checkOutCompleteTextLocator = By.xpath("//span[@class='title']");
    By headerTextLocator = By.xpath("//h2[@class='complete-header']");
    String expectedCheckOutComplete = "CHECKOUT: COMPLETE!";
    String getExpectedCheckOutHeader = "THANK YOU FOR YOUR ORDER";
    //Verifica comparando los textos esperados con los obtenidos
    public void verifyOrderWasCompleted(){
        AssertEqual(getText(checkOutCompleteTextLocator),expectedCheckOutComplete, "Se muestra mensaje equivocado en el titulo");
        AssertEqual(getText(headerTextLocator),getExpectedCheckOutHeader,"Se muestra mensaje equivocado en el encabezado");
    }
}
