package com.book.dao.impdao;
import com.book.utils.Jdbcs;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner qr = new QueryRunner();

    /**
     * 对数据库进行操作
     * @param sql   要执行的sql语句
     * @param obj   参数
     * @return  修改受到影响的数据数，影响几条返回几，如果修改失败，返回-1
     */
    public int update(String sql,Object ... obj){
        Connection con = Jdbcs.getConnection();
        try {
            return qr.update(con,sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询返回一个对象的sql
     * @param type  对象类型
     * @param sql   sql语句
     * @param obj   可变长参数
     * @param <T>   泛型
     * @return  返回对象
     */
    public <T> T select(Class<T> type,String sql,Object ... obj){
            Connection con = Jdbcs.getConnection();
        try {
            return qr.query(con,sql,new BeanHandler<T>(type),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 返回查询结果为多数时，以List集合的方式处理结果
     * @param type  返回对象的类型
     * @param sql   sql语句
     * @param obj   可变长参数
     * @param <T>   泛型
     * @return  将结果变成一个List集合然后，返回List集合，如果没有结果返回null
     */
    public <T> List<T> selectList(Class<T> type,String sql,Object ... obj){
        Connection con = Jdbcs.getConnection();
        try {
             return qr.query(con,sql,new BeanListHandler<T>(type),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 返回一个查询结果对象
     * @param sql   要执行的sql语句
     * @param obj   sql语句中的参数
     * @return  返回的结果
     */
    public Object selectObject(String sql ,Object ... obj){
        Connection con = Jdbcs.getConnection();
        try {
            return qr.query(sql,new ScalarHandler(),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
