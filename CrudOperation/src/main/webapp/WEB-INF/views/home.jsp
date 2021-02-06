<html>
<head>
<%@ include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>


<body>


	<div class="continer mt-3">

		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mt-3">welcome to product.</h1>


				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Product-Id</th>
							<th scope="col">Product-Name</th>
							<th scope="col">Product-Description</th>
							<th scope="col">Product-price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${product }" var="p">
						<tr>
							<th scope="row">${p.id }</th>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td>&#x20B9;${p.price }</td>
						<td><a href="delete/${p.id } "> <i class="fas fa-trash text-danger" style="font-size=30px;"></i></a></td>
						<td><a href="update/${p.id }"> <i class="fas fa-pen-nib text-primary" style="font-size=30px;"></i></a></td>
						
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
				<a href="addProduct"  class="btn btn-outline-success">Add Product </a>
				</div>
			
			</div>

		</div>

	</div>

</body>
</html>
