package com.book.dao;

import com.book.pojo.User;

public interface BookDao {
    /**
     *  根据用户名查询用户信息
     * @param username  输入用户名查询，用户信息
     * @return  返回用户对象信息  如果有返回用户对象，没有返回null
     */
    User select(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username  用户名
     * @param password  密码
     * @return  返回用户对象，如果有返回对象，如果没有返回null
     */
    User select(String username,String password);
    /**
     *
     */
    int inster(User user);
}
