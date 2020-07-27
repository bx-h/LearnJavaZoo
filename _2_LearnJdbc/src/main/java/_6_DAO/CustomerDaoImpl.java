package _6_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao{

    @Override
    public void insertCustomer(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        upDate(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth());
    }

    @Override
    public void deleteCustomerById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        upDate(conn, sql, id);


    }

    @Override
    public void updateCustomerById(Connection conn, int id, Customer cust) {
        String sql = "update customers set name = ?, email = ?, birth = ? where id = ?";
        upDate(conn, sql, cust.getName(), cust.getEmail(), cust.getBirth(), cust.getId());

    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id, name, email, birth from customers where id = ?";
        return getOneInstance(conn, Customer.class, sql, id);

    }

    @Override
    public List<Customer> getCustomers(Connection conn) {
        String sql = "select id, name, email, birth from customers";
        return getMultiInstances(conn, Customer.class, sql);
    }

    @Override
    public Long getCustomersCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql  = "select max(birth) from customers";
        return getValue(conn, sql);
    }
}
