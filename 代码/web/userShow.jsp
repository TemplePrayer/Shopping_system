<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>简单购物管理系统</title>
    <script type="text/javascript" src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
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
    <h1>简单商品管理系统</h1>
</div>

<div style="margin-top: 30px;">
    <a href="<%=PATH%>/userInfo.jsp">
        <input type="button" value="个人信息" style="height: 30px;width: 90px;">
    </a>
    <button onclick="toCar()" style="height: 30px;width: 90px;margin-left: 150px;">查看购物车</button>
    <button onclick="logout()" style="height: 30px;width: 90px;color: red;">退出系统</button>
</div>

<div style="margin-top: 30px;">
    <form action="<%=PATH%>/toUser" method="post">
        <label style="font-size: 20px;">请输入商品名称：</label>
        <input name="shopname" style="height: 25px;"/>
        <button type="submit" style="height: 30px;width: 90px;">查询</button>
    </form>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th>商品编号</th>
            <th>商品名称</th>
            <th>生产厂商</th>
            <th>生产日期</th>
            <th>商品型号</th>
            <th>商品进货价</th>
            <th>商品零售价</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        <c:forEach var="item" items="${requestScope.result}">
            <tr class="double">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.factory}</td>
                <td>${item.date}</td>
                <td>${item.form}</td>
                <td>${item.preprice}</td>
                <td>${item.price}</td>
                <td>${item.num}</td>
                <td>
                    <button onclick="carAdd(${item.id})">加入购物车</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    //查询购物车
    function toCar(){
        window.location.href = "<%=PATH%>/toCar"
    }
    //加入购物车
    function carAdd(id){
        var b = window.confirm("是否要将该商品加入购物车?");
        if (b == true){
            $.ajax({
                url: "<%=PATH%>/carAdd", //到CarAddServlet中进行
                type: "post",
                dataType:"json",
                data:{
                    id:id
                },
                success:function (data){
                    if(data){
                        alert("加入购物车成功！");
                    }else {
                        alert("加入购物车失败！");
                    }
                }

            })
        }
    }
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
                    document.location.href = "<%=PATH%>/toUser"
                }
            }
        })
    }
</script>
</body>
</html>

