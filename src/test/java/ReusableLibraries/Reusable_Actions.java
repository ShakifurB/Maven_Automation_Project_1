package ReusableLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Reusable_Actions {

    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 60;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouseHover method
    public static void mouseHover(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }//end of exception
    }//end of mouseHover method

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//end of exception
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//end of exception
    }//end of sendkeys method

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a getText method
    public static String getTextAction(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
        }//end of exception
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//end of exception
    }//end of clickByIndexAction

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver,String userInput, String elementName){
        try{
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(userInput)) {
                System.out.println("My title contains " + userInput);
            } else {
                System.out.println("Title doesn't match. Actual Title is " + actualTitle);
            }//end of if statement
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }//end of exception
    }//end of verifyTitle method

    //create a switchToTabByIndex
    public static void switchToTabByIndex(WebDriver driver, int userValue){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(userValue));
    }//end of switchToTabByIndex method

    //create a selectByText method
    public static void selectByText (WebDriver driver, String xpath, String xPath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            dropDown.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
        } catch (Exception e) {
            System.out.println("Unable to access dropdown " + elementName + " " + e);
        }//end of exception
    }//end of switchToTabByIndex



}//end of class
