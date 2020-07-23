package _2_JDBC._3_BatchOperate;

import _2_JDBC.util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class testInsert {
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();

            conn = JdbcUtil.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 2000; ++i) {
                ps.setObject(1, "hbx-robot:" + i);
                ps.addBatch();
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(conn, ps);
        }

    }
}
