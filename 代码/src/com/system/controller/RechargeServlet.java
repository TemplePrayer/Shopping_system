package com.system.controller;

import com.system.dao.impl.UserDaoImpl;
import com.system.entity.User;
import com.system.service.UserService;
import com.system.service.impl.UserServiceImpl;
import com.system.utils.Flag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 充值功能的实现
 * */
@WebServlet("/recharge")
public class RechargeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String money = req.getParameter("money");

        UserService userService = new UserServiceImpl();
        boolean flag = userService.recharge(new Integer(id), new BigDecimal(money));
        if(flag){
            HttpSession session = req.getSession();
            session.setAttribute("user",new UserDaoImpl().selectById(new Integer(id)));
            resp.getWriter().write(Flag.getSuccess(null));
        }else {
            resp.getWriter().write(Flag.getFail(null));
        }


    }
}
