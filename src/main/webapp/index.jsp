<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>ADMIN LOGIN</h1>
<form action="/admin" method="post">
    username:<input type="text" name="username" placeholder="USERNAME"><br>
    password:<input type="text" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="login">
</form>
</body>
</html>
