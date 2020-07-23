package _2_JDBC._8_ConnectionPool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class test {
    @Test
    public void testGetConnection() {
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            DataSource source = DruidDataSourceFactory.createDataSource(pro);
            Connection connection = source.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
