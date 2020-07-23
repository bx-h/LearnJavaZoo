package _1_JavaSE.ThreadSafe;

public class Account {
    private int actno;
    private double balance;

    public Account() {
    }

    public Account(int actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public int getActno() {
        return actno;
    }

    public void setActno(int actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money) {
        synchronized (this) {
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);

        }
    }
}
