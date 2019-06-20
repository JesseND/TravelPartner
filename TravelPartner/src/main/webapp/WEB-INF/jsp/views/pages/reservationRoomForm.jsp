<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserve Hotel Room</title>
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
			<div class="container">
				<br> <br>
				<div class="form-group">
					<form:form modelAttribute="reservation"
						action="/hotel/reservation/${hId}/${rn}" method="post">
						<fieldset>
							<legend>${hname} - Reserve Hotel Room</legend>
							<p>
								<form:errors path="*" cssStyle="color : red;" />
							</p>
							<p>
								<form:hidden path="userId" value="1" />
								<form:hidden path="roomId.roomNumber" value="${rn}" />
								<form:hidden path="roomId.hotelId" value="${hId}" />
							</p>
							<p>Selected Room number: ${rn}</p>
							<p>
								<label for="check_in_date">Check In Date : </label>
								<form:input path="checkin" id="check_in_date" />
							<div style="text-align: center;">
								<form:errors path="checkin" cssStyle="color : red;" />
							</div>
							</p>
							<p>
								<label for="check_out_date">Check Out Date: </label>
								<form:input path="checkout" id="check_out_date" />
							<div style="text-align: center;">
								<form:errors path="checkout" cssStyle="color : red;" />
							</div>
							</p>
							<hr>
							<p id="buttons">
								<input id="reset" type="reset" tabindex="4"
									value="Cancel Reservation" class="btn  col-2"> <input
									id="submit" type="submit" class="btn btn-info col-2"
									tabindex="5" value="Confirm Reservation">
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