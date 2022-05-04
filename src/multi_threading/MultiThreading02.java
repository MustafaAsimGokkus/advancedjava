package multi_threading;

import java.util.concurrent.Callable;

public class MultiThreading02 {
    public static void main(String[] args) throws InterruptedException {
        // If my class implements runnable I can put a new object of my class to
        // Thread class constructor

        Long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new CounterWithMultiThread(1));
        Thread thread2 = new Thread(new CounterWithMultiThread(2));

        thread1.start();
        thread2.start();
        Long end = System.currentTimeMillis();

        thread1.join();
        thread2.join();
        System.out.println("Duration of executing threads in 2nd way: " + (end - start) + " miliseconds");

        System.out.println("************************************************************");

        Long start1 = System.currentTimeMillis();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    System.out.println("i=" + i + ", Thread number is:" + 3);
                }
            }
        });
        thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    System.out.println("i=" + i + ", Thread number is:" + 4);
                }
            }
        });
        thread4.start();
        Long end1 = System.currentTimeMillis();
        thread3.join();
        thread4.join();
        System.out.println("Duration of executing threads in 3rd way: " + (end1 - start1) + " miliseconds");


        class CounterMultiThread implements Runnable {

            private int threadNumber;

            public CounterMultiThread(int threadNumber) {
                this.threadNumber = threadNumber;
            }

            public void run() {
                for (int i = 1; i <= 9; i++) {

                    System.out.println("i=" + i + ", Thread number is:" + threadNumber);
                }
            }
        }
    }
}