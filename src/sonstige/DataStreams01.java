package sonstige;

public class DataStreams01 {

    /*
    There are 3 streams in java
    1)System.out:  It is used to send data out of the program
    2)System.in :  It is used to get data into the program
    3)System.err:  It is used if any error occurs when we read data or file to handle the error
     */
    public static void main(String[] args) {
        //system.in
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter your name");
//        String name = scan.nextLine();
//
//        System.err.println(name);
      try{
          System.out.println(12/0);
      }catch (ArithmeticException e){
          System.out.println("In catch block");
          System.err.println("Dividing by zero is not possible");
      }
    }
}
