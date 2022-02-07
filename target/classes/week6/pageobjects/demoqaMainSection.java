package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class demoqaMainSection extends BasePageObject{
    public demoqaMainSection(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By ElementSectionLocator = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");
    By AlertFrameWindowsSectionLocator = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
    //This method click on the form section
    public void GoToFormSection(){
        click(driver, log, ElementSectionLocator);
    }
    //This method click on the alert Frame Window section
    public void GoToAlerFrameWindowSection(){
        click(driver, log, AlertFrameWindowsSectionLocator);
    }
}