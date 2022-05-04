package multi_threading;

public class WaitNotify {
    public static double balance;
 // start()==> this makes the thread in runnable state -car engine started
//  run() ==> e.g.car is moving
    public static void main(String[] args) {

        WaitNotify obj = new WaitNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            obj.withdraw(800); //if not enough money thread will wait
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

                obj.deposit(2000);
            }
        });
        thread2.start();
    }
    public void withdraw(double amount){
         synchronized (this){
             if(balance<=0 || balance<amount){
                 try{
                     System.out.println("Waiting for updating the balance");
                     wait();
                 }catch(InterruptedException e) {
                     e.printStackTrace();

                 }
             }
         }
       balance = balance-amount;
        System.out.println("Withdraw is successfull. Current balance is: "+balance);
    }

    public void deposit(double amount){
        balance=balance + amount;
        System.out.println("Amount is deposited.Current balace is: "+balance);
        synchronized (this){
            notify();
        }
    }
}


