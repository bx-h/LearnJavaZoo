package _9_ApacheCommonDbutils;



import _7_DAO2.Customer;
import _8_ConnectionPool.druid.JdbcUtil_druid;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    // 测试update
    public void testUpdate() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int count = runner.update(conn, sql, "mike2", "mike@126.com", "1998-01-27");
            System.out.println("成功插入 " + count + " 条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    @Test
    // 测试query
    // ResultSetHandler: 接口，用来将不同的查询结果转为object。以下为ResultSetHandler的实现类
    // BeanHandler: 用于封装表中的一条记录。作为java bean 呈现。
    public void query_BeanHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(conn, sql, handler, 18);
            System.out.println(customer);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    @Test
    // BeanListHandler: 用于封装表中的多条记录。作为java bean 呈现。
    public void query_BeanListHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = runner.query(conn, sql, handler, 18);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    @Test
    // MapHandler: 用于封装表中的一条记录。作为 map 呈现。
    public void query_MapHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> query = runner.query(conn, sql, handler, 18);
            System.out.println(query);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    @Test
    // MapListHandler: 用于封装表中的多条记录。作为List<Map> 呈现。
    public void query_MapListHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> query = runner.query(conn, sql, handler, 18);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    @Test
    // ScalarHandler:
    // 用于返回标量。类型人工进行强转。
    public void query_ScalarHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select count(*) from customers";
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(conn, sql, handler);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }


    @Test
    // 自定义handler:
    public void query_CustomerHandler() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    return null;
                }
            };
            Customer customer = runner.query(conn, sql, handler, 12);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    // 关闭资源
    // 自定义handler:
    @Test
    public void test_close() {
        QueryRunner runner = new QueryRunner();
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    return null;
                }
            };
            Customer customer = runner.query(conn, sql, handler, 12);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //JdbcUtil_druid.closeResource(conn, null);
            DbUtils.closeQuietly(conn);
        }
    }

}
