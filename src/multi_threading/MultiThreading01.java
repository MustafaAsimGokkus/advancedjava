package multi_threading;

public class MultiThreading01 {
    public static void main(String[] args) throws InterruptedException {
       Long startingTime01 =  System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread(2);

        counter1.countMe();
        System.out.println("====================================================================");
        counter2.countMe();
        Long endingTime01 =  System.currentTimeMillis();
        System.out.println("Execution time: " + (endingTime01-startingTime01)+" miliseconds");

        System.out.println("*********************************************************************");

        Long startingTime02 =  System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread(1);
        CounterWithMultiThread counter4 = new CounterWithMultiThread(2);

        counter3.start();
        System.out.println("====================================================================");
        counter4.start();
       //to make java wait for printing the duration of execution sleep() can be used
       // but it is not recommended.Instead of sleep() method we can use join() method
        Thread.sleep(5000);

        counter3.join(); //join() means complete the tasks in multithreading then run sout
        counter4.join();

        Long endingTime02 =  System.currentTimeMillis();
        System.out.println("Execution time with multithread: " + (endingTime02-startingTime02)+" miliseconds");
    }
}

class CounterWithoutMultiThread{
    private int threadNum;

    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void countMe()  {
        for (int i=1;i<=9; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i="+i+", Thread number:"+threadNum);
        }
    }
}

class CounterWithMultiThread extends Thread{

    private int threadNum;

    public CounterWithMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void countMe()  {
        for (int i=1;i<=9; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i="+i+", Thread number:"+threadNum);
        }
    }

    public void run(){
        countMe();
    }
}