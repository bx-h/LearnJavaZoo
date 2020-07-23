package _2_JDBC._7_DAO2;


import _2_JDBC._5_Transaction.JdbcUtil_v2;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {

    private Class<T> clazz = null;


    // 也可以用构造函数，保证在调用方法之前，clazz值存在
    // 这段代码放在子类中或许更容易理解，但是对每个BaseDao的每个子类都得写同样的方法，不方便。
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass(); // 这个this将指向继承BaseDao的子类实例。创建CustomerDaoImpl时，将指向CustomerDaoImpl的实例
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();// 获取了父类（BaseDao）的泛型参数
        clazz = (Class<T>) actualTypeArguments[0]; //得到了父类的泛型。
    }



    public int upDate(Connection conn, String sql, Object ...args) {
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
//          * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
//          * or (2) 0 for SQL statements that return nothing
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JdbcUtil_v2.closeResource(null, ps);
        }
        return 0;
    }


    public T getOneInstance(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData(); // 要获取返回的表格元素的列数，列名，得使用rsmd

            int columnCount = rsmd.getColumnCount();

            // rs的next()方法：假如有下一个元素，返回true，指针指向下一个元素。假如没有，返回false，指针不动。
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; ++i) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给cust指定columnName：columnValue的属性，利用反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(null, ps, rs);
        }
        return null;

    }


    public List<T> getMultiInstances(Connection conn, String sql, Object ...args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

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
            JdbcUtil_v2.closeResource(null, ps, rs);
        }
        return null;

    }


    public <T> T getValue(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return (T) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(null, ps, rs);
        }

        return null;
    }

}
