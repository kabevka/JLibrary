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
    
    <div class = "showAvarageAgeByBookName">
       <p>Знайти середній вік за назвою книги</p>
        <form>
          <p>Введіть назву книжки <input name = "bookName"> <input type = submit value = "Знайти"></p> 
        </form> 
    </div>
    <hr>
    <div class = "showTimeOfUsingLibrary">
       <p>Показати час користування бібліотекою</p>
        <form>
            <p>Введіть імя користувача      <input name = "FirstNameUser"></p>
            <p>Введіть прізвище користувача <input name = "SecondNameUser"> <input type = submit value = "Знайти"></p>  
               
        </form> 
    </div>
    <hr>
    <div class = "showStatisticByPeriod">
       <p>Показати кількість звернень користувача за певний період часу</p>
        <p>Введіть дані користувача:</p>
        <form>
            <p>Введіть імя користувача      <input name = "FirstNameUser"></p>
            <p>Введіть прізвище користувача <input name = "SecondNameUser"></p>  
            <p>Початкова дата <input name = "startDate" type="date"></p>
            <p>Кінцева дата <input name = "endDate" type="date"> <input type = submit value = "Знайти"></p>
        </form> 
    </div>
    
    </body>
</html>