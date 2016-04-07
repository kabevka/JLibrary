<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>User Statistic</title>
        <link rel="stylesheet" href="resources/css/admin.css" />
        <link rel="stylesheet" href="resources/css/user.css" />
    </head>
    <body>
 
    <div class="heder">
        <a href="home"><img src="resources/img/logo.jpg" alt="logo" class="logo-img"></a>
        <input type="text" class="input-in-heder">
        <a href = "home"><img src="img//search button.jpg" alt="search.jpg"  class="button"></a></div>
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
    
    <div class = "showAvarageAgeByBookName">
       <p>Find the average age of books by title</p>
        <form:form method="post" action="bookTitle" modelAttribute="bookName">
          <p>Enter book name <input name = "bookName"> <input type = submit value = "Submit"></p> 
        </form:form>  
      	<p>Age : ${age}</p>  
    </div>
    <hr>
    <div class = "showTimeOfUsingLibrary">
       <p>Show time of library usingé</p>
        <form:form method="post" action="user" modelAttribute="user" >
            <p>Enter user name <input name = "firstName" /></p>
            <p>Enter second name <input name = "secondName"/>
            <input type = submit value = "Submit"></p>                
        </form:form> 
    </div>
    <div>
    	<p>Time of using = ${timeOfUsing}</p>
    </div>
    <hr>
    <div class = "showStatisticByPeriod">
       <p>ÉShow the number of hits the user over time</p>
        <p>Enter user data:</p>
        <form:form method="post" action="date" modelAttribute="period">
            <p>Enter user name <input name = "firstName"></p>
            <p>Enter surname <input name = "secondName"></p>  
            <p>Start date <input name = "startDate" type="date"></p>
            <p>End date <input name = "endDate" type="date"> <input type = submit value = "Submit"></p>
        </form:form> 
        <p>Count : ${count}</p>
    </div>
    
    </body>
</html>