<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search</title>
<link rel="stylesheet" href="resources/css/admin.css" />
</head>
<body>
	<div class="heder">
		<a href="home"><img src="resources/img/logo.jpg" alt="logo" class="logo-img"></a>
	</div>
	<nav>
		<ul>
			<li><a href="#">Catalog</a></li>
			<li><a href="user">Readers</a></li>
			<li><a href="deptors">Deptors</a></li>
			<li><a href="#">Statistics</a>
				<ul>
					<li><a href="#">Books</a></li>
					<li><a href="user-statistic">Reader</a></li>
				</ul></li>
			<li><a href="#">Log out</a></li>
		</ul>
	</nav>

	<div id="search-block">
		<input type="text" class="input-in-heder22"> <select name="Search" class="input-in-heder2">
			
			<option value="Title">Name</option>
			<option value="Author" selected>Authors</option>			
			<option value="Year">Year</option>
			<option value="Publisher" selected>Publisher</option>
		</select> <a href="#"><img src="resources/img/search button.jpg" alt="search.jpg" class="input-in-heder3"></a>		
	</div>
</body>
</html>