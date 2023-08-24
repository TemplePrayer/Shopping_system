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
import java.text.SimpleDateFormat;

/**
 * 实现管理员添加用户
 */
@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
    /**当前日期时间方法 string类型*/
    public static String newDateTime(){
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());
        return datetime;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.sendRedirect("/");
        }else{
            req.getRequestDispatcher("userAdd.jsp").forward(req,resp);
        }
    }

    /**
     * 添加新用户的信息
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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String level = req.getParameter("level");
        //String time = req.getParameter("time");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        /**账号与密码不能为空，为空提醒用户*/
        if (username.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入用户账号！\")\n" +
                    "document.location.href = \"/shop/userAdd\""+
                    "</script>";
            resp.getWriter().print(s);
        }else if(password.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入账号密码！\")\n" +
                    "document.location.href = \"/shop/userAdd\""+
                    "</script>";
            resp.getWriter().print(s);
        }else {
            /**
             *
             * 导入用户信息
             */
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType("顾客");
            user.setLevel(level);
            user.setTime(newDateTime());
            user.setPhone(phone);
            user.setEmail(email);
            boolean flag = userService.register(user);
            if(flag){
                String s = "<script>\n" +
                        "    alert(\"注册成功！\")\n" +
                        "document.location.href = \"/shop/adminToUser\""+
                        "</script>";
                resp.getWriter().print(s);
            }else {
                String s = "<script>\n" +
                        "    alert(\"注册失败！\")\n" +
                        "document.location.href = \"/shop/userAdd\""+
                        "</script>";
                resp.getWriter().print(s);
            }
        }
    }
}
