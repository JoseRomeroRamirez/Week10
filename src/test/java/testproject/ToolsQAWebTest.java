package testproject;

import org.testng.annotations.Test;
import week6.actions.*;
import week6.base.TestUtilities;

public class ToolsQAWebTest extends TestUtilities {
    @Test
    public void FormTest(){
        GoToFormSection GoToFormSection = new GoToFormSection(driver, log);
        GoToPracticeForm GoToPracticeForm = new GoToPracticeForm(driver, log);
        CheckRandomRadioButton CheckRandomRadioButton = new CheckRandomRadioButton(driver, log);
        CheckRandomCheckButton CheckRandomCheckButton = new CheckRandomCheckButton(driver,log);
        log.info("Step 1: Click on form section");
        GoToFormSection.execute();
        log.info("Step 2: Click on practice form button");
        GoToPracticeForm.execute();
        log.info("Step 3: Check a random radio button for gender and verify is selected");
        CheckRandomRadioButton.execute();
        log.info("Step 4: Check two random check button for hobbies and verify is selected");
        CheckRandomCheckButton.execute();
        log.info("End of Test");
    }
    @Test
    public void AlertFrameWindowTest() throws InterruptedException {
        GoToBrowserWindow GoToBrowserWindow = new GoToBrowserWindow(driver, log);
        GoToAlerFrameWindowSection GoToAlerFrameWindowSection = new GoToAlerFrameWindowSection(driver, log);
        CheckTabs CheckTabs = new CheckTabs(driver, log);
        AlertAccept AlertAccept = new AlertAccept(driver,log);
        log.info("Step 1: Click on alert frame window section");
        GoToAlerFrameWindowSection.execute();
        log.info("Step 2: Click on Browser Windows button");
        GoToBrowserWindow.execute();
        log.info("Step 3: Open a tab then verify the number of tabs and close it");
        CheckTabs.execute();
        log.info("Step 4: Wait for the alert to appear and accept it");
        AlertAccept.execute();
        log.info("End of Test");
    }

}
