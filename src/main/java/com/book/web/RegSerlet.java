package com.book.web;

import com.book.service.SerInter;
import com.book.service.serviceimp.SerImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegSerlet extends HttpServlet {
    SerInter si = new SerImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Boolean select = si.select(username);
        if(code.equalsIgnoreCase("abcde")){
            if (select) {
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else{
                si.insert(username,password,email);
                System.out.println("注册成功");
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码错误，请重新输入");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
