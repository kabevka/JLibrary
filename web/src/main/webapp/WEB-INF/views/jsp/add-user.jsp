<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Admin</title>
<link rel="stylesheet" href="resources/css/admin.css" />
</head>
<body>

	<div class="heder">
		<a href="home"><img src="resources/img/logo.jpg" alt="logo"
			class="logo-img"></a> <input type="text" class="input-in-heder">
		<a href="#"><img src="resources/img/search button.jpg" alt="search.jpg"
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
	<div>
		<form:form method="post" action="addUser" modelAttribute="user">
			<p>First Name</p><form:input path="firstName"/>
			<p>Second name</p><form:input path="secondName"/>
			<p>Age</p><form:input path="age"/>
			<p>telephoneNumber</p><form:input path="telephoneNumber"/>
			<p>City</p><form:input path="adress.city"/>
			<p>Street</p><form:input path="adress.street"/>
			<p>Number of house</p><form:input path="adress.numberOfHouse"/>
			<p>Flat</p><form:input path="adress.numberOfFlat"/>
			<input type="submit" value="Add">
		</form:form>
	</div>
</body>
</html>