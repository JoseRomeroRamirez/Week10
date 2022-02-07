package week4.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week4.pageobjects.BasePageObject;
import week4.pageobjects.MainPage;

public class PrintSugessionClassExample extends BasePageObject {
    public PrintSugessionClassExample(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(String text){
        MainPage MainPage = new MainPage(driver, log);
        MainPage.printPlaceholderClassExampleInput();
        MainPage.writeSugessionClassExampleInput(text);
        MainPage.printSugessionClasExampleValue();
    }

}
