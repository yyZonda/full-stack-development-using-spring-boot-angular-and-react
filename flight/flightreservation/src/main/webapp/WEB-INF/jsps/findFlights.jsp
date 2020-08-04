<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/7/29
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Find Flights</title>
</head>
<body>
<h2>Find Flights:</h2>

<form action="findFlights" method="post">
    From: <input type="text" name="from"/>
    To: <input type="text" name="to"/>
    Departure Date: <input type="text" name="departureDate"/>
    <input type="submit" value="search"/>
</form>
</body>
</html>
