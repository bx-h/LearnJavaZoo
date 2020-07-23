package _1_JavaSE.ThreadSafe;

public class main {
    public static void main(String[] args) {
        Account ac = new Account(1, 10000);
        MyRunnable r1 = new MyRunnable(ac);
        MyRunnable r2 = new MyRunnable(ac);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
