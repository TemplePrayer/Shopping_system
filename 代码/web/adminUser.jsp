<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>简单购物管理系统</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <script src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
    <style type="text/css">
        .mytable{
            border:1px solid #A6C1E4;
            font-family:Arial;
            border-collapse: collapse;
        }

        table th{
            border:1px solid black;
            background-color:#71c1fb;
            width:100px;
            height:20px;
            font-size:15px;
        }

        table td{
            border:1px solid #A6C1E4;
            text-align:center;
            height:40px;
            padding-top:5px;
            font-size:15px;
        }

        .double{
            background-color:#c7dff6;
        }
    </style>
</head>
<body style="text-align: center;">
<div style="margin-top: 30px;">
    <h1>简单购物管理系统</h1>
</div>

<div style="margin-top: 30px;">
    <button onclick="toAdmin()" style="height: 30px;width: 90px;">商品信息</button>
    <button onclick="adminToUser()" style="height: 30px;width: 90px;">用户信息</button>
    <button onclick="userAdd()" style="height: 30px;width: 90px;margin-left: 50px;">添加顾客</button>
    <button onclick="logout()" style="height: 30px;width: 90px;color: red;">退出系统</button>
</div>

<div style="margin-top: 30px;">
    <form method="post" action="<%=PATH%>/adminToUser" >
        <label style="font-size: 17px">请输入用户账号：</label>
        <input type="text" name="name" style="height: 25px">
        <button type="submit" style="height: 30px;width: 90px">查询</button>
    </form>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th>用户编号</th>
            <th>用户账号</th>
            <th>用户密码</th>
            <th>用户等级</th>
            <th>注册时间</th>
            <th>用户手机号</th>
            <th>用户邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach var="item" items="${requestScope.result}">
            <tr class="double">
                <td>${item.id}</td>
                <td>${item.username}</td>
                <td>${item.password}</td>
                <td>${item.level}</td>
                <td>${item.time}</td>
                <td>${item.phone}</td>
                <td>${item.email}</td>

                <td>
                    <button onclick="userUpdate(${item.id})">修改</button>
                    <button onclick="userDelete(${item.id})" style="color: red;">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    //退出系统
    function logout(){
        $.ajax({
            url:"<%=PATH%>/logout",
            type:"post",
            success:function (data){
                if(data){
                    alert("退出成功！");
                    document.location.href = "<%=PATH%>/"
                }else {
                    alert("退出失败！");
                    document.location.href = "<%=PATH%>/toAdmin"
                }
            }
        })
    }
    //修改用户信息
    function userUpdate(id){
        window.location.href = "<%=PATH%>/updateUser?id=" + id;
    }
    //删除用户信息
    function userDelete(id){
        var b = window.confirm("你是否确定要删除该条记录？");
        if(b == true){
            $.ajax({
                url:"<%=PATH%>/userDelete",
                type:"post",
                dataType:"json",
                data:{
                    id:id
                },
                success:function (data){
                    if(data){
                        alert("删除成功！");
                        window.location.href = "<%=PATH%>/adminToUser"
                    }else {
                        alert("删除失败！");
                        window.location.href = "<%=PATH%>/adminToUser"
                    }
                }
            })
        }
    }
    //查询商品信息
    function toAdmin(){
        window.location.href = "<%=PATH%>/toAdmin";
    }
    //查询用户信息
    function adminToUser(){
        window.location.href = "<%=PATH%>/adminToUser";
    }
    //添加商品
    function userAdd(){
        window.location.href = "<%=PATH%>/userAdd";
    }
</script>
</body>
</html>

