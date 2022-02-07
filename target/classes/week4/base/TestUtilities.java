package week4.base;

import org.openqa.selenium.JavascriptExecutor;

public class TestUtilities extends BaseTest{
    //This method sleeps the browser
    public void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //This method scroll down to the footer page
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        log.info("Scroll down was performed to the footer page");
    }
    //This method scroll on the page
    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
        log.info("Scroll down was performed");
    }
}
