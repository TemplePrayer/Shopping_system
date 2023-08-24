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
 * 实现将商品添加到购物车
 */
@WebServlet("/carAdd")
public class CarAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String sId = req.getParameter("id");
        String num = req.getParameter("num");

        RecordService recordService = new RecordServiceImpl();
        boolean flag = recordService.addCar(user.getId(), new Integer(sId));
        if (flag){
            resp.getWriter().write(Flag.getSuccess(null));
        }else {
            resp.getWriter().write(Flag.getFail(null));
        }


    }
}
