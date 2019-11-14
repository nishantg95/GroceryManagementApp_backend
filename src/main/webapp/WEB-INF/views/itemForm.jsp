<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
    .required:after { 
    	content:" *";
    	color:red
    }
    .requiredfootnote:before { 
    	content:"* ";
    	color:red
    }
</style>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <br>
        <form:form method="POST"
          action="viewItem" modelAttribute="item">
             <table align="center">
                <tr>
                    <td class="required"><form:label path="name">Name</form:label></td>
                    <td><form:input path="name" required="required" /></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="expiry">
                      Expiry</form:label></td>
                    <td><form:input path="expiry"/></td>
                </tr>
                <tr></tr>
                <tr>
                	<td/>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
                <tr></tr>
                <tr>
                	<td/>
                	<td class="requiredfootnote">Required</td>
                </tr>
            </table>
        </form:form>
    </body>
</html>