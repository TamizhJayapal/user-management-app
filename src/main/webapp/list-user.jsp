<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management Application - User List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="app-header.jsp"%>
	<div class="container">
		<table class="table table-borderd">
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach var="x" items="${users}">

					<tr>
						<td><c:out value="${x.id}" /></td>
						<td><c:out value="${x.name}" /></td>
						<td><c:out value="${x.email}" /></td>
						<td><c:out value="${x.country}" /></td>
						<td><a href="edit?id=<c:out value='${x.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete?id=<c:out value='${x.id}'/>">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>