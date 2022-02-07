package testproject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week4.actions.*;
import week4.base.TestUtilities;

public class rahulshettyacademyWeb extends TestUtilities {

    @Test
    public void SelectRandomRadioLocatorTest(){
        SelectRandomRadioButton SelectRandomRadioButton = new SelectRandomRadioButton(driver, log);
        SelectRandomRadioButton.execute();
    }
    @Test
    @Parameters("suggessionClassExampleText")
    public void PrintSugessionClassExampleTest(String suggessionClassExampleText){
        PrintSugessionClassExample PrintSugessionClassExample = new PrintSugessionClassExample(driver, log);
        PrintSugessionClassExample.execute(suggessionClassExampleText);
    }
    @Test
    @Parameters("dropdownSelect")
    public void SelectDropdownTest(String dropdownSelect){
        SelectDropdown SelectDropdown = new SelectDropdown(driver, log);
        SelectDropdown.execute(dropdownSelect);
    }
    @Test
    public void ClickHeaderButtonsUrlsTest(){
        ClickHeaderButtonsUrls ClickHeaderButtonsUrls = new ClickHeaderButtonsUrls(driver, log);
        ClickHeaderButtonsUrls.execute();
    }
    @Test
    public void SwitchTabsTest(){
        SwitchTabs SwitchTabs = new SwitchTabs(driver, log);
        SwitchTabs.execute();
    }
}
