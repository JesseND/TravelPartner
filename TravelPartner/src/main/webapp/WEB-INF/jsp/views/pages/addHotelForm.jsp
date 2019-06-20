<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Hotel</title>
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
</div>
<!-- End header -->
<div class="container">
    <form:form modelAttribute="hotel" action="/hotel/add" method="post">
        <fieldset>
            <legend>Add a Hotel</legend>

            <p>
                <form:errors path="*" cssStyle="color : red;"/>
            </p>
            <div class="container">
                <h4>Hotel Information :</h4>

                <p>
                    <label for="name">Name: </label>
                        <form:input path="name" id="name"/>
                <div style="text-align: center;">
                    <form:errors path="name" cssStyle="color : red;"/>
                </div>
                </p>
                <p>
                    <label for="description">Description: </label>
                        <form:input path="description" type="textArea"/>
                <div style="text-align: center;">
                    <form:errors path="description" cssStyle="color : red;"/>
                </div>
                </p>
                <p>
                    <label for="ranking">Ranking: </label>
                        <form:input path="ranking"/>
                <div style="text-align: center;">
                    <form:errors path="ranking" cssStyle="color : red;"/>
                </div>
                </p>
                <p>
                    <label for="phone">Phone Number: </label>
                    <form:input path="phone" id="phone"/>
                    <form:errors path="phone" cssStyle="color : red;"/>
                </p>
                <p>
                    <label for="capacity">Customer Capacity: </label>
                        <form:input path="capacity" id="capacity"/>
                <div style="text-align: center;">
                    <form:errors path="capacity" cssStyle="color : red;"/>
                </div>
                </p>
            </div>
            <div class="container">
                <hr>
                <h4>Hotel Location:</h4>
                <p>
                    <label for="street">Street: </label>
                        <form:input path="location.street" id="street" type="textArea"/>
                <div style="text-align: center;">
                    <form:errors path="location.street" cssStyle="color : red;"/>
                </div>
                </p>
                <p>
                    <label for="city">City: </label>
                        <form:input path="location.city" id="city"/>
                <div style="text-align: center;">
                    <form:errors path="location.city" cssStyle="color : red; "/>
                </div>
                </p>
                <p>
                    <label for="city">Country: </label>
                        <form:input path="location.country" id="country"/>
                <div style="text-align: center;">
                    <form:errors path="location.country" cssStyle="color : red; "/>
                </div>
                </p>
                <p>
                    <label for="zipcode"> Zip Code: </label>
                        <form:input path="location.zipcode" id="zipcode"/>
                <div style="text-align: center;">
                    <form:errors path="location.zipcode" cssStyle="color : red; "/>
                </div>
                </p>
            </div>
            <hr>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4"> <input
                    id="submit" type="submit" tabindex="5" value="Add Hotel">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>