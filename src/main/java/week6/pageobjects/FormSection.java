package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FormSection extends BasePageObject{
    public FormSection(WebDriver driver, Logger log) {
        super(driver, log);
    }
    int NumeroRandom = rndm(1,3);

    By FormButtonLocator = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]/div[2]/div[2]/*[1]");
    By PracticeFormButtonLocator = By.xpath("//span[contains(text(),'Practice Form')]");
    By GenderRadioLabelLocator = By.cssSelector(".custom-control.custom-radio.custom-control-inline");
    By HobbiesCheckLabelLocator = By.cssSelector(".custom-control.custom-checkbox.custom-control-inline");
    //This method click on practice form
    public void GoToPracticeForm(){
        click(driver, log,FormButtonLocator);
        click(driver, log, PracticeFormButtonLocator);
    }
    //This method check a random radio button
    public void CheckRandomRadioButton(){
        log.info("Numero Random: "+NumeroRandom);
        List<WebElement> radioButtonsList = findElements(GenderRadioLabelLocator);
        click(driver, log, radioButtonsList.get(NumeroRandom-1));
        for (int i = 0; i < 3; i++) {
            WebElement RadioButton = find(By.xpath("//input[@id='gender-radio-"+(i+1)+"']"));
            if (NumeroRandom == (i+1)) {
                Assert.assertTrue(RadioButton.isSelected(), "Fail selected radio button true");
            }else {
                Assert.assertFalse(RadioButton.isSelected(), "Fail selected radio button false");
            }
            log.info(RadioButton.getAttribute("value") + ": "+ RadioButton.isSelected());
        }
    }
    //This method check a random check button
    public void CheckRandomCheckButton(){
        log.info("Numero Random: "+NumeroRandom);
        List<WebElement> CheckButtonsList = findElements(HobbiesCheckLabelLocator);
        for (int i = 0; i < 3; i++) {
            if (NumeroRandom != (i+1)) {
                click(driver, log, CheckButtonsList.get(i));
            }
        }
        for (int i = 0; i < 3; i++) {
            WebElement CheckButton = find(By.xpath("//input[@id='hobbies-checkbox-"+(i+1)+"']"));
            if (NumeroRandom == (i+1)) {
                Assert.assertFalse(CheckButton.isSelected(), "Fail selected check button true");
            }else {
                Assert.assertTrue(CheckButton.isSelected(), "Fail selected check button false");
            }
            log.info(CheckButton.getAttribute("value") + ": "+ CheckButton.isSelected());
        }
    }
}
