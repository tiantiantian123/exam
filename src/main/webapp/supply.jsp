<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>supply</title>
    <script>
        function del() {
            return confirm("DEL?");
        }
    </script>
</head>
<body>
<h1>SUPPLIES</h1>
<a href="/add.jsp">新加供应商</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>ADDR</th>
        <th>LINKMAN</th>
        <th>MATERIALS</th>
        <th>TEL</th>
        <th colspan="2">OPERATION</th>
        <c:forEach var="supply" items="${sessionScope.supplies}" varStatus="vs">
    </tr>
    <td>${vs.count}</td>
    <td>${supply.name}</td>
    <td>${supply.addr}</td>
    <td>${supply.linkman}</td>
    <td>${supply.materials}</td>
    <td>${supply.tel}</td>
    <td><a href="/supply?action=search&id=${supply.id}">EDIT</a></td>
    <td><a href="/supply?action=remove&id=${supply.id}" onclick="return del()">REMOVE</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
