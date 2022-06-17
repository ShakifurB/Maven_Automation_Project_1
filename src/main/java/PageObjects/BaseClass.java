package PageObjects;

import ReusableClasses.Reusable_Annotations_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reusable_Annotations_Class{
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for google home page
    public static GoogleHomePage googleHomePage(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return  googleHomePage;
    }//end of googleHomePage method

    //create static reference for google search result page
    public static GoogleSearchResultPage googleSearchResultPage(){
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        return  googleSearchResultPage;
    }//end of googleSearchResultPage method

    public static NewYorkLife_HomePage newYorkLife_homePage(){
        NewYorkLife_HomePage newYorkLife_homePage = new NewYorkLife_HomePage(driver);
        return newYorkLife_homePage;
    }//end of newYorkLife_HomePage method

    public static NewYorkLife_HomePage_InsurancePlans newYorkLife_homePage_insurancePlans(){
        NewYorkLife_HomePage_InsurancePlans newYorkLife_homePage_insurancePlans = new NewYorkLife_HomePage_InsurancePlans(driver);
        return newYorkLife_homePage_insurancePlans;
    }//end of newYorkLife_HomePage_InsurancePlans method

    public static NewYorkLife_HomePage_Search newYorkLife_homePage_search(){
        NewYorkLife_HomePage_Search newYorkLife_homePage_search = new NewYorkLife_HomePage_Search(driver);
        return newYorkLife_homePage_search;
    }//end of NewYorkLife_HomePage_Search method

    public static NewYorkLife_Links newYorkLife_links(){
        NewYorkLife_Links newYorkLife_links = new NewYorkLife_Links(driver);
        return newYorkLife_links;
    }//end of newYorkLife_links method

    public static NewYorkLife_Links_IntroductionStatement newYorkLife_links_introductionStatement(){
        NewYorkLife_Links_IntroductionStatement newYorkLife_links_introductionStatement = new NewYorkLife_Links_IntroductionStatement(driver);
        return newYorkLife_links_introductionStatement;
    }//end of NewYorkLife_Links_IntroductionStatement method

    public static NewYorkLife_Compare newYorkLife_compare(){
        NewYorkLife_Compare newYorkLife_compare = new NewYorkLife_Compare(driver);
        return newYorkLife_compare;
    }//end of newYorkLife_compare method

    public static NewYorkLife_CompareChart newYorkLife_compareChart(){
        NewYorkLife_CompareChart newYorkLife_compareChart = new NewYorkLife_CompareChart(driver);
        return newYorkLife_compareChart;
    }//end of newYorkLife_compareChart method

    public static NewYorkLife_SignUpWholeLife newYorkLife_signUpWholeLife(){
        NewYorkLife_SignUpWholeLife newYorkLife_signUpWholeLife = new NewYorkLife_SignUpWholeLife(driver);
        return newYorkLife_signUpWholeLife;
    }//end of NewYorkLife_SignUpWholeLife method

    public static NewYorkLife_SignUpWholeLife_Info newYorkLife_signUpWholeLife_info(){
        NewYorkLife_SignUpWholeLife_Info newYorkLife_signUpWholeLife_info = new NewYorkLife_SignUpWholeLife_Info(driver);
        return newYorkLife_signUpWholeLife_info;
    }//end of NewYorkLife_SignUpWholeLife_Info method

    public static NewYorkLife_SignUpWholeLife_ThankU newYorkLife_signUpWholeLife_thankU(){
        NewYorkLife_SignUpWholeLife_ThankU newYorkLife_signUpWholeLife_thankU = new NewYorkLife_SignUpWholeLife_ThankU(driver);
        return newYorkLife_signUpWholeLife_thankU;
    }//end of NewYorkLife_SignUpWholeLife_ThankU method

    public static NewYorkLife_Contact newYorkLife_contact(){
        NewYorkLife_Contact newYorkLife_contact = new NewYorkLife_Contact(driver);
        return newYorkLife_contact;
    }//end of NewYorkLife_Contact method

    public static NewYorkLife_ContactUs newYorkLife_contactUs(){
        NewYorkLife_ContactUs newYorkLife_contactUs = new NewYorkLife_ContactUs(driver);
        return newYorkLife_contactUs;
    }//end of NewYorkLife_ContactUs method

    public static NewYorkLife_Covid newYorkLife_covid(){
        NewYorkLife_Covid newYorkLife_covid = new NewYorkLife_Covid(driver);
        return newYorkLife_covid;
    }//end of NewYorkLife_

    public static NewYorkLife_CovidFAQ newYorkLife_covidFAQ(){
        NewYorkLife_CovidFAQ newYorkLife_covidFAQ = new NewYorkLife_CovidFAQ(driver);
        return newYorkLife_covidFAQ;
    }//end of NewYorkLife_CovidFAQ



}//end of base class
