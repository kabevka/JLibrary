<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin</title>
        <link rel="stylesheet" href="admin.css"/>
        <link rel="stylesheet" href="user.css"/>
    </head>
    <body>
 
    <div class="heder">
        <img src="img/logo.jpg" alt="logo" class="logo-img" >
        <input type="text" class="input-in-heder">
        <a href = "first.html"><img src="img//search button.jpg" alt="search.jpg"  class="button"></a></div>
    </div>
        <nav>
            <ul>
                <li><a href="#">Пошук</a></li>
                <li><a href="#">Читачі</a></li>
                <li><a href="#">Боржники</a></li>
                <li><a href="#">Статистика</a>
                    <ul>
                        <li><a href="#">Книги</a></li>
                        <li><a href="#">Користувачі</a></li>
                    </ul>
                </li>
                <li><a href="#">Log out</a></li>
            </ul>
        </nav>
    
    <div>
        <table border="2">
            <tr><th>№</th><th>Ім'я</th><th>Прізвище</th><th>Вік</th><th>Номер телефону</th><th>Дата реєстрації</th></tr>
            <tr><td></td>   <td></td>   <td></td>   <td></td>   <td></td>   <td></td></tr>
        </table>
    </div>
    
    </body>
</html>