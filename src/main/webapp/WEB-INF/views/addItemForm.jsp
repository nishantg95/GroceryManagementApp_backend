<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<jsp:include page="head.jsp" />  
</head>

    <body>
    	<div class="container">
    		<div class="row justify-content-center p-3">
        		<h3>Enter new item</h3>
			</div>
        <div class="row justify-content-center p-5 ">
	        <form:form method="POST" id="syncForm" class="form-group"
	          action="viewItem" modelAttribute="item">
	             <table>
	                <tr>
	                    <td class="required"><form:label path="name">Name:</form:label></td>
	                    <td><form:input path="name" id="nameField" required="required" /></td>
	                </tr>
	                <tr>
	                    <td><form:label path="id">Id:</form:label></td>
	                    <td><form:input id="idField" path="id"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="shelfLife">
	                      Shelf Life:</form:label></td>
	                    <td><form:input id="shelfLifeField" path="shelfLife"/></td>
	                </tr>
	                <tr></tr>
	                <tr>
	                	<td/>
	                    <td><input id="syncSubmitButton" type="submit" value="Submit"/></td>
	                </tr>
	                <tr></tr>
	                <tr>
	                	<td/>
	                	<td class="requiredfootnote">Required</td>
	                </tr>
	            </table>
	        </form:form>
        </div>
        <div class="row justify-content-center p-3">
			<button id="backFromAsync" onclick="window.location.href = 'welcome';">Back</button>
		</div>
		</div>      
    </body>
</html>