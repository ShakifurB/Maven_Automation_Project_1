package Day3_043022;

public class MultipleConditionalStatements {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        //if a+b less than c then print the result
        //if a+b is greater than c then print the result
        //finally print a+b is equal to c
        if(a+b < c){
            System.out.println("a & b is less than c");
        } else if(a+b > c) {
            System.out.println("a & b is greater than c");
        } else {
            System.out.println("a & b is equal to c");
        }//end of condition

        //declare additional variables
        int d = 4;
        int e = 5;
        int f = 6;

        //or operator with if statement, using || (or) / && and
        // || is used for or operator
        // && is used for and operator
        if (d < e && f < e) {
            System.out.println("d is less than e or f is less than e");
        } else {
            System.out.println("condition is not true");
        }//end of condition

    }//end of main

}//end of java
