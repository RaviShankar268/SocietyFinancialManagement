<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="userstyles.css">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("uname")==null)
	{
		response.sendRedirect("userLogin.jsp");
	}

%>
<div class="navbar-header">
	<nav class="navbar navbar-dark bg-dark">
		<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#IPO">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="btn btn-primary" href="LogoutUser" role="button">LOGOUT</a>
		<div class="collapse navbar-collapse" id="IPO">
		<ul class="navbar-nav">
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="payUser.jsp">Pay</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="UserPaymentF">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div>
<div id="nope">
welcome ${uname}
</div>
</body>
</html>