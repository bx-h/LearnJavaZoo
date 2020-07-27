package _6_DAO;

import _5_Transaction.JdbcUtil_v2;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDaoImplTest extends TestCase {
    CustomerDaoImpl dao = new CustomerDaoImpl();

    public void testInsertCustomer() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            Customer cust = new Customer(1, "hbx", "hbx2@126.com", new Date(433124231L));
            dao.insertCustomer(conn, cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testDeleteCustomerById() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            dao.deleteCustomerById(conn, 26);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testUpdateCustomerById() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            Customer cust = new Customer(24, "hbx3", "lucy2@126.com", new Date(123534234L));

            dao.updateCustomerById(conn, cust.getId(), cust);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testGetCustomerById() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();

            Customer cust = dao.getCustomerById(conn, 22);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testGetCustomers() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            List<Customer> customers = dao.getCustomers(conn);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testGetCustomersCount() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            Long customersCount = dao.getCustomersCount(conn);
            System.out.println("表中的记录数为：" + customersCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

    public void testGetMaxBirth() {
        Connection conn = null;
        try {
            conn = JdbcUtil_v2.getConnection();
            Date maxBirth = dao.getMaxBirth(conn);
            System.out.println("最大生日为：" + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_v2.closeResource(conn, null);
        }
    }

}