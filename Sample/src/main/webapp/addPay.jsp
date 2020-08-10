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
<title>Add Pay</title>
<style>

*{
	box-sizing:border-box;
}

body{
	height:100vh;
	background-image: url("img/newimg1.webp");
}

li{
	text-align:center;
	font-size:1.1rem;
}

li:hover{
	background:#555;
}

/* CLASSES */

.row{
	padding:16px;
}

.active{
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
<script>

function sum(){
	  var val1 = document.getElementById('monthlymain').value;
	  var val2 = document.getElementById('seasonalcharge').value;
	  var val3 = document.getElementById('additionalcharge').value;
	  var sum = Number(val1) + Number(val2) + Number(val3);
	  document.getElementById('totalcharge').value = sum;
	}

</script>

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
			<li class="navbar-item">
				<a class="nav-link" href="manage.jsp">Manage Families</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item active">
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
		<span id="okag"> ADD </span>
		<form id="ennaval" action="AddPayment" method="post">
			<div class="form-group">
				<label for="monthdate"> MONTH </label>
				<input type="month" class="form-control" name="month" id="monthdate" required>
			</div>
			<div class="form-group">
				<label for="monthlymain"> MONTHLY MAINTENANCE </label>
				<input type="number" class="form-control" name="monthlymain" id="monthlymain" required>
			</div>
			<div class="form-group">
				<label for="seasonalcharge"> SEASONAL CHARGES </label>
				<input type="number" class="form-control" name="seasoncharge" id="seasonalcharge" required>
			</div>
			<div class="form-group">
				<label for="additionalcharge"> ADDITIONAL CHARGES </label>
				<input type="number" class="form-control" name="addcharge" id="additionalcharge" required>
			</div>
			<div class="form-group">
				<label for="totalcharge"> TOTAL </label>
				<input  class="form-control" name="total" id="totalcharge" value="" readonly>
			</div>
			<div class="form-check">
				<input type="checkbox" onclick="sum()" class="form-check-input" id="exampleCheck1" required>
				<label class="form-check-label" for="exampleCheck1">Check me out</label>
			</div>
			<button type="submit" class="btn btn-primary" id="dk">Submit</button>
		</form>
	</div>
</div>
</body>
</html>