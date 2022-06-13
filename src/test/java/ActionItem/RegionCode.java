package ActionItem;

public class RegionCode {

    public static void main(String[] args) {

        //create string array for regions
        String[] region = new String[]{"Northern", "Southern", "Western", "Eastern"};

        //create int array for area codes
        int[] areaCode = new int[]{717, 718, 719, 800};

        //initialize your starting point before calling while loop
        int i = 0;
        //define the end point while loop
        while (i < areaCode.length){
            System.out.println("My region is "  + region[i] + " and my area code is " + areaCode[i]);
            //incrementing
            i = i +1;
        }//end of while group

    }//end of main method

}//end of Java class
