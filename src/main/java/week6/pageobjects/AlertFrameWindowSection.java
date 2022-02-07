package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import week6.base.TestUtilities;

public class AlertFrameWindowSection extends BasePageObject{
    public AlertFrameWindowSection(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By BrowserWindowButtonLocator = By.xpath("//span[contains(text(),'Browser Windows')]");
    By NewTabButtonLocator = By.xpath("//button[@id='tabButton']");
    By AlertsButtonLocator = By.xpath("//span[contains(text(),'Alerts')]");
    By ClickMeButton5secLocator = By.xpath("//button[@id='timerAlertButton']");
    TestUtilities util = new TestUtilities();
    //This method click on Browser Window
    public void GoToBrowserWindow(){
        click(driver, log, BrowserWindowButtonLocator);
    }
    //This method open new tabs and verify the tittle and the number of tabs opened
    public void CheckTabs(){
        click(driver, log, NewTabButtonLocator);
        SAssertEquals(CountTabs(), 2, "Fail number of tabs open");
        util.switchTab(driver,log,1);
        SAssertTrue(tittle().contains("Page"), "Fail tittle of new tab");
        util.closeTab(driver, log);
        util.switchTab(driver,log,0);
        SAssertEquals(CountTabs(), 1, "Fail number of tabs open");
        SAssertAll();
    }
    //This method Wait for an alert and accept it
    public void AlertAccept() throws InterruptedException {
        click(driver, log, AlertsButtonLocator);
        click(driver, log, ClickMeButton5secLocator);
        util.waitForAlert(driver);
        log.info(GetAlertText(driver));
        AssertTrue(GetAlertText(driver).equals("This alert appeared after 5 seconds"), "Fail Alert appears in 5 seconds");
        AcceptAlert(driver);
    }
}
