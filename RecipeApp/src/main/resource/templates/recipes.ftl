<html>

<head>
    <title>CS461 Senior Project: Recipe App</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>    
    <script src="/js/recipe-control.js"></script>
</head>

<body>    
    
    <div>
        Welcome to the Recipe App!
        <ul>
        	<li>This is a tool to organize recipes and search via their ingredients</li>
        </ul>
    </div>

    <hr>

    <div>
        <div>
            <label>Recipe List</label>
            <table border="1">            
                <tr>
                    <td>Title</td>
                    <td>Directions</td> 
                    <td>Ingredients</td>
                </tr>
                <#list recipes as recipe>
                        <tr>
                            <td>${recipe.title}</td>
                            <td>${recipe.directions}</td>
                            <td>${recipe.ingredients}</td>
                        </tr>
                </#list>
            </table>
        </div>
        
        <hr>
        
        <div>
            <label>Add Recipe</label>
            <table border="1">
                <tr>
                    <td>Title</td>
                    <td>Directions</td> 
                    <td>Ingredients</td>                     
                    <td>Add</td>
                </tr>                
                <tr>
                    <td><input type="text" id="input_title"></td>
                    <td><input type="text" id="input_directions"></td>
                    <td><input type="text" id="input_ingredients"></td>                    
                    <td><button onclick="addRecipe()">Add</button></td>
                </tr>
            </table>
        </div>

        <hr>

        <div>
            <label>Query Recipe</label>
            <input type="text" id="query_id"><button onclick="getRecipe()">Get</button>
            <table border="1">
                <tr>
                    <td>Title</td>
                    <td>Directions</td>
                    <td>Ingredients</td>
                </tr>
                <tr>
                    <td><label id="result_title"></td>
                    <td><label id="result_directions"></td>
                    <td><label id="result_ingredients"></td>
                </tr>
            </table>
        </div>
    </div>
    
    
</body>

</html>