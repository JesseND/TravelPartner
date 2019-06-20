<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Hotels</title>
    <link rel="stylesheet" href="../../../css/main.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="body-container">

    <!-- Begin header -->
    <div id="header">
        <!-- navBar menu -->
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="container">
                    <div class="container">
                        <div class="container">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="/">TravelPartner</a>
                            </div>
                            <ul class="nav navbar-nav">
                                <li class="dropdown"><a class="dropdown-toggle"
                                                        data-toggle="dropdown" href="/hotel/list">Hotel <span
                                        class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/hotel/list">Hotels List</a></li>
                                        <li><a href="/hotel/add">Add Hotel</a></li>
                                    </ul>
                                </li>

                                <li class="dropdown"><a class="dropdown-toggle"
                                                        data-toggle="dropdown" href="#">Room<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/hotel/room/add">Add </a></li>
                                        <li><a href="/hotel/room/update">Update</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <!-- End header -->

    <div class="container">
        <div class="container">

            <h2>My Reservations </h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Check In Date </th>
                    <th>Check Out Date </th>
                    <th>Reservation Status</th>
                    <th>Hotel Id</th>
                    <th>Room Number</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${myReservations}" var="myReservation">
                    <tr class="active">
                        <td><c:out value="${myReservation.checkin}"/></td>
                        <td><c:out value="${myReservation.checkout}"/></td>
                        <td><c:out value="${myReservation.status}"/></td>
                        <td><c:out value="${myReservation.roomId.hotelId}"/></td>
                        <td><c:out value="${myReservation.roomId.roomNumber}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/"><input type="button" value="return to HomePage"/></a>
        </div>
    </div>

</div>
</body>

</body>
</html>