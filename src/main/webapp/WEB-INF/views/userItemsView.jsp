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
    		<div class="formcontainer overflow-auto">
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
                              <input type="submit"  value="{{!ctrl.item.id ? 'Add' : 'Update'}}" class="btn">
                              <button type="button" data-ng-click="ctrl.reset()" class="btn " data-ng-disabled="asyncForm.$pristine">Reset Form</button>
                          </div>
                      </div>
    			
    			
    			<!-- Add Overflow panel for List Items -->
    			</form>
    		<!-- Form Container -->
    		</div>
    		
    		<!-- List view of Items -->
    		<div class ="panel">
    			<!-- Table container div -->
    			<div class="tablecontainer">
    				<table class = "table">
    					<thead>
    						<tr>
    							<th>ID</th>
    							<th>Name</th>
    							<th>Expiry</th>
    						</tr>
    					</thead>
    					<tbody>
    						<tr data-ng-repeat="i in ctrl.items">
    							<td> data-ng-bind="i.id" </td>
    							<td> data-ng-bind="i.name" </td>
    							<td> data-ng-bind="i.expiry" </td>
    							<td>
    								<button type="button" data-ng-click="ctrl.edit(i.id)" class="btn">Edit</button>
    								<button type="button" data-ng-click="ctrl.remove(i.id)" class="btn ">Remove</button>
    							</td>
    						</tr>
    					
    					</tbody>
    				</table>
    			</div>
    			<!-- Table container div -->
    		
    		<!-- List view of Items -->
    		</div>
    	
    	<!-- Map page to controller -->
    	</div>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      	<script src="<c:url value='/static/js/app.js' />"></script>
     	 <script src="<c:url value='/static/js/service/item_service.js' />"></script>
      	<script src="<c:url value='/static/js/controller/item_controller.js' />"></script>
    
    </body>
</html>