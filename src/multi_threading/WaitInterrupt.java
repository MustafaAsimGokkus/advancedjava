package multi_threading;

public class WaitInterrupt {

    public static double balance;

    public static void main(String[] args) {

        WaitInterrupt obj = new WaitInterrupt();
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
                thread1.interrupt();
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
                    //System.out.println("Exception is caught");
                    balance = balance-amount;
                    System.out.println("Withdraw is successfull. Current balance is: "+balance);
                }
            }

        }

    }

    public void deposit(double amount){
        balance=balance + amount;
        System.out.println("Amount is deposited.Current balace is: "+balance);

        }
}
