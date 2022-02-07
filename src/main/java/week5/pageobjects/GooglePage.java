package week5.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import week5.base.TestUtilities;

public class GooglePage extends BasePageObject{
    By searchBarLocator = By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By herokuappWebLocator = By.xpath("//a[@href='https://the-internet.herokuapp.com/']/h3");

    public GooglePage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    TestUtilities util = new TestUtilities();
    //Open new tabs
    public void OpenTabs(int numberOfTabs) {
        for (int i = 0; i < numberOfTabs; i++) {
            util.newTab(driver, log);
        }
        log.info(numberOfTabs +" Tabs opened");
    }
    //Close empty tabs
    public void closeNewTabs(int numberOfTabs) {
        for (int i = numberOfTabs; i > 0; i--) {
            util.switchTab(driver, log, i);
            if (tittle().equals("")) {
                util.closeTab(driver, log);
            }
        }
        log.info("Empty tabs closed");
    }
    //Search in google input
    public void search(String text){
        type(text, searchBarLocator);
        submit(searchBarLocator);
        log.info("Search: "+ text);
    }
    //Click on the result match herokuappWebLocator
    public void clickUrlResult(){
        click(herokuappWebLocator);
        log.info("Click on herokuapp Web");
    }
}
