package multi_threading;

import java.util.concurrent.CountDownLatch;
/*
1)If you want to run all threads before the other non-thread codes in main method use "latch"
2)Whe you use "latch" you need to use await() and countDown() methods.
await(): it makes non thread codes in main method wait for thread executions
countDown(): it counts the threads, if all the threads are executed then non-thread codes start to run
3) await() should be used just after the thread start() methods and before non-thread codes.
 countDown(): should be used inside the run().
 */
public class Latch { //kapi mentesesi
    //if u wanna run thread before all other codes you need to use latch
    public static void main(String[] args)  {
     CountDownLatch latch = new CountDownLatch(4);

        ThreadCreator2 thread1 = new ThreadCreator2(latch);
        ThreadCreator2 thread2 = new ThreadCreator2(latch);
        ThreadCreator2 thread3 = new ThreadCreator2(latch);
        ThreadCreator2 thread4 = new ThreadCreator2(latch);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        try {
            latch.await(); //by awaait() non-thread methods wait for thread methods
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //non-thread codes
        System.out.println("First code inside the main method");
        System.out.println("Second code inside the main method");
    }
}

class ThreadCreator2 extends Thread{
    private CountDownLatch latch;

    public ThreadCreator2(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" thread is running");
        System.out.println(Thread.currentThread().getName()+" thread execution stopped");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();//if u want non-thread codes to run just after threads use countDown()
    }
}