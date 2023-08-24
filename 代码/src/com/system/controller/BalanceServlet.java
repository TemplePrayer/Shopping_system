package com.system.controller;

import com.system.entity.User;
import com.system.service.RecordService;
import com.system.service.impl.RecordServiceImpl;
import com.system.utils.Flag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 购物车结算后平衡用户余额
 */
@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sum = req.getParameter("sum");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/");
        }else {
            RecordService recordService = new RecordServiceImpl();
            boolean flag = recordService.balance(user.getId(),sum);
            if (flag){
                resp.getWriter().write(Flag.getSuccess(null));
            }else {
                resp.getWriter().write(Flag.getFail(null));
            }
        }

    }
}
