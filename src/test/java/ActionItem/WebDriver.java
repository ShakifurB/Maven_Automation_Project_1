package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WebDriver {

    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        options.addArguments("incognito");

        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");

        //setting your driver as headless(running on background)
        //options.addArguments("headless");

        //define the webdriver I am going to use
        org.openqa.selenium.WebDriver driver = new ChromeDriver(options);

        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("tennis");
        hobby.add("kayaking");
        hobby.add("bowling");
        hobby.add("surfing");
        hobby.add("racing");

        for(int i = 0; i < hobby.size(); i++){
            //go to Bing home page
            driver.navigate().to("https://www.bing.com");

            Thread.sleep(3000);

            driver.manage().window().maximize();

            //locate element for search field and type keyword 'hobby'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));

            //submit on bing search button
            driver.findElement(By.xpath("//*[@name='search']")).submit();

            //capture the google search and print it
            String searchResult = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();

            //System.out.println("Result is " +searchResult);

            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");

            System.out.println("My search number " +hobby.get(i) + " is " + arrayResult[0]);
        }//end of forLoop

        Thread.sleep(3000);

        //substring method
        //System.out.println("There are about " + searchResult.substring(0,10) + " results when '" +hobbies.get(i)+ "' is searched" );


        //quit the driver
        driver.quit();

    }//end of main method

}//end of public class
