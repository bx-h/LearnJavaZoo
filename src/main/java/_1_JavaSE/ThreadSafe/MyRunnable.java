package _1_JavaSE.ThreadSafe;

public class MyRunnable implements Runnable {
    private Account act;

    public MyRunnable(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        act.withdraw(5000);
        System.out.println("Thread: " + Thread.currentThread().getName() + "; account: " + act.getActno() + "; left: "
                + act.getBalance());
    }
}
