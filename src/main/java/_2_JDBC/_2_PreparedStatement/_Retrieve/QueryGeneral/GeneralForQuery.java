package _2_JDBC._2_PreparedStatement._Retrieve.QueryGeneral;



import _2_JDBC.util.JdbcUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class GeneralForQuery {

    public static <T> ArrayList<T> queryForGeneral(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData(); // 要获取返回的表格元素的列数，列名，得使用rsmd

            int columnCount = rsmd.getColumnCount();

            // rs的next()方法：假如有下一个元素，返回true，指针指向下一个元素。假如没有，返回false，指针不动。
            ArrayList<T> list = new ArrayList<>();

            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; ++i) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给cust指定columnName：columnValue的属性，利用反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(conn, ps, rs);
        }
        return null;

    }
}
