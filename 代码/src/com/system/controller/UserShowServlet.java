package com.system.controller;

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
 * 用户购物页面展示
 */
@WebServlet("/toUser")
public class UserShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            ShopService shopService = new ShopServiceImpl();
            String shopname = req.getParameter("shopname");

            List list = shopService.selectAll();/**列出所有商品*/
            req.setAttribute("result",list);

            req.getRequestDispatcher("/userShow.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            ShopService shopService = new ShopServiceImpl();
            String shopname = req.getParameter("shopname");
            if (shopname.equals("")){
                List list = shopService.selectAll();
                req.setAttribute("result",list);
            }else {
                List list = shopService.selectByName(shopname);
                req.setAttribute("result",list);
            }

            req.getRequestDispatcher("/userShow.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/");
        }
    }
}
