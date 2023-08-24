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
import java.util.List;

/**
 * 管理员页面中的用户信息的修改
 */
@WebServlet("/updateUser")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(user == null){
            resp.sendRedirect("/");
        }else {
            UserService userService = new UserServiceImpl();
            String id = req.getParameter("id");
            List<User> list = userService.selectById(new Integer(id));
            User u = new User();
            for (int i = 0; i < list.size(); i++) {
                u.setId(list.get(i).getId());
                u.setUsername(list.get(i).getUsername());
                u.setPassword(list.get(i).getPassword());
                u.setLevel(list.get(i).getLevel());
                u.setPhone(list.get(i).getPhone());
                u.setEmail(list.get(i).getEmail());
            }
            req.setAttribute("user",u);
            req.getRequestDispatcher("/userUpdate.jsp").forward(req,resp);
        }
    }

    /**
     * 修改某位用户的信息
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

        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String level = req.getParameter("level");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");


        UserService userService = new UserServiceImpl();
        boolean flag = userService.updateUser(id,username,password,level,phone,email);

        if (flag){
            String s = "<script>\n" +
                    "    alert(\"修改成功！\");\n" +
                    "    document.location.href = \"/shop/adminToUser\";\n" +
                    "</script>";
            resp.getWriter().print(s);
        }else {
            String s = "<script>\n" +
                    "    alert(\"修改失败！\");\n" +
                    "    document.location.href = \"/shop/updateUser\";\n" +
                    "</script>";
            resp.getWriter().print(s);
        }

    }
}
