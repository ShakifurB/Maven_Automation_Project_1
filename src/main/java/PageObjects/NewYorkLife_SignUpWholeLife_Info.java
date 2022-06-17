package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewYorkLife_SignUpWholeLife_Info extends Reusable_Annotations_Class {
//we need to declare a local logger for each page object class so the logs can get added to the html report later

ExtentTest logger;
//we need a constructor method as you can see below to create an instance of page object class, so we can make the class static later
public NewYorkLife_SignUpWholeLife_Info(WebDriver driver){
    PageFactory.initElements(driver,this);
    this.logger= Reusable_Annotations_Class.logger;
}//end of constructor class

    //set up all the xpath locator using findBy WebElement concept for the page
    @FindBy(xpath="//input[@type='checkbox']")
    WebElement Verify;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_8365000___jqName']")
    WebElement FirstName;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_8830624___jqName']")
    WebElement LastName;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_3670254___jqName']")
    WebElement Email;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox___jqName']")
    WebElement PhoneNumber;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_7803718___jqName']")
    WebElement Address;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_1209046___jqName']")
    WebElement City;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidedropdownlist_co___jqName']")
    WebElement State;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_1299314___jqName']")
    WebElement ZipCode;
    @FindBy(xpath="//*[@name='guideContainer-rootPanel-guidetextbox_1482192___jqName']")
    WebElement Birthdate;
    @FindBy(xpath="//*[@class='button-default button-medium submit']")
    WebElement Submit;


    public void VerifyEmail(){
        Boolean checkBox = Reusable_Actions_POM_Loggers.checkCheckBox(driver, Verify, logger, "Verify");
        System.out.println("Is element checked? " + checkBox);
    }//end of VerifyEmail method

    public void FirstName(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, FirstName,userValue, logger, "First name");
    }//end of FirstName method

    public void LastName(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, LastName, userValue, logger, "Last name");
    }//end of LastName method

    public void Email(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, Email, userValue, logger, "Email");
    }//end of Email method

    public void PhoneNumber(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, PhoneNumber, userValue, logger, "Phone Number");
    }//end of PhoneNumber method

    public void Address(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, Address, userValue, logger, "Address");
    }//end of Address method

    public void City(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, City, userValue, logger, "City");
    }//end of City method

    public void State(String xpath){
        Reusable_Actions_POM_Loggers.selectByText(driver, State, xpath, logger, "State");
    }//end of State method

    public void ZipCode(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, ZipCode, userValue, logger, "Zipcode");
    }//end of ZipCode method

    public void Birthdate(String userValue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, Birthdate, userValue, logger, "Birthdate");
    }//end of Birthdate method

    public void Submit(){
        Reusable_Actions_POM_Loggers.clickAction(driver, Submit, logger, "Submit Button");
    }//end of Submit method

}//end of NewYorkLife_SignUpWholeLife
