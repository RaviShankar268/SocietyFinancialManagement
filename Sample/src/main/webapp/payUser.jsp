<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>PAY</title>
</head>
<style>

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

.drive{
	margin-top:5px;
}

/* ID's */

#hand{
	margin-top:10px;
}



</style>
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
			<li class="navbar-item active">
				<a class="nav-link" href="payUser.jsp">Pay</a>
			</li>
			<!-- <div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="#">Payment Request</a>
			</li> -->
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="UserPaymentF">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div>
<div class="container-fluid">
<div>
<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />

<sql:query dataSource="${snapshot}" var="result">
select apt_id from family where username ="${uname}";
</sql:query>

<c:forEach var="row" items="${result.rows}">
<c:set var="id" value="${row.apt_id }"/>
</c:forEach>

<sql:query dataSource="${snapshot}" var="result">
select * from temp_db where apt_id="${id}" and checked="requested";
</sql:query>

<c:forEach var="row" items="${result.rows}">
<div class="card" id="hand">
<div class="card-body">
APT ID : <c:out value="${row.apt_id}"/><br>
MONTH : <c:out value="${row.month}"/><br>
YEAR : <c:out value="${row.year}"/><br>
MONTHLY MAINTENANCE : <c:out value="${row.monthlymain}"/><br>
SEASONAL CHARGE : <c:out value="${row.seasoncharge}"/><br>
ADDITIONAL CHARGE : <c:out value="${row.addcharge}"/><br>
LATE FEES : <c:out value="${row.latefee}"/><br>
TOTAL : <c:out value="${row.total}"/><br>
<span>
<a class="btn btn-primary drive" role="button" href="ChangeChecked?c=accepted&a=${row.total}&id=${row.apt_id}">Accept</a>
<a class="btn btn-danger drive" role="button" href="ChangeChecked?c=rejected&id=${row.apt_id}">Reject</a>
</span>
</div>
</div>
</c:forEach>
</div>
</div>
</body>
</html>