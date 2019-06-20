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
                                        <!-- <li><a href="/hotel/search">Search</a> -->
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

            <h2>Hotels List</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Capacity</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Ranking</th>
                    <th>Phone</th>
                    <th>Link</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${hotels}" var="hotel">
                    <tr class="active">
                        <td><c:out value="${hotel.name}"/></td>
                        <td><c:out value="${hotel.capacity}"/></td>
                        <td><c:out value="${hotel.location.country}"/></td>
                        <td><c:out value="${hotel.location.city}"/></td>
                        <td><c:out value="${hotel.ranking}"/></td>
                        <td><c:out value="${hotel.phone}"/></td>
                        <td><a href="/hotel/${hotel.id}">View Details </a></td>
                        <td><a href="/hotel/update/${hotel.id}">Update</a></td>
                        <td><a href="/hotel/delete/${hotel.id}">Delete</a></td>
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