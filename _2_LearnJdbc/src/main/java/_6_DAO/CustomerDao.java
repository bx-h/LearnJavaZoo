package _6_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDao{
    void insertCustomer(Connection conn, Customer cust);

    void deleteCustomerById(Connection conn, int id);

    void updateCustomerById(Connection conn, int id, Customer cust);

    Customer getCustomerById(Connection conn, int id);

    List<Customer> getCustomers(Connection conn);

    Long getCustomersCount(Connection conn);

    Date getMaxBirth(Connection conn);



}
