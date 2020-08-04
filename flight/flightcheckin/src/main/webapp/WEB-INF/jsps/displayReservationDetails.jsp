<%--
  Created by IntelliJ IDEA.
  User: Zonda
  Date: 2020/8/1
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation Details</title>
</head>
<body>
<h2>Flight Details:</h2>
Airline:${reservation.flight.operatingAirlines}<br/>
flightNumber:${reservation.flight.flightNumber}<br/>
departureCity:${reservation.flight.departureCity}<br/>
arrivalCity:${reservation.flight.arrivalCity}<br/>
date Of Departure:${reservation.flight.dateOfDeparture}<br/>
estimated Departure Time:${reservation.flight.estimatedDepartureTime}<br/>

<h2>Passenger Details:</h2>
First Name:${reservation.passenger.firstName}<br/>
last Name:${reservation.passenger.lastName}<br/>
email:${reservation.passenger.email}<br/>
phone:${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
    Enter the Number of Bags You want to check in:<input type="text" name="numberOfBags"/>
    <input type="hidden" value="${reservation.id}" name="id"/>
    <input type="submit" value="Check In"/>

</form>
</body>
</html>
