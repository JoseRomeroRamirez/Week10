package swagLabs.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut2Page extends BasePageObject{
    public CheckOut2Page(WebDriver driver, Logger log) {
        super(driver, log);
    }
    String str;
    By itemTotalTextLocator = By.xpath("//div[@class='summary_subtotal_label']");
    By taxTextLocator = By.xpath("//div[@class='summary_tax_label']");
    By totalTextLocator = By.xpath("//div[@class='summary_total_label']");
    By finishButtonLocator = By.xpath("//button[@id='finish']");
    //Retorna el itemTotal sin el texto
    public double itemTotalCheckout2(){
        str = find(itemTotalTextLocator).getText().replace("Item total: $", "");
        return Double.parseDouble(str);
    }
    //Retorna el tax sin el texto
    public double taxCheckout2(){
        str = find(taxTextLocator).getText().replace("Tax: $", "");
        return Double.parseDouble(str);
    }
    //Retorna el total sin el texto
    public double totalCheckout2(){
        str = find(totalTextLocator).getText().replace("Total: $", "");
        return Double.parseDouble(str);
    }
    //Click para finalizar el checkOut
    public void finishCheckOut(){
        click(finishButtonLocator);
    }
}
