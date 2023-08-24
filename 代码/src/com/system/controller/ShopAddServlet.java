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
import java.math.BigDecimal;

/**
 * 管理员页面中对商品的添加
 */
@WebServlet("/shopAdd")
public class ShopAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(user == null){
            resp.sendRedirect("/");
        }else {
            req.getRequestDispatcher("/shopAdd.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String factory = req.getParameter("factory");
        String date = req.getParameter("date");
        String form = req.getParameter("form");
        String preprice = req.getParameter("preprice");
        String price = req.getParameter("price");
        String num = req.getParameter("num");

        /**
         *添加商品的各个信息都不能不能为空，否则会弹出对话框提醒用户
         * */
        if (name.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品名称！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(price.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品单价！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(date.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品生产日期！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(preprice.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品进货价！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(num.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品数量！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(factory.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品的生产厂家！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(form.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入商品类型！\")\n" +
                    "  document.location.href = \"/shop/shopAdd.jsp\";" +
                    "</script>";
            resp.getWriter().print(s);
        }else {
            ShopService shopService = new ShopServiceImpl();
            Shop shop = new Shop();
            shop.setName(name);
            shop.setFactory(factory);
            shop.setDate(date);
            shop.setForm(form);
            shop.setPreprice(new BigDecimal(preprice));
            shop.setPrice(new BigDecimal(price));
            shop.setNum(new Integer(num));

            boolean flag = shopService.add(shop);
            if(flag){
                String s = "<script>\n" +
                        "    alert(\"添加成功！\")\n" +
                        "  document.location.href = \"/shop/toAdmin\";" +
                        "</script>";
                resp.getWriter().print(s);
            }else {
                String s = "<script>\n" +
                        "    alert(\"添加失败！\")\n" +
                        "</script>";
                resp.getWriter().print(s);
            }
        }
    }
}
