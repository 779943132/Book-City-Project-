package com.book.service.serviceimp;

import com.book.dao.BookDao;
import com.book.dao.impdao.BookDaoImp;
import com.book.pojo.User;
import com.book.service.SerInter;

public class SerImp implements SerInter {
    BookDao bd = new BookDaoImp();
    @Override
    public Boolean select(String username, String password) {
        User user = bd.select(username, password);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean select(String username) {
        User user = bd.select(username);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public int insert(String username, String password, String email) {
        User user = new User(username,password,email);
        int inster = bd.inster(user);
        if (inster == -1){
            return -1;
        }
        return inster;
    }
}
