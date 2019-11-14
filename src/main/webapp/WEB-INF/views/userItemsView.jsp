<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!--need this for c: tag  -->
<html>
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
<style type="text/css">
#inner {
	width: 50%;
	margin: 0 auto;
}
</style>
<body data-ng-app="myApp" class="ng-cloak">
	<!-- Center div -->
	<div id="inner" data-ng-controller="ItemController as ctrl">
		<!-- Map page to controller -->
		<div class="container" >
			<h3>Items Available</h3>
			<!-- Form Container -->
			<div class="formcontainer overflow-auto">
				<form data-ng-submit="ctrl.submit()" name="asyncForm"
					class="form-inline" >
					<!-- Hide ID -->
					<input type="hidden" data-ng-model="ctrl.item.id" />
					<!-- Name field -->
					<input type="text" data-ng-model="ctrl.item.name" id="name"
						class="form-control input-sm" placeholder="Item name" required />
					<!--  TODO: Spans for validation -->
					<!-- Expiry field -->
					<input type="text" data-ng-model="ctrl.item.expiry" id="expiry"
						class="form-control input-sm" placeholder="Expiry Duration" />
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.item.id ? 'Add' : 'Update'}}"
								class="btn">
							<button type="button" data-ng-click="ctrl.reset()" class="btn "
								data-ng-disabled="asyncForm.$pristine">Reset Form</button>
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
								<th>ID</th>
								<th>Name</th>
								<th>Expiry</th>
								<th width="20%"></th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="i in ctrl.items">
								<td>data-ng-bind="i.id"</td>
								<td>data-ng-bind="i.name"</td>
								<td>data-ng-bind="i.expiry"</td>
								<td>
									<button type="button" data-ng-click="ctrl.edit(i.id)"
										class="btn">Edit</button>
									<button type="button" data-ng-click="ctrl.remove(i.id)"
										class="btn ">Remove</button>
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