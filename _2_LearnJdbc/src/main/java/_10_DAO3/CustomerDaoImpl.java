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

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao{
    @Override
    public void insertCustomer(Connection conn, Customer cust) throws SQLException {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth());
    }

    @Override
    public void deleteCustomerById(Connection conn, int id) throws SQLException {
        String sql = "delete from customers where id = ?";
        update(conn, sql, id);

    }

    @Override
    public void updateCustomerById(Connection conn, int id, Customer cust) throws SQLException {
        String sql = "update customers set name = ?, email = ?, birth = ? where id = ?";
        update(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) throws SQLException {
        String sql = "select id, name, email, birth from customers where id = ?";
        return queryForOne(conn, sql, id);
    }

    @Override
    public List<Customer> getCustomers(Connection conn) throws SQLException {
        String sql = "select id, name, email, birth from customers";
        return queryForList(conn, sql);
    }

    @Override
    public Long getCustomersCount(Connection conn) throws SQLException {
        String sql = "select count(*) from customers";
        return (Long) queryForSingleValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) throws SQLException {
        String sql  = "select max(birth) from customers";
        return (Date) queryForSingleValue(conn, sql);
    }
}
