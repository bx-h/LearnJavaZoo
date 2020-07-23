package _1_JavaSE.ThreadSafe2;

public class Account {
    private int no = 0;

    public void miumiu() {
        synchronized (this) {
            System.out.println("miumiu start");
            try {
                no = no + 1;
                Thread.sleep(1000);
                System.out.print("miumiu add no: "); // 输出被阻塞，因此到后面才出现。
                System.out.println(getNo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("miumiu over");
        }

    }

    public synchronized void wowow() {
        System.out.println("wowow start");
        System.out.print("wowow add no: ");
        no = no + 3;
        System.out.println(getNo());
        System.out.println("wowow over");
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
