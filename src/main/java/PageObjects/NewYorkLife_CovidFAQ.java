package PageObjects;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewYorkLife_CovidFAQ extends Reusable_Annotations_Class {
    //we need to declare a local logger for each page object class so the logs can get added to the html report later

    ExtentTest logger;
    //we need a constructor method as you can see below to create an instance of page object class, so we can make the class static later
    public NewYorkLife_CovidFAQ(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger=Reusable_Annotations_Class.logger;
    }//end of constructor class

    //set up all the xpath locator using findBy WebElement concept for the page
    @FindBy(xpath="//*[@class='cmp-cta-banner__button']")
    WebElement CovidFAQ;
    @FindBy(xpath="//*[@class='cmp-social-share__icon--copy']")
    WebElement Share;

    public void Covid(){
        Reusable_Actions_POM_Loggers.clickAction(driver, CovidFAQ, logger, "Covid-19 button");
    }//end of Covid method

    public void Bovid(){
        Reusable_Actions_POM_Loggers.clickAction(driver, Share, logger, "Share Link");
    }//end of Bovid method



}//end of NewYorkLife_HomePage
