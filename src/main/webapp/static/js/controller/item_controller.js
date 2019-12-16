(function(){
	'use strict';
	
	angular
		.module('myApp')
		.controller('ItemController',ItemController);
	
	ItemController.inject = ['$scope', 'ItemService','$log'];
	
	function ItemController($scope, ItemService){
		var self = this;
		self.item = {id:null, name:'',shelfLife:'', purchaseDate:null, expiryDate:null, storageState:''};
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
	 
	    function createItem(item){
	        ItemService.createItem(item)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                $log.error('Error while creating Item');
	            }
	        );
	    }
	 
	    function updateItem(item, id){
	        ItemService.updateItem(item, id)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                $log.error('Error while updating Item');
	            }
	        );
	    }
	 
	    function deleteItem(id){
	        ItemService.deleteItem(id)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                $log.error('Error while deleting Item');
	            }
	        );
	    }
	 
	    function submit() {
	        if(self.item.id===null){
	            $log.debug('Saving New Item', self.item);
	            createItem(self.item);
	        }else{
	            updateItem(self.item, self.item.id);
	            $log.debug('Item updated with id ', self.item.id);
	        }
	        reset();
	    }
	 
	    function edit(item){
	        $log.debug('item to be edited', item);
	        self.item = angular.copy(item);
	    }
	 
	    function remove(id){
	        $log.debug('id to be deleted', id);
	        if(self.item.id === id) {//clean form if the item to be deleted is shown there.
	            reset();
	        }
	        deleteItem(id);
	    }
	 
	    function reset(){
	        self.item={id:null,name:'',expiry:'', purchaseDate:null, expiryDate:null, storageDate:''};
	        $scope.asyncForm.$setPristine(); //reset Form
	    }
	}
})();