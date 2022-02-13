package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut2Page extends BasePageObject{
    public CheckOut2Page(WebDriver driver, Logger log) {
        super(driver, log);
    }
    String str, str2;
    By itemTotalTextLocator = By.xpath("//div[@class='summary_subtotal_label']");
    By taxTextLocator = By.xpath("//div[@class='summary_tax_label']");
    By TotalTextLocator = By.xpath("//div[@class='summary_total_label']");
    public double itemTotalCheckout2(){
        str = find(itemTotalTextLocator).getText();
        log.info(str);
        str2 = str.replace("Item total: $", "");
        log.info(str2);
        return Double.parseDouble(str);
    }
    public double taxCheckout2(){
         str = find(itemTotalTextLocator).getText().replace("Tax: $", "");
        return Double.parseDouble(str);
    }
    public double totalCheckout2(){
        str = find(itemTotalTextLocator).getText().replace("Total: $", "");
        return Double.parseDouble(str);
    }
}
