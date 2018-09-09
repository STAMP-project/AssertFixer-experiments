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
        div {
            width: 150px;
            background-color: gainsboro;
            text-align: center;
            font-size: medium;
        }
    </style>
</head>
<body>
    <div class="panel panel-default">
        <div class="panel-body">Hello ${login}!</div>
    </div>
</body>
</html>
