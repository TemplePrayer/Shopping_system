package com.system.controller;

import com.sun.deploy.net.HttpRequest;
import com.system.entity.User;
import com.system.service.UserService;
import com.system.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 用户注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    /**当前日期时间方法 string类型*/
    public static String newDateTime(){
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());
        return datetime;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * 注册用户（账号与密码不可为空）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        /**请求参数中获取信息*/
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        String level = req.getParameter("level");
        //String time = req.getParameter("time");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        /**确保用户与密码不为空，为空弹出对话框提醒用户并将页面重定向到注册页面*/
        if (username.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入用户名！\");\n" +
                    "    document.location.href = \"/shop/register.jsp\";\n" +
                    "</script>";
            resp.getWriter().print(s);
        }else if(password.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入密码！\");\n" +
                    "    document.location.href = \"/shop/register.jsp\";\n" +
                    "</script>";
            resp.getWriter().print(s);
        }else {
            /**若用户名和密码均不为空，则调用UserService的register方法进行注册*/
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(type);
            user.setLevel(level);
            user.setTime(newDateTime());
            user.setPhone(phone);
            user.setEmail(email);
            boolean flag = userService.register(user);
            if (flag){
                String s = "<script>\n" +
                        "    alert(\"注册成功！\");\n" +
                        "    document.location.href = \"/shop\";\n" +
                        "</script>";
                resp.getWriter().print(s);
            }else {
                String s = "<script>\n" +
                        "    alert(\"注册失败！\");\n" +
                        "    document.location.href = \"/shop/register.jsp\";\n" +
                        "</script>";
                resp.getWriter().print(s);
            }
        }

    }
}
