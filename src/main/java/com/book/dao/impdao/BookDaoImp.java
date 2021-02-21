package com.book.dao.impdao;

import com.book.dao.BookDao;
import com.book.pojo.User;

public class BookDaoImp extends BaseDao implements BookDao {
    @Override
    public User select(String username) {
        String sql = "select id,username,password,email from user where username = ?";
        return super.select(User.class,sql,username);
    }

    @Override
    public User select(String username, String password) {
        String sql = "select id,username,password,email from user where username = ? and password = ? ";
         return super.select(User.class,sql,username,password);
    }
    //String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
    @Override
    public int inster(User user) {
        String sql = "insert into user(username,password,email) values(?,?,?)";
        return super.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
