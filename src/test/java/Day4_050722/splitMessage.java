package Day4_050722;

public class splitMessage {

    public static void main(String[] args) {

        //declare string variable
        String splitMessage = "My name is Shak";

        //declare an array of string to store the string
        String[] splitMessageArray = splitMessage.split(" ");

        //print out Shak to the console
        System.out.println("My first name is " + splitMessageArray[3]);

    }//end of main method

}//end of java class
