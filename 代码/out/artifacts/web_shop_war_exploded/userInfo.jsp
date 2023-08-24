<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>简单购物管理系统</title>
    <script type="text/javascript" src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
</head>
<body style="text-align: center;">
<div style="margin-top: 30px;">
    <h1>简单商品管理系统</h1>
</div>

<div style="margin-top: 30px;">
    <h2>个人信息</h2>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">账号：</label>
    <label style="font-size: 20px;">${sessionScope.user.username}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">密码：</label>
    <label style="font-size: 20px;">${sessionScope.user.password}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">等级：</label>
    <label style="font-size: 20px;">${sessionScope.user.level}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">注册日期：</label>
    <label style="font-size: 20px;">${sessionScope.user.time}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">手机：</label>
    <label style="font-size: 20px;">${sessionScope.user.phone}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">邮箱：</label>
    <label style="font-size: 20px;">${sessionScope.user.email}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">余额：</label>
    <label style="font-size: 20px;">${sessionScope.user.money}</label>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">充值：</label>
    <input id="money" type="text" name="money" style="height: 30px;"/>
    <button onclick="recharge()" style="height: 30px;width: 60px;margin-left: 20px;">确定</button>
</div>

<div style="margin-top: 30px;">
    <button style="height: 30px;width: 90px;margin-left: 20px;">
        <a href="<%=PATH%>/toUser" style="text-decoration:none;color: red">返回</a>
    </button>
</div>

<script>
    function recharge(){
        var money = $("#money").val();

        if(money == ""){
            alert("请输入充值金额！");
        }else{
            $.ajax({
                url:"<%=PATH%>/recharge",
                type:"post",
                dataType:"json",
                data:{
                    id:'${sessionScope.user.id}',
                    money:money
                },
                success:function (data){
                    if (data){
                        alert("充值成功！");
                        window.location.reload();
                    }else{
                        alert("充值失败！");
                        document.location.href = "<%=PATH%>/"
                    }
                }
            })
        }
    }
</script>
</body>
</html>
