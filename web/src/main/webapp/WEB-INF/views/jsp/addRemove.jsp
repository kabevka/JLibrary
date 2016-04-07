<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Admin</title>
	<link rel="stylesheet" href="resources/css/admin.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

	<div class="heder">
	<img src="${pageContext.request.contextPath}/img/logo.jpg"  alt="logo" class="logo-img" />
		<input type="text" class="input-in-heder"> 
			<input type="submit" value="Шукати" class="button">
	</div>	
	<nav>
		<ul>
		<li><a href="main">Головна</a></li>
		<li><a href="instance">Пошук</a></li>
		<li><a href="#">Читачі</a></li>
		<li><a href="#">Боржники</a></li>
		<li><a href="#">Статистика</a>
			<ul>
				<li><a href="#">Книги</a></li>
				<li><a href="#">Користувачі</a></li>
			</ul></li>
	</ul>
	</nav>
	<div class="add-write-out">
		<div class="add">
			<p class="mini-heder">ADD BOOK</p>
			<div class="pole-add">
			<form action="addBook" method="post">
				<p>Name of book</p>
				<input type="text" name="name" class="input-add">
				<p>Authors first name</p>
				<input type="text" name="authorName" class="input-add">
				<p>Authors last name</p>
				<input type="text" name="authorSurname" class="input-add">
				<p>Amount of pages</p>
				<input type="text" name="amountOfPage" class="input-add">
				<p>Publication</p>
				<input type="text" name="publicationName" class="input-add">
				<p>Year of publication</p>
				<input type="text" name="year" class="input-add">
				<p>Description</p>
				<input type="text" name="description" class="input-add">
				
				<p class="italic">Перш ніж добавити книжку перевірте валідність
					введених даних</p>
				<p class="italic">* - позначенні поля необов'язкові до
					заповнення</p>

			</div>
			<input type="submit" value="ADD" class="input-bottom">
			</form>
		</div>
		<div class="write-out">
			<p class="mini-heder">Списати книгу</p>
			<form action="removeBook" method="post">
			<div class="pole-add">
				<p>ID</p>
				<input type="text" name="Id" class="input-add">
				<p>Назва</p>
				<input type="text" class="input-add">
				<p>Автор*</p>
				<input type="text" class="input-add">
				<p>Причина</p>
				<input type="text" class="input-add">
				<p>Ініціали бібліотекаря</p>
				<input type="text" class="input-add">
				<p class="italic">Перш ніж спичати книжку перевірте валідність
					введених даних</p>
				<p class="italic">* - позначенні поля необов'язкові до
					заповнення</p>
			</div>
			<input type="submit" value="Списати" class="input-write-out-bottom">
			</form>
		</div>
		
	</div>

</body>
</html>