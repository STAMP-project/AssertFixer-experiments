<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>
        <layout:block name="titlePage">
            Page Title
        </layout:block>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='../../css/style.css'/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <layout:block name="styleLinks">

    </layout:block>
</head>
<body>
<header>
    <layout:block name="header">
        <a href='<c:url value="/"/>'>
            <img src="" alt="icon-EABlog"/>
            <h1>MUM News - EA Blog</h1>
        </a>
    </layout:block>
</header>

<div id="container">
    <layout:block name="content">

    </layout:block>
</div>

<footer>
    <layout:block name="footer">
        <pre>
        Copyright &copy;
        <br/>
        Theodros Mebratu
        <br/>
        Francisco Mosquera
        <br/>
        Edwin Alejandro Cobos Fonseca
        <br/>
        Maharishi University of Management
        <br/>
        Jai Guru Dev
        </pre>
    </layout:block>
</footer>
</body>
</html>