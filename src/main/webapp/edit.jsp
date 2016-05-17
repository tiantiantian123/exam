<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h1>EDIT</h1>
<form action="/supply" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${sessionScope.supply.id}">
    <input type="text" name="name" placeholder="NAME" value="${sessionScope.supply.name}"><br>
    <input type="text" name="addr" placeholder="ADDR" value="${sessionScope.supply.addr}"><br>
    <input type="text" name="linkman" placeholder="LINKMAN" value="${sessionScope.supply.linkman}"><br>
    <input type="text" name="materials" placeholder="MATERIALS" value="${sessionScope.supply.materials}"><br>
    <input type="text" name="tel" placeholder="TEL" value="${sessionScope.supply.tel}"><br>
    <input type="submit" value="UPDATE">
</form>
</body>
</html>
