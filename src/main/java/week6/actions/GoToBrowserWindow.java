package week6.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import week6.pageobjects.AlertFrameWindowSection;
import week6.pageobjects.BasePageObject;

public class GoToBrowserWindow extends BasePageObject {
    public GoToBrowserWindow(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void execute(){
        AlertFrameWindowSection AlertFrameWindowSection = new AlertFrameWindowSection(driver, log);
        AlertFrameWindowSection.GoToBrowserWindow();
    }
}