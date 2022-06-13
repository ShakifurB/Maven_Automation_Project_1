package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.xml.xpath.XPath;

import static org.openqa.selenium.By.xpath;

public class USPS_Reusable_Concepts {

    public static void main(String[] args) throws InterruptedException{

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver, "//*[text()='Quick Tools']", "Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver, "//*[@id='mail-ship-width']", "Send Tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver, "//*[@class='tool-calc']", "Calculate a Price");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver, "//*[@class='header-usps row']", "Header Info");
        System.out.println("My header info is " + result);

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver, "//*[@id='Origin']", "11218", "Zip Code");

    }//end of main

}//end of class
