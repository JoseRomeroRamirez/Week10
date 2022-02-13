package week6.pageobjects;

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
    public void CheckOut(String firstName, String lastName, String zipCode){
        type(firstName,firstNameTextBoxLocator);
        type(lastName,lastNameTextBoxLocator);
        type(zipCode,zipTextBoxLocator);
        click(continueButtonLocator);
    }
}
