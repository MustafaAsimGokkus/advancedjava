package lambda;

import java.math.BigInteger;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class lambda01 {
    public static void main(String[] args) {


//        System.out.println(sum1(4));//10
//        System.out.println(sum2(4));//10
//        System.out.println(sum3(7,13));//30
//        System.out.println(sum4());//2500
//        System.out.println(sum6());//2500 same with 4//        System.out.println(powOfThree(4));
//        System.out.println(anyPowAnyNum(5, 4)); //625
        System.out.println(factorial(20));
    }
    //create a method to find the sum of integers from 1 to x by using structured programming
    public static int sum1 (int x){
        int sum =0;
        for(int i=1; i<=x; i++){
            sum+=i;
        }
        return sum;
  }

    //create a method to find the sum of integers from 1 to x by using functional programming
    //IntStream is an interface to be used in for loops
   public static int sum2(int x){
      return IntStream.rangeClosed(1,x).sum();

   }

  //Create a method to find the sum of even integers from x to y (functional)

  public static int sum3 (int x, int y){
        if(x>y) {x=x+y; y=x-y; x=x-y;

       return IntStream.range(x,y).filter(t->t%2==0).sum();}
       else{
           return IntStream.range(x,y).filter(t->t%2==0).sum();
        }

        }
//Create a method to find the sum of first 50 odd positive integers
    public static int sum4(){
        return IntStream.rangeClosed(1,99).filter(t->t%2==1).sum();
    }

    public static int sum6(){
        return IntStream.iterate(1,t->t+2).limit(50).sum();
    }

    //Create a method to find the any power of 3 (functional)

    public static OptionalInt powOfThree(int x){
        return IntStream.iterate(3,t->t*3).limit(x).reduce((a,b)->b);
    }
    //Create a method to find the any power of any number

    //y th power of x
    public static OptionalInt anyPowAnyNum(int x, int y){
        return IntStream.iterate( x , t->t*x).limit(y).reduce((a,b)->b);
    }
    //create a method to find the neg or pos any power of any integer




    //create a method to calculate the factorial of any number
    public static  BigInteger factorial(int x){
        return IntStream.rangeClosed(1,x).
                mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply);
    }
}
