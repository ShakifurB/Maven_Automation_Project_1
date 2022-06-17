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

public class NewYorkLife_Contact extends Reusable_Annotations_Class {
    //we need to declare a local logger for each page object class so the logs can get added to the html report later

    ExtentTest logger;
    //we need a constructor method as you can see below to create an instance of page object class, so we can make the class static later
    public NewYorkLife_Contact(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger=Reusable_Annotations_Class.logger;
    }//end of constructor class

    //set up all the xpath locator using findBy WebElement concept for the page
    @FindBy(xpath="//*[@class='rte cmp-margin-top--none aem-GridColumn--small--none aem-GridColumn--default--none aem-GridColumn--x-small--12 aem-GridColumn--x-small--none aem-GridColumn aem-GridColumn--small--12 aem-GridColumn--offset--small--0 aem-GridColumn--default--7 aem-GridColumn--offset--x-small--0 aem-GridColumn--offset--default--0']")
    WebElement CallUs;
    @FindBy(xpath="//*[@class='form-control']")
    WebElement Email;
    @FindBy(xpath="//*[@class='cmp-email-subscribe__submit btn btn-outline-secondary']")
    WebElement Send;

    public void CalllUs(){
        Reusable_Actions_POM_Loggers.getTextAction(driver, CallUs, logger, "Call Us");
        System.out.println(CallUs);
    }//end of CallUs method

    public void Email(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, Email,userValue, logger, "Email");
    }//end of Email method

    public void Send(){
        Reusable_Actions_POM_Loggers.submitAction(driver, Send, logger, "Send Button");
    }//end of Send method

}//end of NewYorkLife_HomePage
