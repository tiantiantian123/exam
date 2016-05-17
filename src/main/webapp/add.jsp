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
    <title>add</title>
</head>
<body>
<h1>ADD SUPPLY</h1>
<form action="/supply" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" placeholder="NAME"><br>
    <input type="text" name="addr" placeholder="ADDR"><br>
    <input type="text" name="linkman" placeholder="LINKMAN"><br>
    <input type="text" name="materials" placeholder="MATERIALS"><br>
    <input type="text" name="tel" placeholder="TEL"><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
