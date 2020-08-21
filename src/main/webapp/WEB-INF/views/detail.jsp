<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>grade confirmation.</title>
</head>
<body>
	<div class="container">
		<h1>Here's the grade you entered.</h1>
		<table class="table">
			<tr>
				<th scope="row">Name</th>
				<td>${grade.name}</td>
			</tr>
			<tr>
				<th scope="row">Type</th>
				<td>${grade.type}</td>
			</tr>
			<tr>
				<th scope="row">Score</th>
				<td>${grade.score}</td>
			</tr>
			<tr>
				<th scope="row">Total</th>
				<td>${grade.total}</td>
			</tr>
		</table>
		<a class="btn btn-danger" href="/grades/delete?id=${grade.id}">Delete</a>
		<a class="btn link" href="/">Back to List</a>
	</div>
</body>
</html>