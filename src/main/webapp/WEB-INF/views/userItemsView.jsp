<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--need this for c: tag  -->
<html>
	<head>
		<link href="<c:url value='/static/css/master.css' />" rel="stylesheet"></link>
		<title>Grocery Management App</title>
	</head>
    <style>
    
    </style>
    <body data-ng-app="myApp" class="ng-cloak">
    	<!-- Map page to controller -->
    	<div class = "container" data-ng-controller="ItemController as ctrl">
    		<div class ="panel-heading">Items Available</div>
    		<!-- Form Container -->
    		<div class="formcontainer">
    			<form data-ng-submit="ctrl.submit()" name="asyncForm" class="form-inline">
    				 <!-- Hide ID -->
    				 <input type="hidden" data-ng-model="ctrl.item.id" />
    				 <!-- Name field -->
    				 <input type="text" data-ng-model="ctrl.item.name" id="name" 
    				 	class="form-control input-sm" placeholder="Item name" required/>   <!--  TODO: Spans for validation -->
    				 <!-- Expiry field -->
    				 <input type="text" data-ng-model="ctrl.user.expiry" id="expiry"
    				 	class="form-control input-sm" placeholder="Expiry Duration"/>	
    				 <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.item.id ? 'Add' : 'Update'}}" class="btn" ng-disabled="asyncForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
    			
    			
    			<!-- Add Overflow panel for List Items -->
    			</form>
    		<!-- Form Container -->
    		</div>
    	
    	<!-- Map page to controller -->
    	</div>
    
    </body>
</html>