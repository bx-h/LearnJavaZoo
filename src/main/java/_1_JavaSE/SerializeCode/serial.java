package _1_JavaSE.SerializeCode;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class serial {
    public static void main(String[] args) throws Exception {
        Student s = new Student(11, "hello");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/hbx1998/Documents/Student"));
        oos.writeObject(s);
        oos.flush();
        oos.close();
    }
}
