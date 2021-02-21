package com.book.test;

import com.book.dao.BookDao;
import com.book.dao.impdao.BookDaoImp;
import com.book.pojo.User;
import org.junit.Test;

public class BookDaoImpTest {
    BookDao bookDao = new BookDaoImp();
    @Test
    public void select() {
        User zhangsan = bookDao.select("lisi");
        if( zhangsan==null){
           System.out.println("无法查询到用户");
       }else {
            System.out.println("用户信息如下"+zhangsan);
       }
    }

    @Test
    public void testSelect() {
        User zhangsan = bookDao.select("zhangsan","passwordzhang");
        if (zhangsan == null) {
            System.out.println("密码错误，或者用户不存在");
        }else {
            System.out.println(zhangsan);
        }
    }

    @Test
    public void inster() {
        User user = new User("admin","admin","admin@qq.com");
        int inster = bookDao.inster(user);
        System.out.println(inster);
    }
}