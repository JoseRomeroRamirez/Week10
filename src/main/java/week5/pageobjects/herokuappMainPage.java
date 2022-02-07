package week5.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import week5.base.TestUtilities;

public class herokuappMainPage extends BasePageObject{
    public herokuappMainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By HoversLinkLocator = By.linkText("Hovers");
    TestUtilities util =new TestUtilities();
    //This method scroll to the element
    public void scrollWebElement(){
        util.scrollWebElement(driver, log, find(HoversLinkLocator));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(HoversLinkLocator);
    }
}
