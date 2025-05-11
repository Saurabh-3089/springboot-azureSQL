<!DOCTYPE html>
<html>
<head>
    <title>List Products</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
    <script>
		var baseUrl = window.location.origin;
		var url = baseUrl+'/product/catalog/api/v1/products';
        function loadProducts() {
			console.log('Url - '+url);
            fetch(url)
                .then(response => response.json())
                .then(data => {
					console.log('data - '+data);
					const tableBody = document.getElementById('productTableBody');
					data.forEach(product => {
						 console.log('Product - '+product);
						 console.log('Pid - '+product.pid);
						 console.log('Product name - '+product.productName);
					     const row = document.createElement('tr');

						 const pidCell = document.createElement('td');
						 pidCell.textContent = product.pid;
						 row.appendChild(pidCell);
												 
					     const nameCell = document.createElement('td');
				         nameCell.textContent = product.productName;
					     row.appendChild(nameCell);

					     const priceCell = document.createElement('td');
					     priceCell.textContent = product.price;
					     row.appendChild(priceCell);
						 
						 const qtyCell = document.createElement('td');
						 qtyCell.textContent = product.qty;
						 row.appendChild(qtyCell);

					     const descriptionCell = document.createElement('td');
					     descriptionCell.textContent = product.description;
					     row.appendChild(descriptionCell);

					     tableBody.appendChild(row);
					});
                })
                .catch(error => console.error('Error fetching products:', error));
        }
        window.onload = loadProducts;
    </script>
</head>
<body>
    <h2>Product List</h2>
    <table>
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Price</th>
			<th>Quantity</th>
            <th>Description</th>
        </tr>
        <tbody id="productTableBody"></tbody>
    </table>
</body>
</html>
