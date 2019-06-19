<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Rooms</title>
<script src="../../js/ajax.js"></script>
</head>
<body>
	<div class="container">

		<h2>Hotel Rooms List</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Room Number</th>
					<th>Max Person(s)</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rooms}" var="room">
					<tr class="active">
						<td><c:out value="${room.roomId.roomNumber}" /></td>
						<td><c:out value="${room.maxPersons}" /></td>
						<td><c:out value="$ ${room.pricePerNight}" /></td>
						<td><a
							href="/hotel/reservation/${room.roomId.hotelId}/${room.roomId.roomNumber}">Make
								reservation</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br> <a href="/"><input type="button"
			value="return to HomePage" /></a>
	</div>
</body>
</html>