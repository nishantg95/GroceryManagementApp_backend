(function(){
	'use strict';
	
	angular
		.module('myApp')
		.controller('ItemController',ItemController);
	
	ItemController.inject = ['$scope', 'ItemService'];
	
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
	                console.log("Fetching items "+self.item);
	            },
	            function(errResponse){
	                console.error('Error while fetching Items');
	            }
	        );
	    }
	 
	    function createItem(item){
	        ItemService.createItem(item)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                console.error('Error while creating Item');
	            }
	        );
	    }
	 
	    function updateItem(item, id){
	        ItemService.updateItem(item, id)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                console.error('Error while updating Item');
	            }
	        );
	    }
	 
	    function deleteItem(id){
	        ItemService.deleteItem(id)
	            .then(
	            fetchAllItems,
	            function(errResponse){
	                console.error('Error while deleting Item');
	            }
	        );
	    }
	 
	    function submit() {
	        if(self.item.id===null){
	            console.log('Saving New Item', self.item);
	            createItem(self.item);
	        }else{
	            updateItem(self.item, self.item.id);
	            console.log('Item updated with id ', self.item.id);
	        }
	        reset();
	    }
	 
	    function edit(item){
	        console.log('item to be edited', item);
	        self.item = angular.copy(item);
	    }
	 
	    function remove(id){
	        console.log('id to be deleted', id);
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