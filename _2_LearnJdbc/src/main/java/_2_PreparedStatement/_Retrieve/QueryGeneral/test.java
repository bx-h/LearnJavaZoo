package _2_PreparedStatement._Retrieve.QueryGeneral;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String sql = "select order_id orderId, order_name orderName from `order` where order_id >= ?";
        ArrayList<Order> o1 = GeneralForQuery.queryForGeneral(Order.class, sql, 1);
        o1.forEach(System.out::println);
    }
}
