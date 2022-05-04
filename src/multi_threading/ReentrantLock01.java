package multi_threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock01 {
    public static void main(String[] args) {

      Lock lock = new ReentrantLock();
      MyRunnable myRunnable = new MyRunnable(lock);

        Thread thread1 = new Thread(myRunnable,"Passenger 1");
        thread1.start();

        Thread thread2 = new Thread(myRunnable,"Passenger 2");
        thread2.start();

        Thread thread3 = new Thread(myRunnable,"Passenger 3");
        thread3.start();
    }
}

class MyRunnable implements Runnable{

    int ticketsAvailable = 2;
    Lock lock;

    public MyRunnable(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName()+" is waiting to get the ticket");
        lock.lock();
        if(ticketsAvailable>0){
            System.out.println(Thread.currentThread().getName()+" is booking the ticket");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketsAvailable--;
            System.out.println(Thread.currentThread().getName()+" booked the ticket");
            System.out.println("The number of available ticket(s): "+ticketsAvailable);
        }else{
            System.out.println(Thread.currentThread().getName()+" couldn't book the ticket");
        }
        lock.unlock();
    }
}