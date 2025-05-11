<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .form-container {
            width: 300px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
	<script>
			var baseUrl = window.location.origin;
	        function submitForm(){
	            event.preventDefault(); // Prevent default form submission

	            // Gather form data
	            var productName = document.getElementById('productName').value;
	            var price = document.getElementById('price').value;
				var qty = document.getElementById('qty').value;
				var description = document.getElementById('description').value;
				console.log('productName - '+productName+ ' price - '+price+ ' qty - '+qty+' description - '+description);
				console.log('BaseUrl - '+baseUrl);
	            // Send the data to the REST API
	            $.ajax({
	                url: baseUrl+'/product/catalog/api/v1/create/product',  // The REST API endpoint
	                type: 'POST',
	                contentType: 'application/json',
	                data: JSON.stringify({
	                    productName: productName,
	                    price: price,
						qty: qty,
						description: description
	                }),
	                success: function(response) {
						console.log(response);
	                    alert(response);
	                },
	                error: function(xhr, status, error) {
	                    alert('Error: ' + xhr.responseText);
	                }
	            });
	        }
	</script>
</head>
<body>
    <h2>Add Product</h2>
    <div class="form-container">
        <form id="productForm">
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" required>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required>
			
			<label for="qty">Quantity:</label>
			<input type="number" id="qty" name="qty" required>
            
            <label for="description">Description:</label>
            <input type="text" id="description" name="description">
            
            <button type="submit" onclick="submitForm()">Add Product</button>
        </form>
    </div>
</body>
</html>
