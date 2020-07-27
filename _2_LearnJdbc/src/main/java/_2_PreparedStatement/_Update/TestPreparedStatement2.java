package _2_PreparedStatement._Update;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPreparedStatement2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, "baixi2");
            ps.setString(2, "huangbx666@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date udate = sdf.parse("1998-02-27");
            java.sql.Date sdate = new java.sql.Date(udate.getTime());
            ps.setDate(3, sdate);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(conn, ps);
        }
    }
}
