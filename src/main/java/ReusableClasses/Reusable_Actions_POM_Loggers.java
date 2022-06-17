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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Reusable_Actions_POM_Loggers {

    //set a static timeout variable, so it can cover all explicit for all methods
    public static int timeout = 30;

    //reusable function for web-driver as a return method
    public static WebDriver setDriver(){
        //set up your chromedriver with webdrivermanager
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



    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hover on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of mouseHover



    //create a click method
    public static void clickAction(WebDriver driver,WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of clickAction



    //create a submit method
    public static void submitAction(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of submit



    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,WebElement xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter user value on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of sendkeys method



    //create a getText method
    public static String getTextAction(WebDriver driver,WebElement xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
        return result;
    }//end of getTextAction method


    //create a getTextByIndexAction method
    public static String getTextByIndexAction(WebDriver driver, WebElement xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElements(xpath)).get(indexNumber);;
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
        return result;
    }//end of getTextByIndexAction


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,WebElement xpath,ExtentTest logger,int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElements(xpath)).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully able to click by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index on element " + elementName + " " + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of clickByIndexAction



    //create a Boolean checkCheckBox method
    public static Boolean checkCheckBox(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Boolean result = null;
        try {
            result = wait.until(ExpectedConditions.visibilityOf(xpath)).isSelected();
            logger.log(LogStatus.PASS, "Is element " + elementName + "located? " +result);
        } catch (Exception e) {
            System.out.println("Unable to identify if element " + elementName + " is checked " + e);
            logger.log(LogStatus.FAIL, "Unable to identify if element " + elementName + " is checked" + e);
            e.printStackTrace();
            getScreenShot(driver, elementName, logger);
        }//end of exception
        return result;
    }//end of checkCheckbox

    //create a selectByText method
    public static void selectByText (WebDriver driver, WebElement xpath, String xPath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try{
            WebElement dropDown = wait.until(ExpectedConditions.visibilityOf(xpath));
            dropDown.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to access dropdown " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on element " + elementName + " " + e);
        }//end of exception
    }//end of switchToTabByIndex


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
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
            getScreenShot(driver, imageName, logger);
        }//end of exception
    }//end of getScreenshot method




}//end of class
