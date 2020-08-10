<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
button {
  width: 130px;
  height: 40px;
  background: blue;
  border: none;
  border-radius: 5px;
  position: relative;
  border-bottom: 4px solid #2b8bc6;
  color: white;
  font-weight: 600;
  font-family: 'Open Sans', sans-serif;
  text-shadow: 1px 1px 1px rgba(0,0,0,.4);
  font-size: 15px;
  text-align: left;
  text-indent: 5px;
  box-shadow: 0px 3px 0px 0px rgba(0,0,0,.2);
  cursor: pointer;
  
  display: block;
  margin: 0 auto;
  margin-bottom: 20px;
}
button:active {
  box-shadow: 0px 2px 0px 0px rgba(0,0,0,.2);
  top: 1px;
}

button:after {
  content: "";
  width: 0;
  height: 0;
  display: block;
  border-top: 20px solid #187dbc;
  border-bottom: 20px solid #187dbc;
  border-left: 16px solid transparent;
  border-right: 20px solid #187dbc;
  position: absolute;
  opacity: 0.6; 
  right: 0;
  top: 0;
  border-radius: 0 5px 5px 0;  
}


.holder {
  width: 400px;
  background: lightblue;
  padding: 30px 10px;
  box-sizing: border-box;
  margin: 0 auto;
  margin-top: 20px; 
  text-align: center; 

} 

body {
 background-image: url("https://www.colourbox.com/preview/5586537-business-society-people-icon-web-vector-diagram-social-network-partnership-employee-communication-seamless-background.jpg");
 background-size: cover;
 background-attachment: fixed;
}

</style>
</head>
<body>
	<!--  
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP1.1
		
		response.setHeader("Pragma", "no-cache"); // HTTP1.0
		
		response.setHeader("Expires", "0"); // proxiservers
		
		if(session.getAttribute("username")==null)
			response.sendRedirect("index.jsp");
	%>-->
	
	<%-- this is user log in buddy welcome ${username} and Door No : ${Dno} --%>
	<div class="holder">
	
	
	<form action="user_info">
	<input type="hidden" name="D_no" value="${Dno}">
	<button type="submit" class="button">User Info</button>
	</form>
  
	<form action="pay">
	<input type="hidden" name="D_no" value="${Dno}">
	<button type="submit" class="button">Bill Payment</button>
	</form>
	
	<form action="pay_history">
	<input type="hidden" name="D_no" value="${Dno}">
	<button type="submit" class="button">Payment History</button>
	</form>
	
	<form action="logout"> 
	<button type="submit" class="button">Log Out</button>
	</form>
	
	</div>
	
</body>
</html>