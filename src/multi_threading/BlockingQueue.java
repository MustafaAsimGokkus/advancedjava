package multi_threading;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
    public static int counter = 1;
    public static void main(String[] args) {

     ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
     Producer producer = new Producer(queue);
     //producer is accepted because it implements runnable
     Thread producerThread = new Thread(producer);
     producerThread.start();

     Consumer consumer = new Consumer(queue);
     Thread consumerThread = new Thread(consumer);
     consumerThread.start();
    }
}

class Producer implements Runnable{
  private ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       while(true){
           try {
               Thread.sleep(1000);
               queue.put(BlockingQueue.counter);
               System.out.println("Value of counter variable is added to queue "+BlockingQueue.counter);
               BlockingQueue.counter++;
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

class Consumer implements Runnable{

    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
     while(true){
         try {
             Thread.sleep(500);
             queue.take();
             BlockingQueue.counter --;
             System.out.println("Value of counter variable is removed from the queue "+BlockingQueue.counter);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }
}