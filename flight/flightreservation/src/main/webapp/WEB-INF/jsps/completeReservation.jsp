<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/7/29
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>
AirLine:${flight.operatingAirlines}<br/>
departureCity:${flight.departureCity}<br/>
arrivalCity:${flight.arrivalCity}<br/>
<form action="completeReservation" method="post">
    <pre>
    <h2>Passenger Details:</h2>
    First Name:<input type="text" name="passengerFirstName"/>
    Last Name:<input type="text" name="passengerLastName"/>
    Email:<input type="text" name="passengerEmail"/>
    Phone:<input type="text" name="passengerPhone"/>

    <h2>Card Details</h2>
    Name on the card:<input type="text" name="nameOnTheCard"/>
    Card No:<input type="text" name="cardNumber"/>
    Expiry Date:<input type="text" name="expirationDate"/>
    Three Digit Sec Code:<input type="text" name="securityCode"/>
        <input type="hidden" name="flightId" value="${flight.id}"/>
    <input type="submit" value="confirm"/>
        </pre>
</form>

</body>
</html>
