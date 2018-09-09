<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var valid = true;
            if (document.getElementById("usr").value == '') {
                alert('Заполните поле логин');
                valid = false;
            }
            if (document.getElementById("pwd").value == '') {
                alert('Заполните поле пароль');
                valid = false;
            }
            if (document.getElementById("desc").value == '') {
                alert('Заполните поле описание');
                valid = false;
            }
            if ( ( document.contact_form.gender[0].checked == false ) && ( document.contact_form.gender[1].checked == false ) )
            {
                alert ( "Пожалуйста, выберите Ваш пол: Мужской или Женский" );
                valid = false;
            }
            return valid;
        }
    </script>
    <style>
        body {
            position: fixed;
            top: 10%;
            left: 50%;
            margin-top: -75px;
            margin-left: -100px;
        }
        form {
            width: 150px;
        }
    </style>
</head>
<body>
<c:if test="${error !=''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    <div class="form-group">
        <label for="usr">Login:</label>
        <input type="text" name="login" class="form-control" id="usr">
        <label for="pwd">Password:</label>
        <input type="password" name="password" class="form-control" id="pwd">

        <label for="sel1">Select role:</label>
        <select name="role" class="form-control" id="sel1">
        <c:forEach items="${roles}" var="role">
            <option value="<c:out value='${role}'></c:out>">${role}</option>
        </c:forEach>
        </select>
        <div class="btn-group">
            <input type="submit" class="btn btn-primary" onclick="return validate();"/>
            <form action="${pageContext.servletContext.contextPath}/signout" method="post">
                <input type="submit" value="exit" class="btn btn-primary">
            </form>
        </div>
    </div>
</form>
</body>
</html>