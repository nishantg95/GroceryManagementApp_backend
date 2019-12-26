(function(){
	'use strict';
	
	angular
		.module('itemTracker')
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
	                $log.debug("Fetching Repoitems");
	            },
	            function(errResponse){
	                $log.error('Error while fetching RepoItems');
	            }
	        );
	    }
	}
})();