package com.book.web;

import com.book.service.SerInter;
import com.book.service.serviceimp.SerImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogServel extends HttpServlet {
    SerInter si = new SerImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(si.select(username)){
            if (si.select(username,password)){
                System.out.println("登录成功");
                req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
            }else {
                System.out.println("密码错误");
                req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
            }
        }else {
            System.out.println("用户名不存在");
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }
    }
}
