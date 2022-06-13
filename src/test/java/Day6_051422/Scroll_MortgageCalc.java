package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {

    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen"):
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortagecalculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        //wait for web page to load, 3 seconds
        Thread.sleep(3000);

        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll to pixel 400 on mortage calc website
        //jse.executeScript("scroll(0,400");
        //wait a bit for browser to perform scrolling
        //Thread.sleep(3000);

        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id = 'share_button']"));

        //scroll into share this calculation button
        jse.executeScript("arguements[0].scrollIntoView(true);",shareButton);
        Thread.sleep(3000);

        //click on the share this calculation button
        shareButton.click();

        //scroll back up
        jse.executeScript("scroll(0,-400");
        Thread.sleep(2000);

        //quit the chrome driver
        driver.quit();

    }//end of main

}//end of class

