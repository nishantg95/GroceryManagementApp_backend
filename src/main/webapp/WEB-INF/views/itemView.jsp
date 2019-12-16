<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<jsp:include page="head.jsp" />
</head>


<body>
	<div class="container">
		<div class="row justify-content-center">
			<h3>Submitted Item Information</h3>
		</div>
		<div class="container-fluid ">
			<div class="row justify-content-center">
				<div class="col-auto">
				<table id="syncFormResult" class="table-sm table-borderless table-responsive">
					<tr>
						<td>Name :</td>
						<td>${item.name}</td>
					</tr>
					<tr>
						<td>ID :</td>
						<td>${item.id}</td>
					</tr>
					<tr>
						<td>Shelf Life:</td>
						<td>${item.shelfLife}</td>
					</tr>
				</table>
				</div>
			</div>
		</div>


		<br> <br>
		<div id="center_button">
			<button id="backFromAsync"
				onclick="window.location.href = 'addItemForm';">Back</button>
		</div>
	</div>
</body>
</html>