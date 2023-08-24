package com.system.controller;

import com.system.service.UserService;
import com.system.service.impl.UserServiceImpl;
import com.system.utils.Flag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员对于用户的删除
 */
@WebServlet("/userDelete")
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserService userService = new UserServiceImpl();
        boolean b = userService.deleteById(new Integer(id));
        if (b){
            resp.getWriter().write(Flag.getSuccess(null));
        }else {
            resp.getWriter().write(Flag.getFail(null));
        }
    }
}
