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
        }
        table {
            text-align: center;
        }
        table#user {
            position: fixed;
            top: 100px;
            left: 10px;
            width: 500px;
        }
        table#role {
            position: fixed;
            top: 100px;
            left: 510px;
            width: 100px;
        }
        table#address {
            position: fixed;
            top: 100px;
            left: 610px;
            width: 150px;
        }
        table#genre {
            position: fixed;
            top: 100px;
            left: 760px;
            width: 120px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Users list</h2>
    <table class="table table-condensed" id="user">
        <thead>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>First name</th>
            <th>last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="table table-condensed" id="role">
        <thead>
        <tr>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <table class="table table-condensed" id="address">
        <thead>
        <tr>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${addresses}" var="address">
            <tr>
                <td>${address.country} : ${address.city}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="table table-condensed" id="genre">
        <thead>
        <tr>
            <th>Music genre</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${genres}" var="genre">
            <tr>
                <td>${genre.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
