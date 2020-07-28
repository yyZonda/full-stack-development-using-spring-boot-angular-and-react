<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/7/26
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create Vendor</title>
</head>
<body>

<form action="saveVendor" method="post">
    <pre>
    Id:<input type="text" name="id">
    Code:<input type="text" name="code">
    Name:<input type="text" name="name">
    Email:<input type="text" name="email">
    Phone:<input type="text" name="phone">
    Address:<input type="text" name="address">
    <input type="submit" value="save">
</pre>
</form>

${msg}
<a href="displayVendors">viewAll</a>
</body>
</html>
