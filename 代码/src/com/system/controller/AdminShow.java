package com.system.controller;

import com.system.entity.Shop;
import com.system.entity.User;
import com.system.service.ShopService;
import com.system.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * 管理员管理商品页面实现
 * */
@WebServlet("/toAdmin")
public class AdminShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            ShopService shopService = new ShopServiceImpl();
            List list = shopService.selectAll();/**列出所有商品*/
            req.setAttribute("result",list);
            req.getRequestDispatcher("/adminShow.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        ShopService shopService = new ShopServiceImpl();
        if (name.equals("")){
            List list = shopService.selectAll();
            req.setAttribute("result",list);

        }else {
            List list = shopService.selectByName(name);
            req.setAttribute("result",list);
        }
        req.getRequestDispatcher("/adminShow.jsp").forward(req,resp);
    }
}
