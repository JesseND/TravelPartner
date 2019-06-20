<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Hotel Room</title>
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
    <header>
        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="container">
                    <br> <br>
                    <div class="form-group">
                        <form:form modelAttribute="room" action="/hotel/room/add"
                                   method="post">
                        <fieldset>
                            <legend>Add a Hotel Room</legend>
                            <p>
                                <form:errors path="*" cssStyle="color : red;"/>
                            </p>
                            <label for="hotel"> Select Hotel : </label>
                            <form:select path="roomId.hotelId" class="form-control"
                                         id="hotel" style="width:200px;">
                            <c:forEach items="${hotels}" var="hotel">
                            <option value="${hotel.id}">${hotel.name}</option>
                            </c:forEach>
                            </form:select>
                    </div>
                    <br> <br>
                    <p>
                        <label for="number">Room number: </label>
                            <form:input path="roomId.roomNumber" id="number"/>
                    <div style="text-align: center;">
                        <form:errors path="roomId.roomNumber" cssStyle="color : red;"/>
                    </div>
                    </p>
                    <p>
                        <label for="price">Price per night: </label>
                            <form:input path="pricePerNight" id="price"/>
                    <div style="text-align: center;">
                        <form:errors path="pricePerNight" cssStyle="color : red;"/>
                    </div>
                    </p>
                    <p>
                        <label for="maxPersons">Maximum number of people: </label>
                            <form:input path="maxPersons" id="maxPersons"/>
                    <div style="text-align: center;">
                        <form:errors path="maxPersons" cssStyle="color : red;"/>
                    </div>
                    </p>
                    <br> <br> <br>
                    <p id="buttons">
                        <input id="reset" type="reset" tabindex="4"> <input
                            id="submit" type="submit" tabindex="5" value="Add Hotel Room">
                    </p>
                    </fieldset>
                    </form:form>

                </div>
            </div>
        </nav>
    </header>
</div>
</body>
</html>