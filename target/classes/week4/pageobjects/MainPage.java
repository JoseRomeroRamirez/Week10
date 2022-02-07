package week4.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePageObject{

    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    int numeroRandom = rndm(1, 3);
    String value;
    By radioButtonLocator = By.cssSelector("[value = radio"+ numeroRandom +"]");
    By radioButtonsLocator = By.className("radioButton");
    By suggessionInputLocator = By.id("autocomplete");
    By expandedSCELocator = By.cssSelector(".ui-menu-item-wrapper");
    By selectexampleLocator = By.id("dropdown-class-example");
    By selectexampleoption3Locator = By.cssSelector("[value = option3]");
    By newtabbuttonLocator = By.id("opentab");

    Select dropdown = findDropdown(selectexampleLocator);
    Actions action = new Actions(driver);

    public void SelectRandomRadioButton() {
        print(Integer.toString(numeroRandom));
        click(radioButtonLocator);
    }
    public void printValueRadioButtons() {
        List<WebElement> radioButtonsLocatorList = finElements(radioButtonsLocator);
        for (WebElement radioselected : radioButtonsLocatorList) {
            boolean select = radioselected.isSelected();
            value = radioselected.getAttribute("value");
            print(value+ ": " + select);
        }
    }
    public void printPlaceholderClassExampleInput(){
        printPlaceholder(suggessionInputLocator);
    }
    public void writeSugessionClassExampleInput(String text){
        type(text, suggessionInputLocator);
    }
    public void printSugessionClasExampleValue(){
        wait(expandedSCELocator, 5);
        print(getText(expandedSCELocator));
    }
    public void selectOptionDropdown(String text){
        selectDropdown(dropdown, text);
        print(getValue(selectexampleLocator));
    }
    public void clickOptionDropdown(){
        click(selectexampleLocator);
        click(selectexampleoption3Locator);
        print(getValue(selectexampleLocator));
    }
    public void SwitchTabs() {
        for (int i = 0; i < 9; i++) {
            click(newtabbuttonLocator);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            print("Open tabs: "+ (i+1));
            if (i%2==0) {
                driver.switchTo().window(tabs.get(0));
            } else {
                action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
            }
        }
    }
}
