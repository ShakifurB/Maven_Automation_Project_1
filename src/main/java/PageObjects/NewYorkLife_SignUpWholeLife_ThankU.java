package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewYorkLife_SignUpWholeLife_ThankU extends Reusable_Annotations_Class {
//we need to declare a local logger for each page object class so the logs can get added to the html report later

ExtentTest logger;
//we need a constructor method as you can see below to create an instance of page object class, so we can make the class static later
public NewYorkLife_SignUpWholeLife_ThankU(WebDriver driver){
    PageFactory.initElements(driver,this);
    this.logger= Reusable_Annotations_Class.logger;
}//end of constructor class

    //set up all the xpath locator using findBy WebElement concept for the page
    @FindBy(xpath="//*[@class='rte cmp-margin-top--large cmp-margin-bottom--large aem-GridColumn--default--none aem-GridColumn aem-GridColumn--default--12 aem-GridColumn--offset--default--0']")
    WebElement ThankU;

    public void ThankYou(){
        String ThankYou = Reusable_Actions_POM_Loggers.getTextAction(driver, ThankU, logger, "Thank You");
        System.out.println(ThankYou);
    }//end of ThankYou method

}//end of NewYorkLife_SignUpWholeLife
