<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<jsp:include page="head.jsp" />
</head>

<body>
	<h2>Error</h2>
	<p>Hmmmm.Something seems fishy! Well whatever you did, you have managed to break my app. :'(<br>
	If you intentionally tried to break my app, well congrats! You found a bug. Please don't do it again until I patch it.<br>
	If you did not mean to break it, let's give this another go?
	</p>
	<br>
	<br>
	<div id="center_button">
		<button id="backFromSync"
			onclick="window.location.href = 'addItemForm';">Back</button>
				<button id="homeFromSync"
			onclick="window.location.href = 'welcome';">Home</button>
	</div>
</body>
</html>