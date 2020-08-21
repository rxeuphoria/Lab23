<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>GRADE FORM</h1>
		<h2>add a grade.</h2>
		<form action="/add" method="post">
			<table class="table">
				<tr>
					<th scope="row">Name</th>
					<td><input type="text" name="name" autofocus pattern="[A-Za-z ]{3,25}" /></td>
				</tr>
				<tr>
					<th scope="row">Type</th>
					<td><input type="text" name="type" pattern="[A-Za-z ]{2,16}"/></td>
				</tr>
				<tr>
					<th scope="row">Score</th>
					<td><input type="number" name="score" max="100" min="0"/></td>
				</tr>
				<tr>
					<th scope="row">Total</th>
					<td><input type="number" name="total" max="100" min="0"/></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Add</button>
			<a class="btn link" href="/">Cancel</a>
		</form>
	</div>

</body>
</html>