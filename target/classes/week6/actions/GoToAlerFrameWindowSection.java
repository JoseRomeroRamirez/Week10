package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.BasePageObject;
import week6.pageobjects.demoqaMainSection;

public class GoToAlerFrameWindowSection extends BasePageObject {
    public GoToAlerFrameWindowSection(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        demoqaMainSection demoqaMainSection = new demoqaMainSection(driver, log);
        demoqaMainSection.GoToAlerFrameWindowSection();
    }
}