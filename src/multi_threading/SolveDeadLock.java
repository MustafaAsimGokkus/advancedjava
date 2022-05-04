package multi_threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SolveDeadLock {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flagLock1 = false;
                boolean flagLock2 = false;
                boolean doneLock1 = false;
                boolean doneLock2 = false;

                while(true){

               try{
                   if(!flagLock1){
                       flagLock1=lock1.tryLock();
                   }
                   if(!flagLock2){
                       flagLock2=lock2.tryLock();
                   }
               } finally{

                   if(flagLock1 && !doneLock1){
                       System.out.println("Inside the thread1 on lock1");
                       lock1.unlock();
                       doneLock1 = true;
                   }
                   if(flagLock2 && !doneLock2){
                       System.out.println("Inside the thread1 on lock2");
                       lock2.unlock();
                       doneLock2 = true;
                   }
                   if(flagLock1 && flagLock2){
                       break;
                   }

                 }

                }
            }
        });
       thread1.start();



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean flagLock1 = false;
                boolean flagLock2 = false;
                boolean doneLock1 = false;
                boolean doneLock2 = false;

                while(true){

                    try{
                        if(!flagLock1){
                            flagLock1=lock1.tryLock();
                        }
                        if(!flagLock2){
                            flagLock2=lock2.tryLock();
                        }
                    } finally{

                        if(flagLock1 && !doneLock1){
                            System.out.println("Inside the thread2 on lock1");
                            lock1.unlock();
                            doneLock1 = true;
                        }
                        if(flagLock2 && !doneLock2){
                            System.out.println("Inside the thread2 on lock2");
                            lock2.unlock();
                            doneLock2 = true;
                        }
                        if(flagLock2 && flagLock1){
                            break;
                        }

                    }

                }
            }
        });
        thread2.start();

        try{
          thread1.join();
          thread2.join();
        }catch (InterruptedException e){
          e.printStackTrace();
        }

        System.out.println("Execution of threads is completed.");
    }
}
