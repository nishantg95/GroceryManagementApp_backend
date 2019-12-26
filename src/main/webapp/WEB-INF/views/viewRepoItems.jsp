<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<jsp:include page="head.jsp" />
</head>


<body>
	<div class="container">
		<div class="row justify-content-center">
			<h3>Admin Panel</h3>
		</div>
		<div class="container-fluid ">
			<div class="row justify-content-center">
				<div class="col-auto">
				<table id="syncFormResult" class="table-sm table-borderless table-responsive">
					<tr>
						<td>Item Name :</td>
						<td>${repoItem.rName}</td>
					</tr>
					<tr>
						<td>Refrigerator Longevity :</td>
						<td>${repoItem.rFridgeDate}</td>
					</tr>
					<tr>
						<td>Pantry Longevity:</td>
						<td>${repoItem.rPantryDate}</td>
					</tr>
					<tr>
						<td>Freezer Longevity:</td>
						<td>${repoItem.rFreezeDate}</td>
					</tr>
				</table>
				</div>
				<div data-ng-app="itemTracker" >
					<table data-ng-controller="RepoItemController as ctrl" 
						class="table table-light table-hover" id="repo_items">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Fridge Longevity</th>
								<th>Freezer Longevity</th>
								<th>Pantry Longevity</th>
							</tr>
						</thead>
						<tbody>
							<tr data-ng-repeat="i in ctrl.repoItems">
								<td data-ng-bind="i.rId"></td>
								<td data-ng-bind="i.rName"></td>
								<td data-ng-bind="i.rFridgeDate"></td>
								<td data-ng-bind="i.rFreezeDate"></td>
								<td data-ng-bind="i.rPantryDate"></td>
							</tr>
						
						</tbody>					
					</table>				
				</div>
			</div>
		</div>


		<br> <br>
		<div id="center_button">
			<button id="backFromAsync"
				onclick="window.location.href = 'addRepoItemForm';">Back</button>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.10/angular.min.js"
		type="text/javascript">
	</script>

	<script src="<c:url value='/static/js/app.js' />"
		type="text/javascript">
	</script>
	<script
		src="<c:url value='/static/js/controller/repo_item_controller.js' />"
		type="text/javascript">
	</script>
	<script
		src="<c:url value='/static/js/ui-bootstrap.min.js' />"
		type="text/javascript">
	</script>
	<script src="<c:url value='/static/js/service/repo_item_service.js' />"
		type="text/javascript">
	</script>
</html>