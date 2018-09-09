<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            position: fixed;
            top: 10%;
            left: 50%;
            margin-top: -75px;
            margin-left: -100px;
        }
        form {
            width: 200px;
        }
        div {
            margin-top: 10px;
        }
        input {
            margin-bottom: 15px;
        }
    </style>
    <script>
        function validate() {
            var valid = true;
            if (document.getElementById("login").value == '') {
                alert('Заполните поле login');
                valid = false;
            }
            if (document.getElementById("psw").value == '') {
                alert('Заполните поле password');
                valid = false;
            }
            if (document.getElementById("repsw").value == '') {
                alert('Заполните поле password');
                valid = false;
            }
            if (document.getElementById("countr").value == '') {
                alert('Заполните поле country');
                valid = false;
            }
            if (document.getElementById("city").value == '') {
                alert('Заполните поле city');
                valid = false;
            }
            if (document.getElementById("frst").value == '') {
                alert('Заполните поле first name');
                valid = false;
            }
            if (document.getElementById("last").value == '') {
                alert('Заполните поле last name');
                valid = false;
            }
            var age = document.getElementById("age").value;
            if ((age == '') || (age < 0) || (age > 150)) {
                alert('Заполните поле age корректно');
                valid = false;
            }
            if ( document.getElementById("psw").value != document.getElementById("repsw").value )
            {
                alert ( "Вы ввели разные пароли" );
                valid = false;
            }
            return valid;
        }
    </script>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/create">
    <div class="form-group">
        <label for="login">Login:</label>
        <input type="text" name="login" class="form-control" id="login"/>

        <label for="psw">Password:</label>
        <input type="password" name="password" class="form-control" id="psw"/>

        <label for="repsw">Re enter password:</label>
        <input type="password" name="repassword" class="form-control" id="repsw"/>

        <label for="state">Address:</label>(country)
        <input type="text" name="state" id="state" list="state_list" class="form-control">
        <datalist id="state_list">
            <c:forEach items="${countries}" var="countryvar">
                <option value="<c:out value='${countryvar}'/>">${countryvar}</option>
            </c:forEach>
        </datalist>(city)

        <input type="text" name="city" id="city" list="city_list" class="form-control">
        <datalist id="city_list">
            <c:forEach items="${cities}" var="cityvar">
                <option value="<c:out value='${cityvar}'/>">${cityvar}</option>
            </c:forEach>
        </datalist>
        <label for="frst">First name:</label>
        <input type="text" name="frstname" class="form-control" id="frst"/>

        <label for="last">Last name:</label>
        <input type="text" name="lstname" class="form-control" id="last"/>

        <label for="age">Age:</label>
        <input type="number" name="age" class="form-control" id="age"/>

        <label for="genre">Favorite genre of music:</label>
        <select name="genrename" class="form-control" id="genre">
            <c:forEach items="${musictypes}" var="genrevar">
                <option value="<c:out value='${genrevar}'/>">${genrevar}</option>
            </c:forEach>
        </select>
        <input type="submit" value="create login" class="btn btn-primary" onclick="validate()"/>
    </div>
</form>
</body>
</html>
