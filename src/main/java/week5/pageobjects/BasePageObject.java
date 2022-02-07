package week5.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** This Class contains common methods that we are going to use in pages object*/
public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;
    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log =log;
    }
    //open page with given URL
    public void openUrl(String url){
        driver.get(url);
        log.info("The "+url+" URL was opened");
    }
    //get The tittle of the current tab
    public String tittle(){return driver.getTitle();}
    //Print Text into the console
    public void print(String Text) {
        System.out.println(Text);
    }
    //find element using given locator
    protected WebElement find(By locator){
        wait(locator, 5);
        return driver.findElement(locator);
    }
    //Move the mouse over an Element
    public void hover(WebDriver driver, Logger log, WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        log.info("The mouse is hover the element");
    }
    //Click on element with given locator when is visible
    public void click(By locator){
        wait(locator, 5);
        find(locator).click();
    }
    //Type given test into element with given locator
    public void type(String text , By locator){
        wait(locator, 5);
        find(locator).sendKeys(text);
    }
    //Wait for presence of the WebElement
    public WebElement wait(By locator, int time) {
        WebDriverWait wait=new WebDriverWait(driver,time);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    //get Text of an Element
    protected String getText(By locator) {
        return find(locator).getText();
    }
    //Submit an Element given locator
    public void submit(By locator){
        find(locator).submit();
    }
}
