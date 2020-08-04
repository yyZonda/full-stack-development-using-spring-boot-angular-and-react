<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/7/29
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
</head>
<body>
<form action="registerUser" method="post">
    <pre>
        <h2>User Registration:</h2>
    First Name:<input type="text" name="firstName"/>
    Last Name:<input type="text" name="lastName"/>
    User Name:<input type="text" name="email"/>
    Password:<input type="password" name="password"/>
    Confirm Password:<input type="password" name="confirmPassword"/>
    <input type="submit" value="register"/>
        </pre>
</form>

</body>
</html>
