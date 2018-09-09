<%@ page import="zuryanov.servlets.logic.ValidateService" %>
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
        .table {
            width: 250px;
        }
        #widthform {
            width: 150px;
        }
    </style>
</head>
<body>
<table class="table" >
    <h2>Users list</h2>
    <c:forEach items="${users}" var="user">
        <form method="post" action="${pageContext.servletContext.contextPath}/list">
            <tr class="info">
                <td> <c:out value="${user}"></c:out> </td>
                <td>
                    <div class="btn-group">
                        <c:if test="${(rolesession=='admin') || (login eq user) }">
                        <input name="submit" type='submit' value="edit" class="btn btn-primary"/>
                        <input name="submit" type="submit" value="delete" class="btn btn-primary"/>
                        </c:if>
                    </div>
                </td>
                <input type="hidden" name="user" value="${user}"/>
            </tr>
        </form>
    </c:forEach>
</table>
<div class="form-group" id="widthform">
    <c:if test="${rolesession=='admin'}">
        <form method="post" action="${pageContext.servletContext.contextPath}/list">
            <label for="sel1">Select list:</label>
            <select class="form-control" id="sel1" name="rolechange">
                <option disabled>Выберите роль</option>
                <c:forEach items="${roles}" var="rolechange">
                    <option value="<c:out value="${rolechange}"></c:out>">${rolechange}</option>
                </c:forEach>
            </select>
            <input name="submit" type="submit" value="change role" class="btn btn-primary"/>
        </form>
    </c:if>
</div>
</body>
</html>