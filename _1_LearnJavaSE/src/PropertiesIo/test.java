package PropertiesIo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/PropertiesIo/userinfo.properties");
        Properties pro = new Properties();
        pro.load(reader); // 参数可以是reader，也可以是stream
        String usr = pro.getProperty("usr");
        String pw = pro.getProperty("password");
        System.out.println(usr + " : " + pw);
    }
}
