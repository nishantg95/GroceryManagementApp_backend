<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!--TODO: Move the css to resources/css  -->
<head>
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