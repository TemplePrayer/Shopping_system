<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <title>简单购物系统</title>
    <script type="text/javascript" src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
</head>
<body style="text-align: center">
<div style="margin-top: 50px">
    <h1>注册购物管理系统</h1>
</div>

<form method="post" action="<%=PATH%>/register">
    <div>
        <label style="font-size: 25px">账号：</label>
        <input id="username" name="username" type="text" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">密码：</label>
        <input id="password" name="password" type="password" style="height: 30px">
    </div>

    <div style="margin-top: 20px">
        <label style="font-size: 25px">级别：</label>
        <input id="level" name="level" type="level" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">手机：</label>
        <input id="phone" name="phone" type="phone" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">邮箱：</label>
        <input id="email" name="email" type="email" style="height: 30px">
    </div>


    <div style="margin-top: 20px">
        <label style="font-size: 25px">类型：</label>
        <input name="type" type="radio" value="顾客" checked="checked" style="font-size: 20px">顾客
    </div>
    <div style="margin-top: 20px">
        <button type="submit" style="margin-right: 60px;height: 35px;width: 90px">确定</button>
        <a href="<%=PATH%>/" style="text-decoration: none;">
            <input type="button" value="返回" style="margin-left: 60px;height: 35px;width: 90px">
        </a>
    </div>
</form>
</body>
</html>

