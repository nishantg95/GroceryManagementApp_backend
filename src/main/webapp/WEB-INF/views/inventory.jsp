<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!--need this for c: tag  -->
<html>

<head>
	<jsp:include page="head.jsp" />  
</head>


<body ng-app="myApp" >
	<!-- Center div -->
	<div id="inner" ng-controller="ItemController as ctrl">
	
		<!-- Map page to controller -->
		<div class="container" >
			<h3>Items Available</h3>
			<!-- Form Container -->
			<div class="formcontainer overflow-auto">
				<form ng-submit="ctrl.submit()" name="asyncForm"
					class="form-inline" >
					<!-- Hide ID -->
					<input type="text" ng-model="ctrl.item.id" disabled placeholder="ID"/>
					<!-- Name field -->
					<input type="text" ng-model="ctrl.item.name" id="name"
						class="form-control input-sm" placeholder="Item name" required />
					<!--  TODO: Spans for validation -->
					<!-- Shell Life field -->
					<input type="text" ng-model="ctrl.item.shelfLife" id="expiry"
						class="form-control input-sm" placeholder="Shelf Life" />
					<!-- Purchase date field -->
					<input type="text" ng-model="ctrl.item.purchaseDate" id="purchase_date"
						class="form-control input-sm" placeholder="Purchase date" />
					<!-- Storage state drop down -->
					<select name="storage_state" ng-model="ctrl.item.storageState">
						<option value="" disabled selected>Select storage option</option>
    					<option value="Pantry">Pantry</option>
    					<option value="Refrigerator">Refrigerator</option>
    					<option value="Freezer" selected>Freezer</option>
    				</select>
  					<!-- Expiry Date -->
					<input type="text" ng-model="ctrl.item.expiryDate" id="expiry_date"
						class="form-control input-sm" placeholder="Expiry date" />
					<div class="row"><br></div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.item.id ? 'Add' : 'Update'}}"
								class="btn">
							<button type="button" ng-click="ctrl.reset()" class="btn "
								ng-disabled="asyncForm.$pristine">Reset Form</button>
							<button type="button" ng-click="ctrl.fetchAllItems()">Refresh</button>
						</div>
					</div>


					<!-- Add Overflow panel for List Items -->
				</form>
				<!-- Form Container -->
			</div>

			<!-- List view of Items -->
			<div class="panel">
				<!-- Table container div -->
				<div class="tablecontainer" >
					<table class="table">
						<thead>
							<tr>
								<th>Name</th>
								<th>Shell Life</th>
								<th>Storage State</th>
								<th>Purchase Date</th>
								<th>Expiry Date</th>
								<th width="30%"></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="i in ctrl.items">
								<td ng-bind="i.name"></td>
								<td ng-bind="i.shelfLife"></td>
								<td ng-bind="i.storageState"></td>
								<td ng-bind="i.purchaseDate|date:'MM-dd-yyyy'"></td>
								<td ng-bind="i.expiryDate|date:'MM-dd-yyyy'"></td>
								<td>
									<button type="button" ng-click="ctrl.edit(i)"
										class="btn" >Edit</button>
									<button type="button" ng-click="ctrl.remove(i.id)"
										class="btn " >Remove</button>
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
		<br>
		<br>
		<br>
		<br>
		<br>
		<div id="center_button">
			<button id="backFromAsync" onclick="window.location.href = 'welcome';">Back</button>
		</div>
	<!-- Center div -->
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/app.js' />"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/service/item_service.js' />"
		type="text/javascript"></script>
	<script
		src="<c:url value='/static/js/controller/item_controller.js' />"
		type="text/javascript"></script>

</body>
</html>