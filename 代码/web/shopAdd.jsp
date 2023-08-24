<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>简单购物管理系统</title>
    <script type="text/javascript" src="<%=PATH%>/resources/jquery/jquery-3.5.1.js"></script>
</head>
<body style="text-align: center;">
<div style="margin-top: 30px;">
    <h1>添加商品信息</h1>
</div>

<form action="<%=PATH%>/shopAdd" method="post">
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">商品名称:</label>
        <input name="name" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">生产厂商:</label>
        <input name="factory" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">生产日期:</label>
        <input name="date" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">商品型号:</label>
        <input name="form" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">商品进货价:</label>
        <input name="preprice" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">商品零售价:</label>
        <input name="price" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <label style="font-size: 20px;">商品数量:</label>
        <input name="num" type="text" value=""/>
    </div>
    <div style="margin-top: 30px;">
        <button type="submit" style="width: 60px;height: 30px;">确定</button>
        <a href="<%=PATH%>/toAdmin" style="margin-left: 120px;">
            <input type="button" style="width: 60px;height: 30px;" value="返回"/>
        </a>
    </div>
</form>

</body>
</html>
