package com.system.controller;

import com.system.dao.UserDao;
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

/**
 * 用户登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * 登录
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
        String type = req.getParameter("type");

        if (username.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入用户名！\");\n" +
                    "    document.location.href = \"/shop\";\n" +
                    "  </script>";
            resp.getWriter().print(s);
        }else if(password.equals("")){
            String s = "<script>\n" +
                    "    alert(\"请输入密码！\");\n" +
                    "    document.location.href = \"/shop\";\n" +
                    "  </script>";
            resp.getWriter().print(s);
        }else{
            UserService userService = new UserServiceImpl();
            User user = userService.login(username, password, type);

            if(user != null){
                //登录成功
                HttpSession session = req.getSession();
                session.setAttribute("user",user);

                if (type.equals("管理员")){
                    resp.sendRedirect("/shop/toAdmin");
                }else{
                    resp.sendRedirect("/shop/toUser");
                }
            }else{
                //登录失败
                String s = "<script>\n" +
                        "    alert(\"登录失败，请检查用户信息！\");\n" +
                        "    document.location.href = \"/shop\";\n" +
                        "  </script>";
                resp.getWriter().print(s);
            }
        }

    }
}
