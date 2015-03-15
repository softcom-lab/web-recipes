
function healthCheck() {
	$.ajax(
			{
				type : "GET",
				url  : "/cs461/ping",
				data : {
				},
				success : function(result) {
					$('#status').text(result);
				},
				error: function (jqXHR, exception) {
					$('#status').text("Failed to get the status");
				}
			});
}

function addRecipe() {
    
	var name = $('#input_title').val();
	var instrc = $('#input_directions').val();
	var ingr = $('#input_ingredients').val();

	if (name) {
		$.ajax(
				{
					type : "POST",
					url  : "/cs461/recipe/" + name,
					data : {
						"instrc" : instrc,
						"ingr" : ingr
					},
					success : function(result) {
						location.reload();
					},
					error: function (jqXHR, exception) {
						alert("Failed to add the recipe. Please check the inputs.");
					}
				});
	} else {
		alert("Invalid title");
	}
}

function getRecipe(ingredient) {
	var ingredient = $('#query_ingredient').val();
	if (ingredient) {
		$.ajax(
				{
					type : "GET",
					url  : "/cs480/recipe/" + ingredient,
					data : {
					},
					success : function(result) {
						$('#result_title').text(result.title);
						$('#result_directions').text(result.directions);
						$('#result_ingredients').text(result.ingredients);
					},
					error: function (jqXHR, exception) {
						alert("Failed to get the recipe.");
					}
				});
	} else {
		alert("Invalid search");
	}
}