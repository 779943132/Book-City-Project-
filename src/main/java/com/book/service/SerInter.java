package com.book.service;

import com.book.pojo.User;

public interface SerInter {
    /**
     * 通过用户名和密码查询用户信息
     * @param username
     * @param password
     * @return  找到用户返回用户User ,找不到返回null
     */
    Boolean select(String username,String password);

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return  找到用户返回用户User ,找不到返回null
     */
    Boolean select(String username);

    /**
     * 用户注册
     * @param username
     * @param password
     * @param email
     * @return  返回-1添加失败。
     */
    int insert(String username,String password,String email);
}
