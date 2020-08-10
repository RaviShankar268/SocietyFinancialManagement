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
<title>Inward Payment</title>
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

.p1, .p2, .p3{
	border: 1px solid black;
	text-transform: uppercase;
	text-align: center;
	font-size:1.2rem;
	background-color:#800020;
}

.p3{
	margin-bottom:15px;
}

.p1:hover, .p2:hover, .p3:hover{
	box-shadow: 0 1px 5px 1px black;
}


/* ID's' */

#addin, #miss, #status{
	display:block;
	text-decoration:none;
	color:white;
}

/* MEDIA QUERIES */

@media(max-width:575px)
{
.p2{
	margin-top:16px;
}	
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
				<a class="nav-link" href="inward.jsp">Inward payment</a>
			</li>
			<div class="dropdown-divider"></div>
			<li class="navbar-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/AdminPaymentF">Payment history</a>
			</li>
		</ul>
		</div>
	</nav>
</div> 
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6 p1"><a href="addPay.jsp" id="addin">ADD</a></div>
		<div class="col-sm-6 p2"><a href="missPay.jsp" id="miss">MISSED</a></div>
	</div>
	<div class="p3" id="status">
		<a data-toggle="collapse" href="#userStatus" id="status" aria-expanded="false" aria-controls="userStatus">STATUS</a>
	</div>
<div>
	<div class="collapse" id="userStatus">
	<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />
	<sql:query dataSource="${snapshot}" var="result">
		select * from temp_db;
	</sql:query>
<c:forEach var="row" items="${result.rows}">
<div class="card" id="before_temp">
<div class="card-body" id="temp">
APT ID : <c:out value="${row.apt_id}"/><br>
MONTHLY MAINTENANCE : <c:out value="${row.monthlymain}"></c:out><br>
SEASONAL CHARGE : <c:out value="${row.seasoncharge}"/><br>
ADDITIONAL CHARGE : <c:out value="${row.addcharge}"/><br>
LATE FEE : <c:out value="${row.latefee}"/><br>
TOTAL : <c:out value="${row.total}"/><br>
PAID STATUS : <c:out value="${row.pay_status}"/><br>
DATE PAID : <c:out value="${row.date_paid}"></c:out><br>
<span>
<c:choose>
<c:when test="${row.checked=='accepted'}">
<button class="btn btn-success"><c:out value="${row.checked}"></c:out></button>
</c:when>
<c:when test="${row.checked=='requested' }">
<button class="btn btn-primary"><c:out value="${row.checked}"></c:out></button>
</c:when>
</c:choose>
</span>
</div>
</div>
</c:forEach>

</div>
</div>

</div>
</body>
</html>