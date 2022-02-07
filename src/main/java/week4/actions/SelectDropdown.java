package week4.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week4.pageobjects.BasePageObject;
import week4.pageobjects.MainPage;

public class SelectDropdown extends BasePageObject {
    public SelectDropdown(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String text){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.selectOptionDropdown(text);
        MainPage.clickOptionDropdown();
    }
}
