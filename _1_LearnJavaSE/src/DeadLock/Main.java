package DeadLock;

public class Main {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        MyThread1 t1 = new MyThread1(o1, o2);
        MyThread2 t2 = new MyThread2(o1, o2);
        t1.start();
        t2.start();

    }
}
