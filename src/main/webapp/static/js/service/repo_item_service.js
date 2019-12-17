(function(){
	'use strict'
	
	angular
		.module('myApp')
		.factory('RepoItemService', RepoItemService);
	
	RepoItemService.inject = ['$http','$log'];
	
	function RepoItemService($http){
		
		var REST_SERVICE_URI = "/GroceryManagementApp/data/repo";
		var factory = {
				fetchAllRepoItems: fetchAllRepoItems,
		};
		return factory;
		
		function fetchAllRepoItems(){
			return $http.get(REST_SERVICE_URI+"/listAllRepoItems").then(function(resp){
				$log.debug(resp.data);
				return resp.data;
			}).catch(function(error){
				$log.error(error);
			});
			
		}		
	}
	
})();