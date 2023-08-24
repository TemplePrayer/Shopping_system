package com.system.controller;

import com.system.entity.Shop;
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
import java.math.BigDecimal;
import java.util.List;

/**
 * 移除商品
 */
@WebServlet("/toCar")
public class ToCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/");
        }else {
            RecordService recordService = new RecordServiceImpl();
            List<Shop> list = recordService.selectByUid(user.getId());
            BigDecimal sum = new BigDecimal(0.00);
            for (int i = 0; i<list.size(); i++){
                sum = sum.add(list.get(i).getPrice());
            }
            req.setAttribute("result",list);
            req.setAttribute("sum",sum);
            req.getRequestDispatcher("/car.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String cId = req.getParameter("id");

        if (user == null){
            resp.sendRedirect("/");
        }else {
            RecordService recordService = new RecordServiceImpl();
            boolean flag = recordService.removeCar(new Integer(cId));
            if (flag){
                resp.getWriter().write(Flag.getSuccess(null));
            }

        }

    }
}
