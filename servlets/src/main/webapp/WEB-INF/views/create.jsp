<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            width: 150px;
            position: fixed;
            top: 10%;
            left: 50%;
            margin-top: -75px;
            margin-left: -100px;
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/create">
    <div class="form-group">
        <label for="usr">Name:</label>
        <input type="text" name="login" class="form-control" id="usr"/>

        <label for="lblcountry">Country:</label>
        <select name="countryname" class="form-control" id="lblcountry">
            <c:forEach items="${countries}" var="countryvar">
                <option value="<c:out value='${countryvar}'/>">${countryvar}</option>
            </c:forEach>
        </select>

        <label for="lblcity">City:</label>
        <select name="cityname" class="form-control" id="lblcity">
            <c:forEach items="${cities}" var="cityvar">
                <option value="<c:out value='${cityvar}'/>">${cityvar}</option>
            </c:forEach>
        </select>

        <input type="submit" class="btn btn-primary"/>
    </div>
</form>
</body>
</html>
</body>
</html>
