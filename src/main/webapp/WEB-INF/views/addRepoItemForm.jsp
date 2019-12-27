<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<jsp:include page="head.jsp" />  
</head>

    <body>
    	<div class="container">
    		<div class="row justify-content-center p-5">
        		<h3>Enter new Autocomplete item</h3>
			</div>
        <div class="row justify-content-center p-5 ">
	        <form:form method="POST" id="repo_item_form" class="form-group"
	          action="viewRepoItems" modelAttribute="repoItem">
	             <table>
	                <tr>
	                    <td class="required"><form:label path="rName">Item Name: </form:label></td>
	                    <td><form:input path="rName" id="item_name_Field" required="required" /></td>
	                </tr>
	                <tr>
	                    <td><form:label path="rFridgeDate">Longevity (if Refrigerated): </form:label></td>
	                    <td><form:input path="rFridgeDate" id="repo_refrigerate_date"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="rPantryDate">Longevity (if stored in a Pantry): </form:label></td>
	                    <td><form:input path="rPantryDate" id="repo_pantry_date"/></td>
	                </tr>
	                <tr>
	                    <td><form:label path="rFreezeDate">Longevity (if Frozen): </form:label></td>
	                    <td><form:input path="rFreezeDate" id="repo_freezer_date"/></td>
	                </tr>
	                <tr></tr>
	                <tr>
	                	<td/>
	                    <td><input id="repo_item_add" type="submit" value="Add"/></td>
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
			<button id="backFromAsync" onclick="window.location.href = '../welcome';">Back</button>
		</div>
		</div>      
    </body>
</html>