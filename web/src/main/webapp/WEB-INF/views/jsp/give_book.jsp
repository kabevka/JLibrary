<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
<link rel="stylesheet" href="resources/css/admin.css" />
<link rel="stylesheet" href="resorces/css/user.css" />
</head>
<body>

	<div class="heder">
		<a href="home"><img src="resources/img/logo.jpg" alt="logo"
			class="logo-img"></a> <input type="text" class="input-in-heder">
		<a href="#"><img src="img//search button.jpg" alt="search.jpg"
			class="button"></a>
	</div>
	</div>
	<nav>
	<ul>
		<li><a href="#">Catalog</a></li>
		<li><a href="user">Readers–</a></li>
		<li><a href="deptors">Deptors</a></li>
		<li><a href="#">Statistics</a>
			<ul>
				<li><a href="#">Books</a></li>
				<li><a href="user-statistic">Reader</a></li>
			</ul></li>
		<li><a href="#">Log out</a></li>
	</ul>
	</nav>
<body>
	<form:form method="POST" commandname="users" action="user">  
<table>  
    <tbody><tr>  
    <td>  
        <ul>  
            <form:select path="user" items="${users}">  
        </form:select></ul>  
    </td>  
    </tr>  
    <tr>  
        <td>  
            <input type="submit" value="Submit">  
        </td>  
    </tr>  
</tbody></table>    
</form:form>  
</body>
</html>