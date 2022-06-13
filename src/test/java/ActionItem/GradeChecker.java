package ActionItem;

public class GradeChecker {

    public static void main(String[] args) {

        //declaring integer grade
        int grade = 0;

        //multiple condition statements
        if (grade >= 90 && grade <= 100){
            System.out.println("Grade is A");
        } else if (grade >= 80 && grade <90){
            System.out.println("Grade is B");
        } else if (grade >= 70 && grade <80){
            System.out.println("Grade is C");
        } else if (grade >= 60 && grade <70){
            System.out.println("Grade is D");
        } else if (grade >= 0 && grade <60) {
            System.out.println("Grade is F");
        }

    }//end of main method

}//end of public class
