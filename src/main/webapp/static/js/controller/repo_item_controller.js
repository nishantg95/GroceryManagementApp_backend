(function(){
	'use strict';
	
	angular
		.module('itemTracker')
		.controller('RepoItemController',RepoItemController);
	
	RepoItemController.inject = ['RepoItemService','$log'];
	
	function RepoItemController(RepoItemService,$log){
		var self = this;
		self.repoItem = {repoItemId:null, repoItemName:'',repoRefigerateDate:'', repoPantryDate:null, repoFreezerDate:null};
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