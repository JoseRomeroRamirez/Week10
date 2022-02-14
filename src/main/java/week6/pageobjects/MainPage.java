package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePageObject{
    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    By addToCartButtonLocator = By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn_primary')]");
    By cartCounterLocator = By.xpath("//span[contains(@class, 'shopping_cart_badge')]");
    By menuLocator = By.xpath("//button[@id='react-burger-menu-btn']");
    By aboutSectionLocator = By.xpath("//a[@id='about_sidebar_link']");
    By twitterLocator = By.xpath("//a[contains(text(),'Twitter')]");
    By facebookLocator = By.xpath("//a[contains(text(),'Facebook')]");
    By linkedInLocator = By.xpath("//a[contains(text(),'LinkedIn')]");
    String urlTwitter = "https://twitter.com/saucelabs";
    String urlFacebook = "https://www.facebook.com/saucelabs";
    String urlLinkedin = "https://www.linkedin.com/authwall?trk=gf&trkInfo=AQEPsbIDANtZ5AAAAX73Y7mYknZHEwli_BFAwM7ua1IcqVGlBhZU-ih6DT6lcpsW8kh0LaNN5DIxUvqBEYCPR8N7hT18fMMjbYc8D2Ly1z3bfVB_Ptw1LfehHQIQuPWQDtwNI6U=&originalReferer=&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fcompany%2Fsauce-labs%2F";
    int productosMax =10;
    public void addItemsToCart(){
        List<WebElement> addButton = findElements(addToCartButtonLocator);
        if (productosMax > addButton.size()){productosMax = addButton.size();}
        for (int j=0; j < productosMax; j++) {
            addButton.get(j).click();
            AssertEqual(String.valueOf(j+1),getText(cartCounterLocator),"El Contador de agregar al carrito fallo");
        }
    }
    public void goToAboutSection(){
        click(menuLocator);
        click(aboutSectionLocator);
        AssertEqual(GetUrl(driver),"https://saucelabs.com/","La Url no es la esperada");
    }
    public void goToSocialMediaTwitter(){
        click(twitterLocator);
        try {Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        switchTab(1,tabs);
        AssertEqual(GetUrl(driver),urlTwitter, "Url Social media no coincide");
    }
    public void goToSocialMediaFacebook(){
        click(facebookLocator);
        try {Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        switchTab(1,tabs);
        AssertEqual(GetUrl(driver),urlFacebook, "Url Social media no coincide");
    }
    public void goToSocialMediaLinkedin(){
        click(linkedInLocator);
        try {Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();}
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        switchTab(1,tabs);
        AssertEqual(GetUrl(driver),urlLinkedin, "Url Social media no coincide");
    }
}
