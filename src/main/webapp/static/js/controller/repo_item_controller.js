(function(){
	'use strict';
	
	angular
		.module('myApp')
		.controller('RepoItemController',RepoItemController);
	
	RepoItemController.inject = ['$scope', 'RepoItemService','$log'];
	
	function RepoItemController($scope, RepoItemService,$log){
		self.repoItems = [];
		fetchAllRepoItems();
		
	    function fetchAllRepoItems(){
	        RepoItemService.fetchAllRepoItems()
	            .then(
	            function(d) {
	                self.repoItems = d;
	                $log.debug("Fetching Repoitems "+self.repoItems);
	            },
	            function(errResponse){
	                $log.error('Error while fetching RepoItems');
	            }
	        );
	    }
	}
})();