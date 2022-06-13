package ActionItem;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class UnitedHealthcare {

    public static void main(String[] args) throws InterruptedException {

        ArrayList <String> firstName = new ArrayList<>();

        firstName.add("Aaron");
        firstName.add("Brandon");
        firstName.add("Charles");

        ArrayList <String> lastName = new ArrayList<>();
        lastName.add("Ahmed");
        lastName.add("Byron");
        lastName.add("Chambers");

        ArrayList <String> birthMonth = new ArrayList<>();
        birthMonth.add("01");
        birthMonth.add("02");
        birthMonth.add("03");

        ArrayList <String> birthDay = new ArrayList<>();
        birthDay.add("20");
        birthDay.add("21");
        birthDay.add("23");

        ArrayList <String> birthYear = new ArrayList<>();
        birthYear.add("1990");
        birthYear.add("1991");
        birthYear.add("1992");

        ArrayList <String> zipCode = new ArrayList<>();
        zipCode.add("11208");
        zipCode.add("11207");
        zipCode.add("11206");

        ArrayList <String> memberId = new ArrayList<>();
        memberId.add("1234567890");
        memberId.add("2345678901");
        memberId.add("3456789012");


        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        for(int i = 0; i < firstName.size(); i ++) {

            //Navigate to United Healthcare website
            driver.navigate().to("https://www.uhc.com");
            //wait for web page to load, 3 seconds
            Thread.sleep(3000);

            //capture the title of the page and compare it with your expected title 'Health Insurance plans'
            Reusable_Actions.verifyTitle(driver, "Health insurance plans", "Verify Title");

            //click on 'Find a Doctor'
            Reusable_Actions.clickAction(driver, "//*[@class='position-relative bg-blueDark color-white display-block width-100 lg-bg-white p-4 size-17 talign-center']", "Find a Doctor");

            //click on 'Sign in'
            Reusable_Actions.clickAction(driver, "//*[@class='signin signin-menu__content-wrapper position-relative lg-items-center lg-flex']", "Sign in");

            //click on 'Medicare Plan?'
            Reusable_Actions.clickAction(driver, "//*[text()='Medicare plan?']", "Medicare Plan?");

            //switch to the new tab by calling arraylist from reusable actions
            Reusable_Actions.switchToTabByIndex(driver, 1);

            //click on Register Now
            Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");

            //enter First Name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First Name");

            //enter Last Name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "Last Name");

            //Select Birth Month
            Reusable_Actions.selectByText(driver, "//*[@name='dob_month']", "//*[@value='" + birthMonth.get(i) + "']", "Birth Month");

            //enter Birth Day
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birth day");

            //enter Birth Year
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Last Name");

            //enter zipCode
            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "zipCode");

            //enter memberId
            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberId.get(i), "memberId");

            //click on 'Continue'
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue");

            //capture the error
            String errorMessage = Reusable_Actions.getTextAction(driver, "//*[@id='plainText_error']", "Error message");
            System.out.println(errorMessage);

            //close the driver
            driver.close();

            //switch to the default tab
            Reusable_Actions.switchToTabByIndex(driver, 0);

        }//end of forloop

    }//end of main method

}//end of action item
