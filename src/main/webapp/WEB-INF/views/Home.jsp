<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMS-Home</title>
<style>
.nav {
  list-style-type: none; 
  padding: 0; 
}

.nav-link {
  text-decoration: none; 
  color: #333;
  padding: 5px 10px; 
  border-radius: 5px; 
  transition: background-color 0.3s ease; 
}
.nav-link.active,
.nav-link:hover {
  background-color: #007bff; 
  color: #fff;
}
</style>
</head>
<body>
<h1>Student Management System</h1>
<nav class="nav">
  <a class="nav-link active" aria-current="page" href="#">Home</a>&nbsp;
  <a class="nav-link" href="#">SMS</a>&nbsp;
  <a class="nav-link" href="add">Add</a>
</nav>
</body>
</html>