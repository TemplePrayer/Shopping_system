<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>简单购物管理系统</title>
    <script type="text/javascript" src="./resources/jquery/jquery-3.5.1.js"></script>
</head>
<body style="text-align: center;">
<div style="margin-top: 30px;">
    <h1>修改用户信息</h1>
</div>

<form action="<%=PATH%>/updateUser" method="post">
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户编号:</label>
        <input name="id" value="${requestScope.user.id}" readonly />
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户账号:</label>
        <input name="username" type="text" value="${requestScope.user.username}"/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户密码:</label>
        <input name="password" type="text" value="${requestScope.user.password}"/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户等级:</label>
        <input name="level" type="text" value="${requestScope.user.level}"/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户手机号:</label>
        <input name="phone" type="text" value="${requestScope.user.phone}"/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">用户邮箱:</label>
        <input name="email" type="text" value="${requestScope.user.email}"/>
    </div>

    <div style="margin-top: 30px;">
        <button type="submit" style="width: 60px;height: 30px;">确定</button>
        <a href="<%=PATH%>/adminToUser" style="margin-left: 120px;">
            <input type="button" style="width: 60px;height: 30px;" value="返回"/>
        </a>
    </div>
</form>


</body>
</html>
