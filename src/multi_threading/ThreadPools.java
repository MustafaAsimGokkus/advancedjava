package multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPools {
    public static void main(String[] args) {
        //ExecutorService is a class
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadCreator thread1 = new ThreadCreator("thread1");
        ThreadCreator thread2 = new ThreadCreator("thread2");
        ThreadCreator thread3 = new ThreadCreator("thread3");
        ThreadCreator thread4 = new ThreadCreator("thread4");
        ThreadCreator thread5 = new ThreadCreator("thread5");
        ThreadCreator thread6 = new ThreadCreator("thread6");
        ThreadCreator thread7 = new ThreadCreator("thread7");
        ThreadCreator thread8 = new ThreadCreator("thread8");
        ThreadCreator thread9 = new ThreadCreator("thread9");
        ThreadCreator thread10 = new ThreadCreator("thread10");

//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
//        thread10.start();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        executorService.execute(thread6);
        executorService.execute(thread7);
        executorService.execute(thread8);
        executorService.execute(thread9);
        executorService.execute(thread10);//the order to run is random but they are running 2 by 2
        executorService.shutdown();
    }
}


class ThreadCreator extends Thread{
    private String threadName;

    public ThreadCreator(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName+" started running");
        try{
        Thread.sleep(2500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(threadName+" stopped running");
    }
}