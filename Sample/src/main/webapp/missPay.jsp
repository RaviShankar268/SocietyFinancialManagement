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
<title>MISSED</title>
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

.active{
	background:#555;
}

.drive{
margin-top:5px;
}

/* ID's '*/

#hand{
margin-top:10px;
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
			<li class="navbar-item">
				<a class="nav-link" href="manage.jsp">Manage Families</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item active">
				<a class="nav-link" href="#">Inward payment</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="#">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div> 
<div class="container-fluid">
<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />
<sql:query dataSource="${snapshot}" var="result">
select * from temp_db where checked="rejected";
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
<a class="btn btn-danger drive" role="button" href="#">Rejected</a>
<a class="btn btn-primary drive" role="button" href="RetryChecked?a=${row.apt_id}">Retry</a>
</span>
</div>
</div>
</c:forEach>
</div>
</body>
</html>