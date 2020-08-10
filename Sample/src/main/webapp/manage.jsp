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
<title>Manage Families</title>
<style>

/* START OF MANAGE JSP */

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

.card-body{
padding:15px;
}

.s1, .s2, .s3, .s4{
	border: 1px solid black;
	text-transform: uppercase;
	text-align: center;
	font-size:1.2rem;
	background-color:#800020;
}

.s3{
	margin-bottom:15px;
}

.s1:hover, .s2:hover, .s3:hover, .s4:hover{
	box-shadow: 0 1px 5px 1px black;
}

/* ID */

#add, #remove, #view, #edit{
	display:block;
	text-decoration:none;
	color:white;
}

#userDetails{
	
}

#details{
	width:18rem;
	margin:auto;
}

/* MEDIA QUERIES */

@media(max-width:575px)
{
.s2, .s4{
	margin-top:16px;
}	
}

/* END OF MANAGE JSP */

</style>
</head>
<body>
<!--<c:import url="welcome.jsp"></c:import> -->
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
				<a class="nav-link" href="<%=request.getContextPath()%>/AdminPaymentF">Payment history</a>
			</li>
		</ul>
	</div>
	</nav>
</div>  
<div class="container-fluid">
<div class="row">
	<div class="col-sm-4 s1"><a  href="addFamily.jsp" id="add">Add</a></div>
	<div class="col sm-4 s4"><a href="editFamily.jsp" id="edit">Edit</a></div>
	<div class="col-sm-4 s2"><a  href="removeFamily.jsp" id="remove">Remove</a></div>
</div>
	<div class="s3"><a data-toggle="collapse" href="#userDetails" id="view" aria-expanded="false" aria-controls="userDetails">View</a></div>
<div>
<div class="collapse" id="userDetails">

<sql:setDataSource var="snapshot" driver = "com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false" user="kavin" password="admin@123" />

<sql:query dataSource="${snapshot}" var="result">
select * from family
</sql:query>
<div class="row">
<c:forEach var="row" items="${result.rows}">
<div class="card col-xl-3" id="details">
<div class="card-body">
APT ID : <c:out value="${row.apt_id}"/> <br>
FIRST MAN : <c:out value="${row.first_man}"/><br>
FIRST WOMAN : <c:out value="${row.first_woman}"/><br>
PERSONS : <c:out value="${row.no_people}"/><br>
DOJ : <c:out value="${row.dateofjoin}"/><br>
PHONE : <c:out value="${row.phone_num}"/><br>
MAIL ID : <br><c:out value="${row.mail_id}"/><br>
USERNAME : <c:out value="${row.username}"/>
</div>
</div>
</c:forEach>
</div>
</div>
</div>	
</div>
</body>
</html>