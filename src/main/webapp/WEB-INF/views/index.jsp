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
	<h2>Welcome Back, Nishant!!</h2>
	<p>You have 3 ingredients in your inventory.</p>
	<div class="bar">
		<p>
			Overall health:
			<progress max="100" value="77"></progress>
		</p>
	</div>
	<div id="center_button">
		<button id="syncPageLink" onclick="window.location.href = 'addItem';">Add new item</button>
		<button id="asyncPageLink" onclick="window.location.href = 'items';">Show More</button>
	</div>
</body>
</html>