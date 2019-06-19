<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Details</title>
<script src="../../js/ajax.js"></script>
</head>
<body>
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

		<a href="/hotel/${hotel.id}/rooms"><button type="button"
				class="btn btn-info col-2">Make Reservations</button></a>
		</td> <br> <br> <br> <a href="/hotel/list"><input
			type="button" value="Back" /></a>

	</div>
</body>
</html>