package _2_PreparedStatement._Update;


import util.JdbcUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPreparedStatement3 {
    public static void main(String[] args) {
        try {
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            String p1 = "lucy";
            String p2 = "lucy@gmail.com";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date udate = null;
            udate = sdf.parse("1998-02-27");
            java.sql.Date p3 = new java.sql.Date(udate.getTime());
            JdbcUtil.upDate(sql, p1, p2, p3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
