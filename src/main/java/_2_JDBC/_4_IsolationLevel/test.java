package _2_JDBC._4_IsolationLevel;

import _2_JDBC.util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;

public class test {
    @Test
    public void test1() throws Exception{
        Connection conn = JdbcUtil.getConnection();
        System.out.println(conn.getTransactionIsolation());

    }


}
