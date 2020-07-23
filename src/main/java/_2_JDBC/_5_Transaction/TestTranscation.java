package _2_JDBC._5_Transaction;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestTranscation {

    @Test
    public void test1() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance + 100 where user = ?";
            JdbcUtil_v2.upDate(conn, sql1, "AA");

            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance - 100 where user = ?";
            JdbcUtil_v2.upDate(conn, sql2, "BB");
            System.out.println("转账成功");
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("operation has benn roll back");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }


    }
}
