package _1_JavaSE.ThreadSafe2;

public class Exam {
    public static void main(String[] args) {
        Account ac = new Account();
        MyThread t1 = new MyThread(ac);
        MyThread t2 = new MyThread(ac);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
