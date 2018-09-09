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
            width: 150px;
        }
        div {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<c:if test="${error !=''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/" method="post">
    <div class="form-group">
        <label for="usr">Login:</label>
        <input type="text" name="login" class="form-control" id="usr">
        <label for="pwd">Password:</label>
        <input type="password" name="password" class="form-control" id="pwd">

        <div class="btn-group">
            <input type="submit"  value="login" class="btn btn-primary">
            <form action="${pageContext.servletContext.contextPath}/create" method="get">
                <input type="submit" name="submit" value="registration" class="btn btn-primary">
            </form>
        </div>
    </div>
</form>
</body>
</html>
