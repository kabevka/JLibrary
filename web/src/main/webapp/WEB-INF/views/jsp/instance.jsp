<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Instance</title>
<link rel="stylesheet" href="resources/css/admin.css" />
</head>
<body>
	<div class="heder">
		<img src="img/logo.jpg" alt="logo" class="logo-img">


	</div>
	<nav>
		<ul>
			<li><a href="main">Головна</a></li>
			<li><a href="#">Пошук</a></li>
			<li><a href="#">Читачі</a></li>
				<li><a href="#">Статистика</a>
			<ul>
				<li><a href="#">Книги</a></li>
				<li><a href="#">Користувачі</a></li>
			</ul></li>
			<li><a href="addRemove">ADD/REM</a></li>
		</ul>
	</nav>


	<div class="<!-- add-write-out -->">
		<div class="<!-- add -->">
			<p class="mini-heder">Пошук книги</p>
			<form action="allInstance" method="post">
			<div class="<!-- pole-add -->">
				<p>Назва</p>
				<input type="text" name="name" class="input-add">
				<p>Автор</p>
				<input type="text" class="input-add">
				<p>Жанр</p>
				<input type="text" class="input-add">
				<p>Співавтори</p>
				<input type="text" class="input-add">
				<p>Видавництво</p>
				<input type="text" class="input-add">
				<p>Рік видання</p>
				<input type="text" class="input-add">
			</div>
			<input type="submit" value="allInstance" class="input-bottom2">
			</form>
		</div>
		<div class="write-out">
			<p class="mini-heder">Екземпляри</p>
			<div class="<!-- pole-add -->">
				<div class="proba">
            	<c:forEach items="${allInstance}" var="item">

					<p>Реєстраційний номер книги: ${item.id}</p>
   					<p>Назва книжки: ${item.book.name}</p>
   					<p>Автор: ${item.book.author.name}  ${item.book.author.surname}</p>
   					<p>Чи доступна вона:<c:if test="${item.isAvailable}">Так</c:if> <c:if test="${!item.isAvailable}">Ні</c:if></p>			   
   					<p>Кількість сторінок в книжці: ${item.book.amountOfPage}</p>
   					<p>Рік видання: ${item.book.year}</p><br>
   					<p>     </p>
				</c:forEach>
				</div>
			</div>
		</div>


	</div>

</body>
</html>