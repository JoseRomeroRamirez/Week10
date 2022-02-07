package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.FormSection;

public class CheckRandomCheckButton extends BasePageObject {
    public CheckRandomCheckButton(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        FormSection FormSection = new FormSection(driver, log);
        FormSection.CheckRandomCheckButton();
    }
}
