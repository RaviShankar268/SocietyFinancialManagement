<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
	<div class="flexbox-container c1">
		<div class="flexbox-item i1">
			<a role="button" class="btn btn-primary" href="adminLogin.jsp">Admin</a>
		</div>
	</div>		
</header>
<div class="container">
	<div class="yup">
		<div class="card check">
			<div class="card-header chead">
				<h5 class="card-title nope">
					User Login
				</h5>
			</div>
			<div class="card-body">
				<form action="UserLogin" method="post">
					<div class="form-group row">
						<label for="theusername" class="col-lg-3 col-form-label">Username</label>
						<div class="col-lg-9">
						<input type="text" class="form-control" id="theusername" name="username">
					</div>
					</div>
					<div class="form-group row">
						<label for="thepassword" class="col-lg-3 col-form-label">Password</label>
						<div class="col-lg-9">
						<input type="password" class="form-control" id="thepassword" name="password">
					</div>
					</div>
					<div class="dip">
						<a class="bull" id="about" href="forgetPassword.jsp">forget password?</a>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>