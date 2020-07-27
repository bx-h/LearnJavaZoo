package _4_IsolationLevel;


import org.junit.Test;
import util.JdbcUtil;

import java.sql.Connection;

public class test {
    @Test
    public void test1() throws Exception{
        Connection conn = JdbcUtil.getConnection();
        System.out.println(conn.getTransactionIsolation());

    }


}
