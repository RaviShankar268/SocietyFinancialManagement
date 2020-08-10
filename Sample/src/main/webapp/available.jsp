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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!--  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<title>Available</title>
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

tr{
	padding-top:5px;
	padding-bottom:5px;
}

/* CLASSES */

.table{
	margin-bottom:0;
}

.active{
	background:#555;
}

.op{
	text-align:center;
}

.pp{
	background-color:white;
}

.ico{
	margin:16px;
	display:flex;
	justify-content:flex-end;
}

.pp{
	background-color:white;
}

.pk{
	margin-right:10px;
}

.avail{
	margin-top:16px;
	background-color:white;
	padding:2px;
	overflow-x:auto
}

.id{
	font-weight:bold;
}

/* ID's' */


</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("name")==null)
	{
		response.sendRedirect("adminLogin.jsp");
	}
	else if(session.getAttribute("sql3")==null)
	{
		response.sendRedirect("AllPaymentF");
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
	<div class="ico">
		<div class="dropdown pk">
  			<button class="btn btn-secondary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   				Sort
  			</button>
  			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    			<a class="dropdown-item" href="AllPayment">Amount</a>
    			<a class="dropdown-item" data-toggle="collapse" href="#example" aria-expanded="false" aria-controls="example">Date</a>
  			</div>
		</div>
		<a class="btn btn-default btn-lg pp" target="_blank" href="AllPaymentReport?sql=${sql3}" role="button">
			<span class="fa fa-download" aria-hidden="true"></span></a>
	</div>
	<div class="collapse" id="example">
		<div class="card">
			<div class="card-body">
				<form action="AllPayment1" method="post">
					<div class="form-group">
						<label for="sdate">From date</label>
						<input type="date" class="form-control" name="date1" id="sdate">
					</div>
					<div class="form-group">
						<label for="edate">To date</label>
						<input type="date" class="form-control" name="date2" id="edate">
					</div>
					<div>
						<button class="btn btn-primary"type="submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="avail">
		<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />
		<c:catch var="exception">
			<sql:query dataSource="${snapshot}" var="result">
				${sql3}
			</sql:query>
		</c:catch>
		<table class="table table-bordered table-hover">
			<tr>
			<thead class="thead-light">
				<th scope="col" class="op">Name</th>
				<th scope="col" class="op">Date</th>
				<th scope="col" class="op">Time</th>
				<th scope="col" class="op">Amount</th>
				</tr>
			</thead>
		<c:forEach var="row" items="${result.rows}">
			<tbody>
			<tr>
				<td class="op"><c:out value="${row.apt_id}"></c:out></td>
				<td class="op"><c:out value="${row.date}"></c:out></td>
				<td class="op"><c:out value="${row.time}"></c:out></td>
				<td class="op"><c:out value="${row.amount}"></c:out></td>
			<c:choose>
				<c:when test="${row.apt_id=='admin' }">
				<c:set var="total" value="${total-row.amount}"/>
				</c:when>
			<c:otherwise>
				<c:set var="total" value="${total + row.amount}"/>
			</c:otherwise>
			</c:choose>
			</tr>
			</tbody>
		</c:forEach>
			<tr class="table-info">
				<td class="op">Available</td>
			<c:forEach var="j" begin="1" end="2">
				<td class="op"></td>
			</c:forEach>
				<td class="op"><c:out value="${total}"></c:out></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>