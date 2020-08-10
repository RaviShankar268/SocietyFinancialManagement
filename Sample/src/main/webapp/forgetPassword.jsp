<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Change Password</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>

body{
	height:100vh;
	background-image: url("img/dub5.jpg");
}

/* CLASSES */

.check{ 
	border:none;
	margin:15%;	
}

.chead{
	background: grey;
}

.yup{
	padding-left: 20%;
	padding-right: 20%;
}

.nope{
	text-align: center;
}

.c1{
	display: flex;
	background: grey;
	justify-content: flex-end;
}

.i1{
	margin:10px;
}


/* MEDIA QUERIES */

@media(max-width: 991px)
{
	.yup{
		padding:0;
	}

}
@media(min-width: 992px) and (max-width: 1200px)
{
	.yup{
		padding-left:15%;
		padding-right: 15%;
	}

}

</style>
</head>
<body>
<header>
	<div class="flexbox-container c1">
		<div class="flexbox-item i1">
			<a role="button" class="btn btn-primary" href="userLogin.jsp">Back</a>
		</div>
	</div>		
</header>
<div class="container">
	<div class="yup">
		<div class="card check">
			<div class="card-header chead">
				<h5 class="card-title nope">
					Check
				</h5>
			</div>
			<div>
			${username}
			</div>
			<div class="card-body">
				<form action="CheckCredentials" method="post">
					<div class="form-group row">
						<label for="theusername" class="col-xl-3 col-form-label">Username</label>
						<div class="col-xl-9">
						<input type="text" class="form-control" id="theusername" name="username" required>
					</div>
					</div>
					<div class="form-group row">
						<label for="thepassword" class="col-xl-3 col-form-label">Date of Join</label>
						<div class="col-xl-9">
						<input type="date" class="form-control" id="thepassword" name="doj" required>
					</div>
					</div>
					<div class="form-group form-check">
    					<input type="checkbox" class="form-check-input" id="exampleCheck1" required>
    					<label class="form-check-label" for="exampleCheck1">Check me out</label>
  					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>