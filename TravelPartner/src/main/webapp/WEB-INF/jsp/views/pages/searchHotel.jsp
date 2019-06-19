<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Hotel(s)</title>
</head>
<body>
	<div class="card-header">
		<h3 class="mb-0">Search Hotel(s)</h3>
	</div>

	<form action="/hotel/search/" method="post">

		<!-- Add hidden form field to handle update -->
		<!-- <input type="hidden" th:field="*{id}" /> -->
		<label for="hname"> Enter Hotel Name: </label>
		<p>
			<input type="text" name="hname" id="hname"
				class="form-control mb-4 col-4" placeholder="Hotel Name"
				style="width: 600px;" />
		</p>
		<button type="submit" class="btn btn-info col-2">Search Hotel</button>
	</form>

</body>
</html>