<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Add Family</title>
<style>

/* CLASS */

body{
	background-image: url("img/pat23.jpg");
}

li{
	text-align:center;
	font-size:1.1rem;
}

li:hover{
	background:#555;
}

.spacingform{
	margin:10%;
	margin-top:7%;
	background-color:white;
}


/* ID */

#ennaval{
	margin:20px;
}

#okag{
	display:flex;
	justify-content:center;
	padding:5px;
	border:1px solid black;	
}

#dk{
	margin-bottom:1rem;
}

</style>
</head>
<body>
<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("name")==null)
	{
		response.sendRedirect("adminLogin.jsp");
	}
%>

 <div class="navbar-header"> 
	<nav class="navbar navbar-dark bg-dark">
		<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#IPO">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="btn btn-primary" href="Logout" role="button">LOGOUT</a>
		<div class="collapse navbar-collapse" id="IPO">
		<ul class="navbar-nav">
			<div class="dropdown-divider"></div>
			<li class="navbar-item active">
				<a class="nav-link" href="manage.jsp">Manage Families</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="inward.jsp">Inward payment</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="adminPayment.jsp">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div>  
<div class="container-fluid">
	<div class="spacingform">
	<span id="okag"> Details </span>
		<form id="ennaval" action="FamilyRegister" method="post">
			<div class="form-group">
				<label for="ApartmentID">Apartment ID</label>
				<input type="text" class="form-control" id="ApartmentID" name="apt_id" required>
			</div>
			<div class="form-group">
				<label for="FirstMan">First Man</label>
				<input type="text" class="form-control" id="FirstMan" name="first_man">
			</div>
			<div class="form-group">
				<label for="FirstWoman">First Woman</label>
				<input type="text" class="form-control" id="FirstWoman" name="first_woman">
			</div>
			<div class="form-group">
				<label for="NumberPeople">Inmates Count</label>
				<input type="number" class="form-control" id="NumberPeople" min="1" max="8" name="no_people" required>
			</div>
			<div class="form-group">
				<label for="DOJ">Date of Housing</label>
				<input type="date" class="form-control" id="DOJ" name="doj" required>
			</div>
			<div class="form-group">
				<label for="EmailID">Email ID</label>
				<input type="email" class="form-control" id="EmailID" name="email_id" required>
			</div>
			<div class="form-group">
				<label for="PhoneNumber">Phone Number</label>
				<input type="number" class="form-control" id="PhoneNumber" min="5656565656" max="9999999999" name="phone" required>
			</div>
			<div class="form-group">
				<label for="Username">Username</label>
				<input type="text" class="form-control" id="Username" name="uname" required>
			</div>
			<div class="form-group">
				<label for="Password">Password</label>
				<input type="password" class="form-control" id="Password" name="pass" required>
			</div>
			<div class="form-check">
    			<input type="checkbox" class="form-check-input" id="exampleCheck1" required>
    			<label class="form-check-label" for="exampleCheck1">Check me out</label>
  			</div>
  				<button type="submit" class="btn btn-primary" id="dk">Submit</button>
		</form>
	</div>
</div>
</body>
</html>