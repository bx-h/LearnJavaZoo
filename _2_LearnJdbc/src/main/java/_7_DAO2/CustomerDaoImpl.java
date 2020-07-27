package _7_DAO2;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {

    // 也可以用构造函数，保证在调用方法之前，clazz值存在
    // 这段代码放在子类中或许更容易理解，但是对每个BaseDao的每个子类都得写同样的方法，不方便。
//    {
//        Type genericSuperclass = this.getClass().getGenericSuperclass(); // 这个this将指向继承BaseDao的子类实例。创建CustomerDaoImpl时，将指向CustomerDaoImpl的实例
//        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();// 获取了父类（BaseDao）的泛型参数
//        clazz = (Class<T>) actualTypeArguments[0]; //得到了父类的泛型Customer。
//    }


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
        return getOneInstance(conn, sql, id);

    }

    @Override
    public List<Customer> getCustomers(Connection conn) {
        String sql = "select id, name, email, birth from customers";
        return getMultiInstances(conn, sql);
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
