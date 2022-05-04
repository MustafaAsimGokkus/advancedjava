package generics;

import java.util.ArrayList;
/*
1)We have to type explicit narrowing code
2)Java needs to do explicit narrowing operation everytime
3)When you get generic concept you will get CTE. Otherwise it will be RTE
 */



public class Generics01 {
    public static void main(String[] args) {
    NonGeneric01 obj1 = new NonGeneric01("String obj without using generic") ;
        System.out.println(obj1);
    String obj1Value = (String)obj1.getObj();    //explicit narrowing
        System.out.println(obj1Value);

        NonGeneric01 obj2 = new NonGeneric01(122) ;
        Integer obj2Value =(Integer)obj2.getObj();
        System.out.println(obj2Value);

        NonGeneric01 obj3 = new NonGeneric01('A') ;
        Character obj3Value = (Character)obj3.getObj();
        System.out.println(obj3Value);

        Generic01<String> obj4 = new Generic01<>("Ali Can");
        String obj4Value = obj4.getObj();
        System.out.println(obj4Value);

        Generic01<Integer> obj5 = new Generic01<>(46465);
        Integer obj5Value = obj5.getObj();
        System.out.println(obj5Value);

    }
}

   class NonGeneric01{
    private Object obj;

       public NonGeneric01(Object obj) {
           this.obj = obj;
       }

       public Object getObj() {
           return obj;
       }

       @Override
       public String toString() {
           return "NonGeneric01{" +
                   "obj=" + obj +
                   '}';
       }
   }
//you can use this class to use data type in every data type
   class Generic01 <T>{
    private T obj;

       public T getObj() {
           return obj;
       }

       public Generic01(T obj) {
           this.obj = obj;

       }

       @Override
       public String toString() {
           return "Generic01{" +
                   "obj=" + obj +
                   '}';
       }
   }

   //create a class which is able to create objects in every number data types
   // but not in other data types
   class Generic02 <T extends Number>{
       private T obj;

       public T getObj() {
           return obj;
       }

       public Generic02(T obj) {
           this.obj = obj;

       }

       @Override
       public String toString() {
           return "Generic01{" +
                   "obj=" + obj +
                   '}';
       }
   }