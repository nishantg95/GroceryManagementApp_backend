//https://www.roytuts.com/spring-boot-mvc-autocomplete/
$(function() {
	$("#project").autocomplete({
		minLength : 3,
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
			$( "#project" ).val( ui.item.label );
	        return false
		},
		select: function(event, ui) {
//            event.preventDefault();
			$('#project').val(ui.item.label);
			$('#project-description').html(ui.item.fridgeDate)
			return false;
		}
	}).autocomplete( "instance" )._renderItem = function( ul, item ) {
	      return $( "<li>" )
	        .append( "<div>" + item.label + "<br>" + item.fridgeDate + "</div>" )
	        .appendTo( ul );
	};
});







