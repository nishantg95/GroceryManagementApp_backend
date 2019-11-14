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
<style type="text/css">
.bar {
	text-align: center;
	width: 50%;
	margin: 15px auto;
}
</style>
<body>
	<h2>Welcome Back, Nishant!!</h2>
	<p class="centerp">You have 4 ingredients in your inventory.</p>
	<div class="bar">
		<p>
			Overall health:
			<progress max="100" value="77"></progress>
		</p>
	</div>
	<div style="text-align: center">
		<!--
		<form action="addItem">
			<button type="submit" >Show more</button>
		</form> 
		-->
		<button onclick="window.location.href = 'addItem';">Show More</button>
	</div>
</body>
</html>