package swagLabs.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/** This Class contains common methods that we are going to use in pages object*/
public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log =log;
    }
    //Switch tab
    public void switchTab(int tab, ArrayList<String> tabs){driver.switchTo().window(tabs.get(tab));}
    //Get text given locator
    public String getText(By locator){ return find(locator).getText();}
    //Count actual tabs
    public int CountTabs(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();
    }
    //Assert equal given two strings
    public void AssertEqual(String actual, String expected, String Message){
        Assert.assertEquals(actual, expected, Message);
    }
    //Assert equal given two strings
    public void AssertEqual(Double actual, Double expected, String Message){
        Assert.assertEquals(actual, expected, Message);
    }
    //Assert not equal given two strings
    public void AssertNotEqual(String actual, String expected, String Message){
        Assert.assertNotEquals(actual, expected, Message);
    }
    //Assert true given boolean
    public void AssertTrue(boolean val, String Message){
        Assert.assertTrue(val, Message);
    }
    //Assert is not displayed
    public void AssertNotDisplayed(WebElement val, String Message){
        Assert.assertFalse(val.isDisplayed(), Message);
    }
    //open page with given URL
    public void openUrl(String url){
        driver.get(url);
        log.info("The "+url+" URL was opened");
    }
    //Select a random number betwen the 2 numbers given
    public int rndm(int min, int max) {
        return (int)  Math.floor(Math.random() * (max - min + 1) + min);
    }
    //Soft assert equals condition
    public void SAssertEquals(int actual, int expected, String Message){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected, Message);
    }
    //Soft assert true condition
    public void SAssertTrue(boolean val, String Message){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(val, Message);
    }
    //Soft assert true condition
    public void SAssertFalse(boolean val, String Message){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(val, Message);
    }
    //Soft assert true condition
    public void SAssertAll(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }
    //get The tittle of the current tab
    public String tittle(){return driver.getTitle();}
    //find element using given locator
    protected WebElement find(By locator){
        wait(locator, 5);
        return driver.findElement(locator);
    }
    //find elements using given locator
    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    //Click on element with given locator when is visible
    public void click(By locator){
        wait(locator, 5);
        find(locator).click();
    }
    //Click on element with given Element when is visible
    public void click(WebElement Element){
        wait(Element, 5);
        Element.click();
    }
    //Wait for presence of the WebElement
    public WebElement wait(By locator, int time) {
        WebDriverWait wait=new WebDriverWait(driver,time);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    //Wait for presence of the WebElement
    public WebElement wait(WebElement Element, int time) {
        WebDriverWait wait=new WebDriverWait(driver,time);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(Element));
        return element;
    }
    //Accept an alert
    public void AcceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    //Get alert text
    public String GetAlertText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }
    //Type given test into element with given locator
    public void type(String text , By locator){
        wait(locator, 5);
        find(locator).sendKeys(text);
    }
    //Get the current url
    public String GetUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
}
