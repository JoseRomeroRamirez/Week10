package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

public class CheckOut2Page extends BasePageObject{
    public CheckOut2Page(WebDriver driver, Logger log) {
        super(driver, log);
    }
    String str;
    By itemTotalTextLocator = By.xpath("//div[@class='summary_subtotal_label']");
    By taxTextLocator = By.xpath("//div[@class='summary_tax_label']");
    By TotalTextLocator = By.xpath("//div[@class='summary_total_label']");
    public double itemTotalCheckout2(){
        str = find(itemTotalTextLocator).getText().replace("Item total: $", "");
        return Double.parseDouble(str);
    }
    public double taxCheckout2(){
        str = find(taxTextLocator).getText().replace("Tax: $", "");
        DecimalFormat format = new DecimalFormat("#.00");
        log.info(Double.parseDouble(format.format(str)));
        return Double.parseDouble(format.format(Double.parseDouble(str)));
    }
    public double totalCheckout2(){
        str = find(TotalTextLocator).getText().replace("Total: $", "");
        return Double.parseDouble(str);
    }
}
