package week4.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePageObject{
    By menuLocator = By.cssSelector("header .btn ");
    List<WebElement> menu = finElements(By.cssSelector("header .btn "));

    public HeaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void clickHeadersButtons(){
        for (int i = 0; i < menu.size(); i++) {
            finElements(menuLocator).get(i).click();
            if (driver.getTitle().equals("Practice Page")) {
                print("Same URL - Btn: "+ finElements(menuLocator).get(i).getText());

            } else {
                driver.navigate().back();
                print("Different URL - Btn: "+ finElements(menuLocator).get(i).getText());

            }
        }
    }
}
