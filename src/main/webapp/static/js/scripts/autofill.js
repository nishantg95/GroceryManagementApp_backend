//https://www.roytuts.com/spring-boot-mvc-autocomplete/
$(function() {
	$("#name").autocomplete({
		minLength : 1,
		messages: {
	        noResults: 'no results',
	        results: function(amount) {
	            return amount + 'results.'
	        }
		},
		source : function(request, response) {
			$.ajax({
				url : "/GroceryManagementApp/repo/listAllRepoItems",
				data : {
					term : request.term
				},
				dataType : "json",
				type : "GET",
				success : function(data) {
					response($.map(data, function(obj,key) {
						var rName = obj.rName.toUpperCase();
						
						if (rName.indexOf(request.term.toUpperCase()) != -1) {				
							return {
								label : obj.rName,
								value : obj.rName,
								fridgeDate: obj.rFridgeDate, 
								description : obj.rPantryDate,
								id : obj.rId
							}
						} else {
							return null;
						}
					}));
				}

			});
		},
		focus: function(event, ui) {
			$( "#name" ).val( ui.item.label);
	        return false
		},
		select: function(event, ui) {
//            event.preventDefault();
			$('#name').val(ui.item.label);
    		var myInput = $("#shelf_life");
    		myInput.val(ui.item.fridgeDate);
    		myInput.trigger('input');
    		myInput.trigger('change');

			return false;
		}
	})/*.autocomplete( "instance" )._renderItem = function( ul, item ) {
	      return $( "<li>" )
	        .append( "<div class= \"item_result\">" + item.label + "<br>" + item.fridgeDate + "</div>" )
	        .appendTo( ul );
	};*/
});







