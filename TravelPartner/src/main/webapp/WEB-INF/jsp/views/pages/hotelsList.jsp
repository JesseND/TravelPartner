<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotels</title>
<script src="../../js/ajax.js"></script>
</head>
<body>
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
						<td><c:out value="${hotel.name}" /></td>
						<td><c:out value="${hotel.capacity}" /></td>
						<td><c:out value="${hotel.location.country}" /></td>
						<td><c:out value="${hotel.location.city}" /></td>
						<td><c:out value="${hotel.ranking}" /></td>
						<td><c:out value="${hotel.phone}" /></td>
						<td><a href="/hotel/${hotel.id}">View Details </a></td>
						<td><a href="/hotel/update/${hotel.id}">Update</a></td>
						<td><a href="/hotel/delete/${hotel.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<a href="/"><input type="button" value="return to HomePage" /></a>
</body>
</html>