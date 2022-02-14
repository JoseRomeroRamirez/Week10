package week6.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.switchTo().frame(1);
        AssertEqual(GetUrl(driver),urlTwitter, "Url Social media no coincide");
    }
}
