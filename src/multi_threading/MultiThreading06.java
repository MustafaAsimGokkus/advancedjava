package multi_threading;

public class MultiThreading06 {
    public static void main(String[] args) {
   Brackets03 bracket1 = new Brackets03();
   Brackets03 bracket2 = new Brackets03();

   Thread thread1 = new Thread(new Runnable() {
       @Override
       public void run() {
           for (int i = 0; i < 10; i++) {
               bracket1.generateBrackets("thread1");
           }
           System.out.println("thread1 is completed");
       }
   }) ;
   thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    bracket2.generateBrackets("thread2");
                }
                System.out.println("thread2 is completed");
            }
        }) ;
        thread2.start();
    }
}

 class Brackets03{
    /*
    If you use different objects in different objects sometimes you can get different outputs in every
    execution
    To solve that issue you need static synchronization.The steps to apply static synchronization is:
    Type "synchronized static" before access modifier
    Create parameter for the method
    When you call the method use arguments
     */
     synchronized static public void generateBrackets(String threadName){
        for (int i = 1; i <=10 ; i++) {
            if (i <= 5) {
                System.out.print("[");
            } else {
                System.out.print("]");
            }
        }
        System.out.println("Thread executed "+threadName);
    }
}