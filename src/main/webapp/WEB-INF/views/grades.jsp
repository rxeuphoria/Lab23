<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grades</title>
</head>
<body>
<div class="container">
		<h1>Grades in class</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Type</th><th>Score</th><th>Out of</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="grade" items="${grade}">
				<tr>
					<td>${grade.name}</td>
					<td>${grade.type }</td>
					<td>${grade.score}</td>
					<td>${grade.total}</td>
					<td><a class="btn btn-danger" href="/grades/delete?id=${grade.id}">Delete</a>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add" class="btn btn-secondary">Add Grade</a>
		
	</div>
</body>
</html>