package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Reusable_Actions_Loggers {

    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 60;

    //reusable function for webdriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        //options.addArguments("start-maximized");
        //for mac use full screen
        options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouseHover method
    public static void mouseHover(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hover on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to hover on element " + elementName + " " + e);
        }//end of exception
    }//end of mouseHover method

    //create a mouseHoverByIndexAction method
    public static void mouseHoverByIndexAction(WebDriver driver,String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hover on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to hover on element " + elementName + " " + e);
        }//end of exception
    }//end of mouseHoverByIndexAction method

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully click on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e);
        }//end of exception
    }//end of clickAction

    //create a sendkeysAction method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter user value " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to enter user value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendKeysAction method

    //create a sendKeysAction1 method
    public static void sendKeysActionClear(WebDriver driver,String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), userValue);
            logger.log(LogStatus.PASS, "Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter user value " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to enter user value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendKeysActionClear method

    //create a sendKeysActionByIndex method
    public static void sendKeysActionByIndex(WebDriver driver,String xpath, String userValue, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter user value " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to enter user value on element " + elementName + " " + e);
        }//end of exception
    }//end of sendKeysActionByIndex method

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + " " + e);
        }//end of exception
    }//end of submitAction

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }//end of exception
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }//end of exception
    }//end of clickByIndexAction

    public static String getTextByIndexAction(WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);;
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }//end of exception
        return result;
    }//end of getTextByIndexAction

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver,String userInput, ExtentTest logger, String elementName){
        try{
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(userInput)) {
                System.out.println("My title contains " + userInput);
            } else {
                System.out.println("Title doesn't match. Actual Title is " + actualTitle);
            }//end of if statement
            logger.log(LogStatus.PASS, "Successfully verify title on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to verify title on element " + elementName + " " + e);
        }//end of exception
    }//end of verifyTitle method

    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }//end of if statement
        } catch (Exception e) {
            System.out.println("Unable to verify if element is selected as expected");
        }//end of exception
    }

    //create a switchToTabByIndex
    public static void switchToTabByIndex(WebDriver driver, int userValue){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(userValue));
    }//end of switchToTabByIndex method

    //create a selectByText method
    public static void selectByText (WebDriver driver, String xpath, String xPath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            dropDown.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to access dropdown " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }//end of exception
    }//end of switchToTabByIndex

    //create a scroll into view method
    public static void scrollIntoView(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //handle exception for scroll to bottom
        try {
            //declare a web element variable that we want to scroll into
            WebElement scrollInto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //scroll into this element
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollInto);
            logger.log(LogStatus.PASS, "Successfully able to scroll into element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + elementName + " " + e);
            logger.log(LogStatus.PASS, "Unable to scroll into element " + elementName + " " + e);
        }//end of exception
    }//end of scrollIntoView

    public static Boolean checkCheckBox(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Boolean result = null;
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            logger.log(LogStatus.PASS, "Is element " + elementName + "located? " +result);
        } catch (Exception e) {
            System.out.println("Unable to identify if element " + elementName + " is checked " + e);
            logger.log(LogStatus.FAIL, "Unable to identify if element " + elementName + " is checked" + e);
        }//end of exception
        return result;
    }//end of checkCheckbox

    //create a scroll by pixels method
    public static void scrollByPixels(WebDriver driver, String x, String y, ExtentTest logger, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //handle exception for scroll to bottom
        try {
            //scroll into this element
            jse.executeScript("scroll(" +x+ "," +y+")");
            logger.log(LogStatus.PASS, "Successfully able to scroll to pixels " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to pixels " + elementName + " " + e);
            logger.log(LogStatus.PASS, "Unable to scroll into pixels " + elementName + " " + e);
        }//end of exception
    }//end of scrollByPixels

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of exception
    }//end of getScreenshot method


}//end of class