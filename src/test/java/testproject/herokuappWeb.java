package testproject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import week5.actions.*;
import week5.base.TestUtilities;

public class herokuappWeb extends TestUtilities {
    @Test
    @Parameters("numberOfTabs")
    public void OpenTabsTest(int numberOfTabs){
        OpenTabs OpenTabs = new OpenTabs(driver, log);
        CloseEmptyTabs CloseEmptyTabs = new CloseEmptyTabs(driver, log);
        OpenTabs.execute(numberOfTabs);
        CloseEmptyTabs.execute(numberOfTabs);
        switchTab(driver, log, 0);
    }
    @Test
    @Parameters("searchText")
    public void SearchTextTest(String searchText){
        googleSearch googleSearch = new googleSearch(driver, log);
        googleSearch.execute(searchText);
    }
    @Test
    public void ScrollWebElementTest(){
        ScrollWebElement ScrollWebElement = new ScrollWebElement(driver, log);
        ScrollWebElement.execute();
    }
    @Test
    public void PrintNameUserTest(){
        PrintNameUser PrintNameUser = new PrintNameUser(driver, log);
        PrintNameUser.execute();
    }
    @Test
    public void PrintViewProfileTest(){
        PrintViewProfileText PrintViewProfileText = new PrintViewProfileText(driver, log);
        PrintViewProfileText.execute();
    }
    @Test
    public void ClickViewProfileTest(){
        ClickViewProfile ClickViewProfile = new ClickViewProfile(driver, log);
        ClickViewProfile.execute();
    }
    @Test
    @Parameters({"numberOfTabs","searchText"})
    public void end2endTest(int numberOfTabs, String searchText){
        OpenTabs OpenTabs = new OpenTabs(driver, log);
        googleSearch googleSearch = new googleSearch(driver, log);
        ScrollWebElement ScrollWebElement = new ScrollWebElement(driver, log);
        CloseEmptyTabs CloseEmptyTabs = new CloseEmptyTabs(driver, log);
        PrintNameUser PrintNameUser = new PrintNameUser(driver, log);
        PrintViewProfileText PrintViewProfileText = new PrintViewProfileText(driver, log);
        ClickViewProfile ClickViewProfile = new ClickViewProfile(driver, log);

        OpenTabs.execute(numberOfTabs);
        CloseEmptyTabs.execute(numberOfTabs);
        switchTab(driver, log, 0);
        googleSearch.execute(searchText);
        ScrollWebElement.execute();
        PrintNameUser.execute();
        PrintViewProfileText.execute();
        ClickViewProfile.execute();
    }
}
