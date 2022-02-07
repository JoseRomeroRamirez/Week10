package week5.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class herokuappHoverPage extends BasePageObject{
    public herokuappHoverPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By userOneImageLocator = By.xpath("//body/div[2]/div[1]/div[1]/div[1]/img[1]");
    By nameUserOneLocator = By.xpath("//h5[contains(text(),'name: user1')]");
    By userTwoImageLocator = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/img[1]");
    By viewProfileUserTwoLocator = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]");
    By userThreeImageLocator = By.xpath("//body/div[2]/div[1]/div[1]/div[3]/img[1]");
    By viewProfileUserThreeLocator = By.xpath("//body/div[2]/div[1]/div[1]/div[3]/div[1]/a[1]");

    //Print the name of the user one
    public void printNameUserOne(){
        hover(driver, log, find(userOneImageLocator));
        print(getText(nameUserOneLocator));
    }
    //Print the view profile text of the user two
    public void printViewProfileTextUserTwo(){
        hover(driver, log, find(userTwoImageLocator));
        print(getText(viewProfileUserTwoLocator));
    }
    // Click on the view profile of the user three
    public void clickViewProfileUserThree(){
        hover(driver, log, find(userThreeImageLocator));
        click(viewProfileUserThreeLocator);
        log.info("Click on the view profile link");
    }
}