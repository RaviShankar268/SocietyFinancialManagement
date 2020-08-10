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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Outward</title>
<style>

*{
	box-sizing:border-box;
}

body{
	height:100vh;
	background-image: url("img/pat6.jpg");
}

li{
	text-align:center;
	font-size:1.1rem;
}

li:hover{
	background:#555;
}


/* CLASSES */

.active{
	background:#555;
}

.spacingform{
	margin:10%;
	margin-top:7%;
}

.v1{
	text-transform: uppercase;
	text-align: center;
	font-size:1.2rem;
	border:1px solid black;
	background-color:#800020;
	margin-bottom:16px;
}

.v1:hover{
	box-shadow: 0 1px 5px 1px black;
}

/* ID's' */

#ennaval{
	margin:20px;
}

#okag{
	text-transform:uppercase;
	display:flex;
	justify-content:center;
	padding:5px;
	border:1px solid black;
}

#viewin{
	display:block;
	text-decoration:none;
	color:white;
}

#dk{
	margin-bottom:1rem;
}

#mike{
	background-color:white;
	border: 1px solid black;
}

</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

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
			<li class="navbar-item">
				<a class="nav-link" href="inward.jsp">Inward payment</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item active">
				<a class="nav-link" href="<%=request.getContextPath()%>/AdminPaymentF">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div>
<div class="container-fluid">
	<div class="spacingform" id="yov">
		<div class="v1">
			<a href="ViewOutwardF" id="viewin">VIEW HISTORY</a>
		</div>
	<div id="mike">
		<span id="okag"> outward payment </span>
			<form id="ennaval" action="GoOutward" method="post">
				<div class="form-group">
					<label for="tp">Type</label>
					<input type="text" class="form-control" name="type" id="tp">
				</div>
				<div class="form-group">
					<label for="amt">Amount</label>
					<input type="number" class="form-control" name="amount" id="amt" required>
				</div>
				<div class="form-group">
					<label for="to">To</label>
					<input type="text" class="form-control" name="people" id="to" required>
				</div>
				<div class="form-group">
					<label for="mon">Date</label>
					<input type="date" class="form-control" name="date" id="mon" required>
				</div>
				<div class="form-check">
    				<input type="checkbox" class="form-check-input" id="exampleCheck1" required>
    				<label class="form-check-label" for="exampleCheck1">Check me out</label>
  				</div>
  				<button type="submit" class="btn btn-primary" id="dk">Submit</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>