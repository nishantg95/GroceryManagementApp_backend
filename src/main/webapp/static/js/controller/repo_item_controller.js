(function(){
	'use strict';
	
	angular
		.module('myApp')
		.controller('RepoItemController',RepoItemController);
	
	RepoItemController.inject = ['$scope', 'RepoItemService','$log'];
	
	function RepoItemController($scope, RepoItemService){
		var self = this;
		self.item = {id:null, name:'',expiry:'', purchaseDate:null};
		self.items = [];
		
		self.submit = submit;
		self.edit = edit;
		self.remove = remove;
		self.reset = reset;
		
		fetchAllItems();
		
	    function fetchAllItems(){
	        ItemService.fetchAllItems()
	            .then(
	            function(d) {
	                self.items = d;
	                $log.debug("Fetching items "+self.item);
	            },
	            function(errResponse){
	                $log.error('Error while fetching Items');
	            }
	        );
	    }
	}
})();