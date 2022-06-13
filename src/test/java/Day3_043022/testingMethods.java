package Day3_043022;

import ReusableLibraries.Reusable_Methods;

public class testingMethods {

    public static void main(String[] args) {

        //call the add two number method and execute it
        Reusable_Methods.addTwoNumbers(20,30);

        //call the return method to subtract two numbers
        int finalResult = Reusable_Methods.subtractTwoNumbers(20, 10);
        int newResult = finalResult + 10;
        System.out.println("New result is " + newResult);

    }//end of main method

}//end of java class
