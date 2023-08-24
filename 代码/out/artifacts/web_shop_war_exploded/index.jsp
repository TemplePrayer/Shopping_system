<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
  String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
  <head>
    <meta charset="utf-8">
    <title>简单购物系统</title>
    <script type="text/javascript" src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
  </head>
  <body style="text-align: center">
  <div style="margin-top: 50px">
    <h1>简单购物管理系统</h1>
    <h3>请登录</h3>
  </div>

  <form method="post" action="<%=PATH%>/login">
    <div>
      <label style="font-size: 25px">账号：</label>
      <input id="username" name="username" type="text" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
      <label style="font-size: 25px">密码：</label>
      <input id="password" name="password" type="password" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
      <label style="font-size: 25px">类型：</label>
      <input name="type" type="radio" value="管理员" checked style="font-size: 20px" >管理员
      <input name="type" type="radio" value="顾客" style="font-size: 20px">顾客
    </div>
    <div style="margin-top: 20px">
      <button type="submit" style="margin-right: 60px;height: 35px;width: 90px">登录</button>
      <button type="reset" style="height: 35px;width: 90px">重置</button>
    </div>
  </form>
  <a href="<%=PATH%>/register.jsp" style="text-decoration: none;margin-left: 120px;color: red">
    没有账号？去注册
  </a>


  </body>
</html>
