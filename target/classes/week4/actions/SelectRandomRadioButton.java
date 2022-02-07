package week4.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week4.pageobjects.BasePageObject;
import week4.pageobjects.MainPage;

public class SelectRandomRadioButton extends BasePageObject {
    public SelectRandomRadioButton(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.SelectRandomRadioButton();
        MainPage.printValueRadioButtons();
    }
}