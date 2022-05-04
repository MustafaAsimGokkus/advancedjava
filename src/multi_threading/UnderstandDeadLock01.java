package multi_threading;

public class UnderstandDeadLock01 {
    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
             synchronized (lock1){
                 System.out.println("Inside thread1 and locked lock1");
                 synchronized (lock2){
                 System.out.println("Inside thread1 and locked lock2");
                 }
             }
            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("Inside thread2 and locked lock2");
                    synchronized (lock1){
                        System.out.println("Inside thread2 and locked lock1");
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

        System.out.println("Execution of threads completed");
    }
}
