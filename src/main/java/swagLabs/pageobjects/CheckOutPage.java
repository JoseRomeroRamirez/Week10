package swagLabs.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePageObject{
    public CheckOutPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By firstNameTextBoxLocator = By.xpath("//input[@id='first-name']");
    By lastNameTextBoxLocator = By.xpath("//input[@id='last-name']");
    By zipTextBoxLocator = By.xpath("//input[@id='postal-code']");
    By continueButtonLocator = By.xpath("//input[@id='continue']");
    String checkOutStepOneUrl="https://www.saucedemo.com/checkout-step-one.html";
    //Ingresa los datos brindados y avanza al siguiente paso
    public void CheckOut(String firstName, String lastName, String zipCode){
        openUrl(checkOutStepOneUrl);
        log.info("Ingresando los datos: nombre"+firstName+" apellido "+lastName+" zip code "+zipCode);
        type(firstName,firstNameTextBoxLocator);
        type(lastName,lastNameTextBoxLocator);
        type(zipCode,zipTextBoxLocator);
        click(continueButtonLocator);
    }
}
