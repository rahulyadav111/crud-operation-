<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container" mt-3>
		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h3>fill the product Details here.</h3>



				<form action="HandleProduct" method="post">
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							aria-describedby="emailHelp"
							placeholder="Enter your prodduct name ">
					</div>
					
					<div class="form-group">
						<label for="description">Product Description</label> 
							 <textarea 
							 class="form-control rounded-0" 
							 id="exampleFormControlTextarea1" 
							 name="description"rows="5" placeholder="Enter your product description..."></textarea>
					</div>
					
					<div class="form-group">
						<label for="name">Product Price</label> <input type="text"
							class="form-control" id="price" name="price"
							aria-describedby="emailHelp"
							placeholder="Enter your prodduct price ">
					</div>	
								
					<a href="${pageContext.request.contextPath }/"
					 class="btn btn-outline-danger">back</a>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>



			</div>

		</div>


	</div>


</body>
</html>