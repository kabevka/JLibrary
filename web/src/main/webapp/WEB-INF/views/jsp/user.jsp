<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin</title>
        <link rel="stylesheet" href="resources/css/admin.css"/>
        <link rel="stylesheet" href="resorces/css/user.css"/>
    </head>
    <body>
 
    <div class="heder">
       <a href="home"><img src="resources/img/logo.jpg" alt="logo" class="logo-img"></a>
        <input type="text" class="input-in-heder">
        <a href = "#"><img src="img//search button.jpg" alt="search.jpg"  class="button"></a></div>
    </div>
        <nav>
		<ul>
			<li><a href="#">Catalog</a></li>
			<li><a href="user">Readersñ</a></li>
			<li><a href="deptors">Deptors</a></li>
			<li><a href="#">Statistics</a>
				<ul>
					<li><a href="#">Books</a></li>
					<li><a href="user-statistic">Reader</a></li>
				</ul></li>
			<li><a href="#">Log out</a></li>
		</ul>
	</nav>
    
    <div>
      <a href = "adser">Add new User</a>
        <table border="2">
            <tr><th>id</th><th>First Nameè</th><th>Second Name</th><th>Age</th><th>Telephone number</th><th>Date of registrationó</th><th>Adress</th></tr>
            <tr>
            	<c:forEach items = "${users}" var="users">
            		<td><c:out value="${users.id}"/></td>
             		<td><c:out value="${users.firstName}"/></td>  
             		<td><c:out value ="${users.secondName}"/></td> 
             		<td><c:out value="${users.age}"/></td>
             		<td><c:out value="${users.telephoneNumber}"/></td>   
             		<td><c:out value="${users.dateOfRegistration}"/></td>   
             		<td><c:out value="${users.adress}"></c:out></td>
             </tr>
            </c:forEach>
        </table>
    </div>
    
    </body>
</html>