package _2_JDBC._2_PreparedStatement._Retrieve.QueryCustomers;

import org.junit.Test;

public class test {
    @Test
    public void testQueryForCustomer() {
        String sql = "select id, name, birth, email from customers where id = ?";
        Customer cust = CustomerForQuery.queryForCustomer(sql);
        System.out.println(cust);
    }
}
