package ActionItem;

import java.util.ArrayList;

public class CountryCode {

    public static void main(String[] args) {
        //create an ArrayList for countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Switzerland");
        country.add("Bangladesh");
        country.add("Brazil");
        country.add("China");

        //create an ArrayList for country code
        ArrayList<Integer> countryCode = new ArrayList<>() ;
        countryCode.add(1);
        countryCode.add(41);
        countryCode.add(880);
        countryCode.add(55);
        countryCode.add(86);

        //iterate through array of cities
        for (int i = 0; i < country.size(); i++){
            System.out.println("My country is" + country.get(i) + "and my country code is " + countryCode.get(i) + ".");
        }// end of for loop

    }//end of main method

}//end of Java class
