<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<jsp:include page="head.jsp" />  
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