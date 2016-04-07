<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<form:form method="POST" action="giveBookForUser">
		<p>User</p>
		<select name="userValue">
			<c:forEach items="${allUsers}" var="user">
				<option value="${user.id}">${user.firstName}</option>
			</c:forEach>
		</select>
		<p>Book</p>
		<select name="bookValue">
			<c:forEach items="${allBooks}" var="instance">
				<option value="${instance.id}">${instance.book}</option>
			</c:forEach>
		<input type="submit" value="Add book">
	</form:form>
</body>
</html>