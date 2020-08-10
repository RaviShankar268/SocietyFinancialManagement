<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>    
<html>    
<head>    
    <title>Log-in Page</title>    
    <style>
    	body  
{  
    margin: 0;  
    padding: 0;  
    background-color: yellow;  
    font-family: 'Arial';  
}  
.login{  
		text-align: center;
        width: 600px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px; 
        border-radius: 1px ;  
          
}  
h2{  
    text-align: center;  
    color: red;  
    padding: 20px;  
    font-size: 50px;  
}  
label{  
    color: blue;  
    font-size: 25px;  
}  
#Uname{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
}  
#Pass{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
      
}  
#log{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 17px;  
    padding-left: 7px;  
    color: black;  
  font-size: 15px;  
  
}  
span{  
    color: blue;  
    font-size: 17px;  
}  
a{  
    float: right;  
    background-color:white;  
}
    </style>

</head>    
<body>    
    <h2>Log-in Form</h2><br>    
    <div class="login">    
    <form action="check" method="post">    
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" name="name" id="Uname">    
        <br><br>    
        <label><b>Password     
        </b>    
        </label>    
        <input type="Password" name="pass" id="Pass">    
        <br><br>    
        <input type="submit" name="log" id="log" value="LogIn"> 
        <br><br>       
    </form>     
</div>    
</body>    
</html>  