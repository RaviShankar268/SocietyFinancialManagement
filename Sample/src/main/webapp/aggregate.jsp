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
<title>Aggregate</title>
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

.row{
	padding:16px;
}

.table{
	margin-bottom:0;
}

.active{
	background:#555;
}

.ico{
	margin-top:16px;
	display:flex;
	justify-content:flex-end;
}

.pp{
	background-color:white;
}

.pk{
	margin-right:10px;
}

.op{
	text-align:center;
}

.id{
	font-weight:bold;
}

/* ID's */

#pay{
	margin-top:16px;
	background-color:white;
	padding:2px;
	overflow-x:auto
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
<c:set var="sql1" value="select * from monthtoyear order by year"></c:set>
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
		<a class="btn btn-default btn-lg pp" target="_blank" href="AggregateReport?sql=${sql1}" role="button">
			<span class="fa fa-download" aria-hidden="true"></span></a>
	</div>
	<div id="pay">
		<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />
			<c:catch var="sqlexception">
				<sql:query dataSource="${snapshot}" var="result">
					${sql1}
				</sql:query>
			</c:catch>
			<table class="table table-bordered table-hover">
				<thead class="thead-light">
					<tr>
						<th scope="col" class="op">MONTH</th>
						<th scope="col" class="op">YEAR</th>
						<th scope="col" class="op">AMOUNT</th>
					</tr>
				</thead>
			<c:forEach var="row" items="${result.rows}">
				<tbody>
					<tr>
						<td class="op id"><c:out value="${row.month}"/></td>
						<td class="op"><c:out value="${row.year}"></c:out></td>
						<td class="op"><c:out value="${row.amount}"/></td>
					</tr>
				</tbody>
			</c:forEach>
			</table> 
	</div>
</div>
</body>
</html>