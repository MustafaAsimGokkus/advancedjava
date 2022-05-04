package multi_threading;

public class MultiThreading05 {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        Brackets01 bracket = new Brackets01();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5 ; i++) {
                    bracket.generateBrackets();
                }

            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    bracket.generateBrackets();
                }

            }
        });
        thread2.start();

       thread1.join();
       thread2.join();
        Long end = System.currentTimeMillis();
        //System.out.println("Duration of synchronized: " + (end - start) + " miliseconds"); //3167
        System.out.println("Duration of synchronized block: " + (end - start) + " miliseconds"); //1566
    }
}

class Brackets01{
     public void generateBrackets(){
         synchronized(this){


         for (int i = 1; i <=10 ; i++) {
            if (i <= 5) {
                System.out.print("[");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();
         }
        for (int i = 0; i <5 ; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}