package _2_JDBC._5_Transaction;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil_v2 {
    public static Connection getConnection() throws Exception {
        InputStream is = JdbcUtil_v2.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        return DriverManager.getConnection(url, user, password);

    }

    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (conn != null) conn.close();
            if (ps != null) ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 通用的增删改操作
    public static void upDate(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;

        try {
//            // 1. 获取数据库连接
//            conn = util.JdbcUtil.getConnection();
            // 2. 预编译sql语句
            ps = conn.prepareStatement(sql);

            // 3. 填充占位符
            for (int i = 0; i < args.length; ++i) {
                // 数据库起始下标为1
                ps.setObject(i + 1, args[i]);
            }

            // 4. 执行
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            closeResource(null, ps);
        }
    }
}
