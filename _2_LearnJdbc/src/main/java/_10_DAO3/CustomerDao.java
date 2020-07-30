/*
 * Copyright (c) 2020/7/30.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 */

package _10_DAO3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    void insertCustomer(Connection conn, Customer cust) throws SQLException;

    void deleteCustomerById(Connection conn, int id) throws SQLException;

    void updateCustomerById(Connection conn, int id, Customer cust) throws SQLException;

    Customer getCustomerById(Connection conn, int id) throws SQLException;

    List<Customer> getCustomers(Connection conn) throws SQLException;

    Long getCustomersCount(Connection conn) throws SQLException;

    Date getMaxBirth(Connection conn) throws SQLException;

}
