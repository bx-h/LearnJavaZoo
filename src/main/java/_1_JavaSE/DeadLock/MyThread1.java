package _1_JavaSE.DeadLock;

public class MyThread1 extends Thread {
    private Object o1;
    private Object o2;

    public MyThread1() {
    }

    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }
        }

    }
}
