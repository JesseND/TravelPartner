<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
<script src="../../js/ajax.js"></script>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="hotel" action="/hotel/update/${ht.id}" method="post">
			<fieldset>
				<legend>Update Hotel</legend>

				<p>
					<form:errors path="*" cssStyle="color : red;" />
				</p>
				<div class="container">
					<h4>Hotel Information :</h4>

					<p>
						<label for="name">Name: </label>
						<form:input path="name" id="name" value="${ht.name}" />
					<div style="text-align: center;">
						<form:errors path="name" cssStyle="color : red;" />
					</div>
					</p>
					<p>
						<label for="description">Description: </label>
						<form:input path="description" type="textArea"
							value="${ht.description}" />
					<div style="text-align: center;">
						<form:errors path="description" cssStyle="color : red;" />
					</div>
					</p>
					<p>
						<label for="ranking">Ranking: </label>
						<form:input path="ranking" value="${ht.ranking}" />
					<div style="text-align: center;">
						<form:errors path="ranking" cssStyle="color : red;" />
					</div>
					</p>
					<p>
						<label for="phone">Phone Number: </label>
						<form:input path="phone" id="phone" value="${ht.phone}" />
						<form:errors path="phone" cssStyle="color : red;" />
					</p>
					<p>
						<label for="capacity">Customer Capacity: </label>
						<form:input path="capacity" id="capacity" value="${ht.capacity}" />
					<div style="text-align: center;">
						<form:errors path="capacity" cssStyle="color : red;" />
					</div>
					</p>
				</div>
				<div class="container">
					<hr>
					<h4>Hotel Location:</h4>
					<p>
						<label for="street">Street: </label>
						<form:input path="location.street" id="street" type="textArea"
							value="${ht.location.street}" />
					<div style="text-align: center;">
						<form:errors path="location.street" cssStyle="color : red;" />
					</div>
					</p>
					<p>
						<label for="city">City: </label>
						<form:input path="location.city" id="city"
							value="${ht.location.city}" />
					<div style="text-align: center;">
						<form:errors path="location.city" cssStyle="color : red; " />
					</div>
					</p>
					<p>
						<label for="city">Country: </label>
						<form:input path="location.country" id="country"
							value="${ht.location.country}" />
					<div style="text-align: center;">
						<form:errors path="location.country" cssStyle="color : red; " />
					</div>
					</p>
					<p>
						<label for="zipcode"> Zip Code: </label>
						<form:input path="location.zipcode" id="zipcode"
							value="${ht.location.zipcode}" />
					<div style="text-align: center;">
						<form:errors path="location.zipcode" cssStyle="color : red; " />
					</div>
					</p>
				</div>
				<hr>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Update Hotel">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>