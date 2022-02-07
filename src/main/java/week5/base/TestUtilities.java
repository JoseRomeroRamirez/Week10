package week5.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TestUtilities extends BaseTest{
    //This method scroll to an Element
    public void scrollWebElement(WebDriver driver, Logger log, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        log.info("Scroll to web element was performed");
    }
    //This method open a new tab
    public void newTab(WebDriver driver, Logger log){
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.open()");
         log.info("A new tab was opened");
    }
    //This method close a tab
    public void closeTab(WebDriver driver, Logger log){
        driver.close();
        log.info("The Tab is closed");
    }
    //This method switch to a different tab
    public void switchTab(WebDriver driver, Logger log, int tab){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
        log.info("Switch to tab number " + (tab));
    }
}
