package SerializeCode;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class diserial {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/hbx1998/Documents/Student"));
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }
}
