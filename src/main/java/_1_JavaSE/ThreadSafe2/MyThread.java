package _1_JavaSE.ThreadSafe2;

public class MyThread extends Thread {
    private Account ac;

    public MyThread(Account ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        if (this.getName().equals("t1")) {
            ac.miumiu();
        }
        if (this.getName().equals("t2")) {
            ac.wowow();
        }

    }
}
