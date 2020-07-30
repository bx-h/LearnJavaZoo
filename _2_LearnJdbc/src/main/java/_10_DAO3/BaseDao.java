/*
 * Copyright (c) 2020/7/30.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * 不会处理连接的开启和关闭，由调用者维护链接
 */

package _10_DAO3;

import _8_ConnectionPool.druid.JdbcUtil_druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    private Class<T> clazz = null;


    // 也可以用构造函数，保证在调用方法之前，clazz值存在
    // 这段代码放在子类中或许更容易理解，但是对每个BaseDao的每个子类都得写同样的方法，不方便。
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass(); // 这个this将指向继承BaseDao的子类实例。创建CustomerDaoImpl时，将指向CustomerDaoImpl的实例
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();// 获取了父类（BaseDao）的泛型参数
        clazz = (Class<T>) actualTypeArguments[0]; //得到了父类的泛型。
    }

    private final QueryRunner queryRunner = new QueryRunner();

    public int update(Connection conn, String sql, Object ...args) throws SQLException {
        return queryRunner.update(conn, sql, args);
    }

    public T queryForOne(Connection conn, String sql, Object ...args) throws SQLException {
        return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), args);
    }

    public List<T> queryForList(Connection conn, String sql, Object ...args) throws SQLException {
        return queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
    }


    public Object queryForSingleValue(Connection conn, String sql, Object ...args) throws SQLException {
        return queryRunner.query(conn, sql, new ScalarHandler(), args);
    }
}
