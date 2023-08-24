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
import java.util.List;

/**
 *  商品的修改更新
 */
@WebServlet("/updateShop")
public class ShopUpdateServlet extends HttpServlet {
    /**
     * 不修改时的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/");
        }else {
            String id = req.getParameter("id");
            ShopService shopService = new ShopServiceImpl();
            List<Shop> list = shopService.selectById(new Integer(id));
            Shop shop = new Shop();
            for (int i = 0; i < list.size(); i++) {
                shop.setId(list.get(i).getId());
                shop.setName(list.get(i).getName());
                shop.setFactory(list.get(i).getFactory());
                shop.setDate(list.get(i).getDate());
                shop.setForm(list.get(i).getForm());
                shop.setPreprice(list.get(i).getPreprice());
                shop.setPrice(list.get(i).getPrice());
                shop.setNum(list.get(i).getNum());
            }
            req.setAttribute("shop",shop);
            req.getRequestDispatcher("/shopUpdate.jsp").forward(req,resp);
        }
    }

    /**
     * 发生修改时的更新
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String factory = req.getParameter("factory");
        String date = req.getParameter("date");
        String form = req.getParameter("form");
        String preprice = req.getParameter("preprice");
        String price = req.getParameter("price");
        String num = req.getParameter("num");
        /**修改*/
        ShopService shopService = new ShopServiceImpl();
        Shop shop = new Shop();
        shop.setId(new Integer(id));
        shop.setName(name);
        shop.setFactory(factory);
        shop.setDate(date);
        shop.setForm(form);
        shop.setPreprice(new BigDecimal(preprice));
        shop.setPrice(new BigDecimal(price));
        shop.setNum(new Integer(num));

        boolean b = shopService.updateById(shop);

        if (b){
            String s = "<script>\n" +
                    "    alert(\"修改成功！\");\n" +
                    "    document.location.href = \"/shop/toAdmin\";\n" +
                    "</script>";
            resp.getWriter().print(s);
        }else {
            String s = "<script>\n" +
                    "    alert(\"修改失败！\");\n" +
                    "</script>";
            resp.getWriter().print(s);
        }
    }
}
