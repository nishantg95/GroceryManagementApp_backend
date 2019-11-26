(function(){
	'use strict'
	
	angular
		.module('myApp')
		.factory('ItemService', ItemService);
	
	ItemService.inject = ['$http'];
	
	function ItemService($http){
		
		var REST_SERVICE_URI = "/GroceryManagementApp/data/items";
		var factory = {
				fetchAllItems: fetchAllItems,
				createItem: createItem,
				updateItem: updateItem,
				deleteItem: deleteItem
		};
		
		return factory;
		
		function fetchAllItems(){
			return $http.get(REST_SERVICE_URI).then(function(resp){
				console.log(resp.data);
				return resp.data;
			}).catch(function(error){
				console.error(error);
			});
			
		}
		
		function createItem(item){
			return $http.post(REST_SERVICE_URI+"/item", item).then(function(resp){
				console.debug(resp.data);
			}).catch(function(error){
				console.error(error);
			});
		}
		
		function updateItem(item, id){
			return $http.put(REST_SERVICE_URI+"/item/"+id, item).then(function(resp){
				console.debug(resp.data);
			}).catch(function(error){
				console.error(error);
			});
		}
		
		function deleteItem(id) {
			return $http.delete(REST_SERVICE_URI+"/item/"+id).then(function(resp){
				console.debug(resp.data);
			}).catch(function(error){
				console.error(error);
			});
		}
		
	}
	
})();