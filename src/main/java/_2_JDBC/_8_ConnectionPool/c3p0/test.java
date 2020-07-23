package _2_JDBC._8_ConnectionPool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

public class test {
    // 方式一
    @Test
    public void testGetConnection() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("716666");
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    // 方式二 使用配置文件
    @Test
    public void testGetConnection2() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0file");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
