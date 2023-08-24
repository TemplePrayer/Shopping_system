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

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th>订单号</th>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品价钱</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>

        <c:forEach var="item" items="${requestScope.result}">
            <tr class="double">
                <td>${item.record.id}</td>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.num}</td>
                <td>
                    <button onclick="reomeCar(${item.record.id})">移除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

    <div style="text-align: center;margin-top: 30px;">
        <label style="font-size: 20px;"><strong>合计：</strong></label>
        <label id="sum" style="font-size: 20px;"><strong>${requestScope.sum}</strong></label>
        <button onclick="balance()" style="margin-left: 150px;height: 30px;width: 90px;">结算</button>
        <button onclick="toUser()" style="margin-left: 50px;height: 30px;width: 90px;">返回</button>
    </div>

<script>
    /**
     * 结算
     */
    function balance(){
        var sum = $("#sum").text();
        if (sum == 0){
            alert("购物车为空，请前去购物！");
            window.location.href = "<%=PATH%>/toUser";
        }else {
            var b = window.confirm("你确定要结算吗？");

            if (b == true){
                $.ajax({
                    url: "<%=PATH%>/balance",
                    type: "post",
                    dataType: "json",
                    data: {
                        sum:sum
                    },
                    success:function (data){
                        if (data.flag){
                            alert("结算成功！");
                            window.location.href = "<%=PATH%>/toUser";
                        }else {
                            alert("余额不足，结算失败！")
                        }
                    }
                })
            }
        }
    }
    //返回
    function toUser(){
        window.location.href = "<%=PATH%>/toUser";
    }
    //从购物车移除商品
    function reomeCar(id){
        var b = window.confirm("你确定要从购物车移除该商品吗?");
        if (b == true){
            $.ajax({
                url:"<%=PATH%>/toCar", //用位置为tocar的方法
                type:"post",
                dataType:"json",
                data:{
                    id:id
                },
                success:function (data){
                    if (data){
                        alert("移除成功！");
                        document.location.href = "<%=PATH%>/toCar"
                    }else {
                        alert("移除失败！")
                    }
                }
            })
        }
    }
</script>
</body>
</html>
