<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!--TODO: Move the css to resources/css  -->
<head>
<title>Grocery Management App</title>
<link href="<c:url value='/static/css/master.css' />" rel="stylesheet"></link>
</head>
<body>
	<h3>Submitted Item Information</h3>
	<table>
		<tr>
			<td>Name :</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Expiry Duration :</td>
			<td>${expiry}</td>
		</tr>
	</table>
</body>
</html>