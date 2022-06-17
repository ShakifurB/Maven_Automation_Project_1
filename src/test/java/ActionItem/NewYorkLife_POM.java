package ActionItem;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import org.jsoup.Connection;
import org.testng.annotations.Test;

public class NewYorkLife_POM extends Reusable_Annotations_Class {

    @Test(priority = 1)
    //Test Case 1
    public void SearchForKeyword() throws InterruptedException{
        driver.navigate().to("https://www.newyorklife.com");
        BaseClass.newYorkLife_homePage().KeywordSearch();
        Thread.sleep(3000);
        BaseClass.newYorkLife_homePage_insurancePlans().InsurancePlans("Evaluate Life Insurance Plans");
        BaseClass.newYorkLife_homePage_search().Search();
        BaseClass.newYorkLife_links().FirstLink();
        BaseClass.newYorkLife_links_introductionStatement().IntroductionStatement();
        Reusable_Actions_Loggers.verifyTitle(driver, "Compare Products", logger, "Compare Products");
    }//end of Test Case 1

    @Test(dependsOnMethods = "SearchForKeyword")
    //Test Case 2
    public void CompareInsurance() throws InterruptedException{
        BaseClass.newYorkLife_compare().FirstCompareNow(0);
        Thread.sleep(3000);
        BaseClass.newYorkLife_compareChart().BasicsWholeAndTermLife(2);
        BaseClass.newYorkLife_compareChart().BasicsWholeAndTermLife(1);
        BaseClass.newYorkLife_compareChart().BasicsWholeAndTermLife(6);
        BaseClass.newYorkLife_compareChart().BasicsWholeAndTermLife(5);
    }//end of Test Case 2

    @Test(dependsOnMethods = "CompareInsurance")
    //Test Case 3
    public void SignUpWholeLife() throws InterruptedException{
        BaseClass.newYorkLife_signUpWholeLife().SignUpWholeLife(0);
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","1500", logger, "Submit Button");
        Thread.sleep(3000);
        BaseClass.newYorkLife_signUpWholeLife_info().VerifyEmail();
        BaseClass.newYorkLife_signUpWholeLife_info().FirstName("Shakifur");
        BaseClass.newYorkLife_signUpWholeLife_info().LastName("Bhuiyan");
        BaseClass.newYorkLife_signUpWholeLife_info().Email("sbhuiyan57@gmail.com");
        BaseClass.newYorkLife_signUpWholeLife_info().PhoneNumber("6468536190");
        BaseClass.newYorkLife_signUpWholeLife_info().Address("1070 Crescent St. Apt 1");
        BaseClass.newYorkLife_signUpWholeLife_info().City("Brooklyn");
        BaseClass.newYorkLife_signUpWholeLife_info().State("//*[text()= 'New York']");
        BaseClass.newYorkLife_signUpWholeLife_info().ZipCode("11208");
        BaseClass.newYorkLife_signUpWholeLife_info().Birthdate("06281998");
        BaseClass.newYorkLife_signUpWholeLife_info().Submit();
        BaseClass.newYorkLife_signUpWholeLife_thankU().ThankYou();
    }//end of Test Case 3

    @Test(priority = 2)
    //Test Case 4
    public void ContactUs() throws InterruptedException{
        driver.navigate().to("https://www.newyorklife.com");
        BaseClass.newYorkLife_contactUs().ContactUs(1);
        Thread.sleep(3000);
        BaseClass.newYorkLife_contact().CalllUs();
        BaseClass.newYorkLife_contact().Email("sbhuiyan57@gmail.com");
        BaseClass.newYorkLife_contact().Send();
    }//end of Test Case 4

    @Test(priority = 3)
    //Test Case 5
    public void Covid19(){
        driver.navigate().to("https://www.newyorklife.com");
        BaseClass.newYorkLife_covid().Covid19();
        BaseClass.newYorkLife_covidFAQ().Covid();
        BaseClass.newYorkLife_covidFAQ().Bovid();
    }//end of Test Case 5


}//end of NewYorkLife_POM class

