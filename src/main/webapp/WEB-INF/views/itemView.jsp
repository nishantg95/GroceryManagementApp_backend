<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!--TODO: Move the css to resources/css  -->
<head>
	<!-- Favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/static/favicon/apple-touch-icon.png' />">
	<link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/static/favicon/favicon-32x32.png' />">
	<link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/static/favicon/favicon-16x16.png' />">
	<link href="<c:url value='/static/favicon/site.webmanifest' />" rel="manifest"></link>
	<!-- CSS -->
	<link href="<c:url value='/static/css/master.css' />" rel="stylesheet"></link>
	<title>Grocery Management App</title>
</head>
<body>
	<h3>Submitted Item Information</h3>
	<div id="inner">
		<table id="syncFormResult">
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
	</div>
	<br>
	<br>
	<div id="center_button">
		<button id="backFromAsync" onclick="history.go(-1)">Back</button>
	</div>
</body>
</html>