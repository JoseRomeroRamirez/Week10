package week4.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/** This Class contains common methods that we are going to use in pages object*/
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;
    Select select;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log =log;
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
    //Print Tesxt into the console
    public void print(String Text) {
        System.out.println(Text);
    }
    //print the placeholder using given locator
    public void printPlaceholder(By locator) { print(find(locator).getAttribute("placeholder"));}
    //find element using given locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    // find elements using given locator
    public List<WebElement> finElements(By locator){
        return driver.findElements(locator);
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
    //Wait for precense of the WebElement
    public WebElement wait(By locator, int time) {
        WebDriverWait wait=new WebDriverWait(driver,time);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    //get Text
    protected String getText(By locator) {
        return find(locator).getText();
    }
    //select by visible text
    public Select findDropdown(By locator) {
        select = new Select(find(locator));
        return select;
    }
    public void selectDropdown(Select select, String text){
        select.selectByVisibleText(text);
    }
    public String getValue(By locator){
        String value = find(locator).getAttribute("value");
        return value;
    }
}
