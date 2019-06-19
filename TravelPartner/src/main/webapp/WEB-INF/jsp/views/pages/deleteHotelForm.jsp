<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Confirmation</title>
<script src="../../js/ajax.js"></script>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="hotel" action="/hotel/delete/${hotel.id}"
			method="post">
			<fieldset>
				<legend>Delete Confirmation</legend>

				<div class="container">
					<h4>Are you sure, you want to delete " ${hotel.name} " Hotel ?</h4>

					<p id="buttons">
						<input id="submit" type="submit" tabindex="5"
							value="Confirm  Delete">
					</p>
					<p>
						<a href="/hotel/list"><input type="button" tabindex="5"
							value="Cancel Deletion"> </a>
				</div>
			</fieldset>
		</form:form>

	</div>
</body>
</html>