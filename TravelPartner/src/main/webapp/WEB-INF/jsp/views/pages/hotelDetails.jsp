<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
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
        <h2>Hotel Details:</h2>

        <h3>${hotel.name}</h3>
        <h4>Ranking: ${hotel.ranking}</h4>
        <h4>Capacity : ${hotel.capacity} Customers</h4>
        <br> <br>
        <h5>
            <b>Location:</b> Street: ${hotel.location.street}, Zip:
            ${hotel.location.zipcode}, City: ${hotel.location.city}, Country:
            ${hotel.location.country},
        </h5>

        <p>${hotel.description}</p>

        <a href="/hotel/${hotel.id}/rooms">
            <button type="button"
                    class="btn btn-info col-2">Make Reservations
            </button>
        </a>
        </td> <br> <br> <br> <a href="/hotel/list"><input
            type="button" value="Back"/></a>

    </div>
</div>
</body>
</html>