<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/7/26
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="z"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vendors</h2>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>email</th>
        <th>phone</th>
        <th>address</th>
    </tr>
<c:forEach items="${vendors}" var="vendor">
    <tr>
        <td>${vendor.id}</td>
        <td>${vendor.code}</td>
        <td>${vendor.name}</td>
        <td>${vendor.email}</td>
        <td>${vendor.phone}</td>
        <td>${vendor.address}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
