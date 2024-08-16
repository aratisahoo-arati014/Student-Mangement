<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
 <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        
        li {
            float: left;
        }
        
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        li a:hover {
            background-color: #111;
        }
    </style>
</head>
<body>
<ul>
    <li><a href="#home">Home</a></li>
    <li><a href="#news">SMS</a></li>
    <li><a href="#contact">Add</a></li>
    <li><a href="#about">All</a></li>
</ul>

<h2>Student Regisration From </h2>
<form action="save" method="post">

  <label for="fname">First Name</label>
  <input type="text" id="firstname" name="firstname"> 

  <label for="lname" >LastName</label>
  <input type="text" class="lname" id="lastname" name="lastname">

  <label for="email">Email</label>
  <input type="text" id="email" name="email">

  <label for="mobileno">Mobile_no</label>
  <input type="text" id="mobile_no" name="mobile_no">
  
   <label for="gender">Gender:</label><br>
   <input type="radio" id="male" name="gender" value="male">
   <label for="male">Male</label>
   <input type="radio" id="female" name="gender" value="female">
   <label for="female">Female</label><br><br>
 
    <label for="gender">Department:</label><br>
    <input type="radio" id="mca" name="department" value="mca">
    <label for="mca">MCA</label>
    <input type="radio" id="mba" name="depatment" value="mba">
    <label for="mba">MBA</label><br><br>
    
<button type="submit" class="btn btn-primary">save</button> 

</form>
</body>
</html>


