<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management App - Add User</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="app-header.jsp"%>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<c:if test="${user == null}">
						<form action="insert" method="post">
						<h3>Add New User</h3><br>
					</c:if>
					
					<c:if test="${user != null}">
						<form action="update" method="post">
						<h3>Edit User</h3><br>
						<input type="hidden" name="id" value="<c:out value="${user.id}"/>" />
					</c:if>
					
				
				
				<fieldset class="form-group">
					<input type="text" name="name" placeholder="Name" class="form-control"  value="<c:out value="${user.name}"/>" /> 
				</fieldset>
				
				<fieldset class="form-group">
					<input type="text" name="email" placeholder="Email" class="form-control" value="<c:out value="${user.email}"/>" /> 
				</fieldset>
				
				<fieldset class="form-group">
					<input type="text" name="country" placeholder="Country" class="form-control" value="<c:out value="${user.country}"/>" /> 
				</fieldset>
			
				 <button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>