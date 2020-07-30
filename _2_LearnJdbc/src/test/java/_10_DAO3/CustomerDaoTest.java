/*
 * Copyright (c) 2020/7/30.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 */

package _10_DAO3;

import _8_ConnectionPool.druid.JdbcUtil_druid;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoTest extends TestCase {
    CustomerDao dao = new CustomerDaoImpl();

    public void testInsertCustomer() {
        Connection conn = null;
        Customer cust = new Customer(1, "conie", "conie@126.com", new Date(433124231L));
        try {
            conn = JdbcUtil_druid.getConnection();
            dao.insertCustomer(conn, cust);
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }

    }

    public void testDeleteCustomerById() {
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            dao.deleteCustomerById(conn, 30);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }

    }

    public void testUpdateCustomerById() {
        Connection conn = null;
        Customer cust = new Customer(27, "hbx_admin", "hbx_admin@126.com", new Date(123534234L));
        try {
            conn = JdbcUtil_druid.getConnection();
            dao.updateCustomerById(conn, cust.getId(), cust);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    public void testGetCustomerById() {
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            Customer cust = dao.getCustomerById(conn, 12);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    public void testGetCustomers() {
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            List<Customer> customers = dao.getCustomers(conn);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }

    public void testGetCustomersCount() {
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            Long customersCount = dao.getCustomersCount(conn);
            System.out.println("表中的记录数为：" + customersCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }

    }

    public void testGetMaxBirth() {
        Connection conn = null;
        try {
            conn = JdbcUtil_druid.getConnection();
            Date maxBirth = dao.getMaxBirth(conn);
            System.out.println("最大生日为：" + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil_druid.closeResource(conn, null);
        }
    }
}