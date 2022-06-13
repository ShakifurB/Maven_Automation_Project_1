package ActionItem;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewYorkLife {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    //before suite will set the driver you are using
    //declare javascriptexecutor variable
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html",true);
    }//end of before suite annotation


    //Test Case 1: As a user I want to be able to navigate to NewYorkLife and search for "Insurance Plans" in the search field
    @Test(priority = 1)
    public void SearchForKeyword() throws InterruptedException {
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.newyorklife.com");
        //click on search field
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='d-flex order-lg-3']", logger, "Keyword Search");
        //enter Evaluate Life Insurance Plans in search field
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='search-input']", "Evaluate Life Insurance Plans", logger, "Insurance Plans");
        //click on search button
        Reusable_Actions_Loggers.submitAction(driver, "//*[@class='icon-search']", logger, "Search");
        //wait for page to load
        Thread.sleep(3000);
        //click on the first link that appears from search result
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='font-weight-medium']", 0, logger, "First Link");
        //print intro statement from first link
        String IntroductionStatement = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class='d-none d-lg-block mt-4']", logger, "Introduction Statement");
        System.out.println("Compare Products shows " + IntroductionStatement);
        //verify title is "Compare Products"
        Reusable_Actions_Loggers.verifyTitle(driver, "Compare Products", logger, "Compare Products");
        //end the logger per test
        reports.endTest(logger);
    }//end of test 1


    //Test Case 2: As a user I want to be able to compare whole life and term life insurance
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CompareInsurance() throws InterruptedException {
        logger = reports.startTest("Compare Whole Life and Term Life");
        //click on compare now button for whole life and term life insurance
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='nyl-button--link-text']", 0, logger, "First Compare Now Button");
        //wait for page to load
        Thread.sleep(3000);
        //print the basics for whole life insurance
        String BasicsWholeLife = Reusable_Actions_Loggers.getTextByIndexAction(driver, "//*[@class='cmp-table-row__cell']", 2, logger, "Basics Whole Life");
        System.out.println("The basics of Whole Life Insurance is " + BasicsWholeLife);
        //print the basis for term life insurance
        String BasicsTermLife = Reusable_Actions_Loggers.getTextByIndexAction(driver, "//*[@class='cmp-table-row__cell']", 1, logger, "Basics Term Life");
        System.out.println("The basics of Term Life Insurance is " + BasicsTermLife);
        //print the length of coverage for whole life insurance
        String LengthWholeLife = Reusable_Actions_Loggers.getTextByIndexAction(driver, "//*[@class='cmp-table-row__cell']", 6, logger, "Basics Whole Life");
        System.out.println("The length of coverage for Whole Life Insurance is " + LengthWholeLife);
        //print the length of coverage for whole life insurance
        String LengthTermLife = Reusable_Actions_Loggers.getTextByIndexAction(driver, "//*[@class='cmp-table-row__cell']", 5, logger, "Basics Term Life");
        System.out.println("The length of coverage for Whole Life Insurance is " + LengthTermLife);
    }//end of test 2


    //Test Case 3: As a user I want to be able to provide personal information to connect with a financial professional in your area for whole life insurance
    @Test(dependsOnMethods = "CompareInsurance")
    public void SignUpWholeLife() throws InterruptedException {
        logger = reports.startTest("Sign Up for Whole Life Insurance");
        //click on whole life insurance button
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='nyl-button button--secondary']", 0, logger, "Whole Life Insurance");
        //scroll into submit button
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","1500", logger, "Submit Button");
        Thread.sleep(3000);
        //verify the join our mailing list checkbox is selected or not
        Boolean checkBox = Reusable_Actions_Loggers.checkCheckBox(driver, "//input[@type='checkbox']", logger, "Check Box");
        System.out.println("Is element checked? " + checkBox);
        //enter first name
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_8365000___jqName']", "Shakifur", logger, "First Name");
        //enter last name
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_8830624___jqName']", "Bhuiyan", logger, "Last Name");
        //enter email
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_3670254___jqName']", "sbhuiyan57@gmail.com", logger, "Email");
        //enter phone number
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox___jqName']", "6468536190", logger, "Phone Number");
        //enter address
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_7803718___jqName']", "1070 Crescent St. Apt 1", logger, "Address");
        //enter city
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_1209046___jqName']", "Brooklyn", logger, "City");
        //enter state
        Reusable_Actions_Loggers.selectByText(driver, "//*[@name='guideContainer-rootPanel-guidedropdownlist_co___jqName']", "//*[text()= 'New York']", logger, "State");
        //enter zipcode
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_1299314___jqName']", "11208", logger, "Zipcode");
        //enter date of birth
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='guideContainer-rootPanel-guidetextbox_1482192___jqName']", "06281998", logger, "Birthdate");
        //click submit button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='button-default button-medium submit']", logger, "Submit Button");
        //print submit results (thank you confirmation note)
        String ThankYou = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class='rte cmp-margin-top--large cmp-margin-bottom--large aem-GridColumn--default--none aem-GridColumn aem-GridColumn--default--12 aem-GridColumn--offset--default--0']", logger, "Thank You");
        System.out.println(ThankYou);
    }//end of test 3


    //Test Case 4: As a user I want to be able to contact NewYorkLife if I have any questions or concerns
    @Test(priority = 2)
    public void ContactUs() throws InterruptedException {
        logger = reports.startTest("Contact Us");
        driver.navigate().to("https://www.newyorklife.com");
        //click on contact us button at the top right-hand side
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='nav-item collapsed']", 1, logger, "Contact Us");
        //scroll to "Call" at the bottom of the page
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","1750", logger, "Call");
        Thread.sleep(3000);
        //print phone number and availability
        String CallUs = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class='rte cmp-margin-top--none aem-GridColumn--small--none aem-GridColumn--default--none aem-GridColumn--x-small--12 aem-GridColumn--x-small--none aem-GridColumn aem-GridColumn--small--12 aem-GridColumn--offset--small--0 aem-GridColumn--default--7 aem-GridColumn--offset--x-small--0 aem-GridColumn--offset--default--0']", logger, "Call Us");
        System.out.println(CallUs);
        //scroll to "Sign up for New York Life emails"
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","2250", logger, "Sign Up");
        Thread.sleep(3000);
        //enter email address
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@class='form-control']", "sbhuiyan57@gmail.com", logger, "Email");
        //click send button
        Reusable_Actions_Loggers.submitAction(driver, "//*[@class='cmp-email-subscribe__submit btn btn-outline-secondary']", logger, "Send Button");
    }//end of test 4


    //Test Case 5: As a user I want to be able to find more information about New York Life - Covid-19 resource center
    @Test(priority = 3)
    public void Covid19() throws InterruptedException {
        logger = reports.startTest("Covid19");
        driver.navigate().to("https://www.newyorklife.com");
        //scroll to "Covid-19 Resource Center"
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","1950", logger, "Covid-19");
        Thread.sleep(3000);
        //click on "Visit the Covid-19 resource center" button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='button cmp-margin-bottom--none aem-GridColumn--small--none aem-GridColumn--default--none aem-GridColumn aem-GridColumn--offset--small--0 aem-GridColumn--x-small--4 aem-GridColumn--small--5 aem-GridColumn--offset--default--0 aem-GridColumn--default--4']", logger, "Covid-19 button");
        //scroll to "Covid-19 FAQs"
        Reusable_Actions_Loggers.scrollByPixels(driver, "0","2400", logger, "Covid-19 FAQs");
        Thread.sleep(3000);
        //click on Go button for "Covid-19 FAQs"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='cmp-cta-banner__button']", logger, "Covid-19 FAQs button");
        //copy the page link for "Covid-19 FAQs"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='cmp-social-share__icon--copy']", logger, "Share Link" );
    }//end of test 5


    //Test Case 6: As a user I want to be able to utilize the Retirement Savings
    @Test(priority = 4)
    public void RetirementCalculator() throws InterruptedException {
        logger = reports.startTest("Retirement Calculator");
        driver.navigate().to("https://www.newyorklife.com");
        //hover on LearnAndCompare
        Reusable_Actions_Loggers.mouseHover(driver, "//*[@data-target = '#megamenu-3']", logger, "LearnAndCompare");
        //click on Retirement Saving calculator
        Reusable_Actions_Loggers.clickAction(driver, "//*[@title= 'Retirement Savings Calculator']", logger, "Retirement Saving Calculator" );
        //click on "Get Started" button for RETIREMENT SAVING CALCULATOR
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='cmp-calculator-container__landing-button nyl-button button--primary']", logger, "Get Started");
        //enter age into "How old are you?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='clientAge']", "23", logger, "How old are you?");
        //enter age into "When do you want to retire?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='clientRetAge']", "65", logger, "When do you want to retire?");
        //clear field and enter age into "How long would you like retirement to be?"
        Reusable_Actions_Loggers.sendKeysActionClear(driver, "//*[@name='retirementYears']", "30", logger, "How long would you like retirement to be?");
        //click on "Next" button
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()= 'Next']", logger, "Next");
        //enter amount into "How much do you currently have saved for retirement?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='currentRetirementSavings']", "75000", logger, "currentRetirementSavings");
        //enter amount into "How much do you add to your retirement savings each year?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='annualRetSavings']", "10000", logger, "annualRetSavings");
        //clear field and enter amount into "What is your average rate of return?"
        Reusable_Actions_Loggers.sendKeysActionClear(driver, "//*[@name='annualSavingsIncrease']", "5", logger, "annualSavingsIncrease");
        //click on "Next" button
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()= 'Next']", logger, "Next");
        //enter amount into "What is your current annual income?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='clientIncome']", "120000", logger, "clientIncome");
        //enter amount into "What is your partner's current annual income?"
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='spouseIncome']", "120000", logger, "spouseIncome");
        //clear field and enter amount into "How much of your current income will you need in retirement??"
        Reusable_Actions_Loggers.sendKeysActionClear(driver, "//*[@name='retirementReplacement']", "60", logger, "annualSavingsIncrease");
        //click on "Results" button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='cmp-calculator-container__submit-button nyl-button button--primary']", logger, "Results");
        //print YOUR RESULTS
        String YourResults = Reusable_Actions_Loggers.getTextAction(driver, "//*[@class='cmp-calculator-container__success--description']", logger, "Your Results");
        System.out.println(YourResults);
    }//end of test 6


    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite annotation


}//end of NewYorkLife action item