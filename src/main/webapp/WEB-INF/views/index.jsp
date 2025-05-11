<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Catalog</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        .button-container { margin-top: 20px; }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Welcome to Product Catalog</h2>
		<div class="button-container">
		<form action="/product/catalog/loadAddProduct" method="get">
		    <button type="submit">Create Product</button>
		</form>
		
		<form action="/product/catalog/loadListProducts" method="get">
			<button type="submit">List all Products</button>
		</form>
		</div>
</body>
</html>
