package com.system.controller;

import com.system.entity.User;
import com.system.service.UserService;
import com.system.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 管理员中对于用户管理页面实现
 */
@WebServlet("/adminToUser")
public class AdminToUserShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/");
        }else {
            UserService userService = new UserServiceImpl();
            List list = userService.selectAll(); /**列出所有用户信息*/
            req.setAttribute("result",list);
            req.getRequestDispatcher("/adminUser.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        UserService userService = new UserServiceImpl();
        List list = userService.selectByName(name);

        req.setAttribute("result",list);
        req.getRequestDispatcher("/adminUser.jsp").forward(req,resp);
    }
}
