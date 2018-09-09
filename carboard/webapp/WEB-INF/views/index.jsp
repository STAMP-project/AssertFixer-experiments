<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>

    </div>
</c:if>

<c:if test="${empty login}">
<form action="${pageContext.servletContext.contextPath}/" method="post">
    <div class="form-group">
        <label for="usr">Login:</label>
        <input type="text" name="login" class="form-control" id="usr">
        <label for="pwd">Password:</label>
        <input type="password" name="password" class="form-control" id="pwd">

        <div class="btn-group">
            <input  name="submit" type="submit" value="Enter" class="btn btn-primary" onclick="return validate();"/>
        </div>
    </div>
</form>
</c:if>

<c:if test="${!empty login}">
    Welcome ${login}<br>
</c:if>

<div class="btn-group">
    <form action="${pageContext.servletContext.contextPath}/" method="post">
        <input type="submit" value="add new" class="btn btn-primary">
    </form>
</div>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>text</th>
            <th>author</th>
            <th>carbody</th>
            <th>transmission</th>
            <th>engine</th>
            <th>brand</th>
            <th>photo</th>
            <th>sell</th>
            <th>price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${advs}" var="adv">
            <tr>
                <td> <c:out value="${adv.text}"></c:out></td>
                <td> <c:out value="${adv.login.name}"></c:out> </td>
                <td> <c:out value="${adv.carBody.name}"></c:out> </td>
                <td> <c:out value="${adv.transmission.name}"></c:out> </td>
                <td> <c:out value="${adv.engine.name}"></c:out> </td>
                <td> <c:out value="${adv.brand.name}"></c:out> </td>
                <td> <img src="${pageContext.request.contextPath}${adv.photo.image}" width="100px" height="140px" /> </td>
                <td>
                    <c:choose>
                    <c:when test="${(!empty login)&&(adv.login.name.equals(login))}">
                        <form action="${pageContext.servletContext.contextPath}/" method="post">
                            <c:out value="${adv.sell}"></c:out>
                        <input type="hidden" name="idAdv" value="${adv.id}">
                        <input type="submit" name="submit" value="change" class="btn btn-primary">
                        </form>
                    </c:when>
                    <c:otherwise >
                        <c:out value="${adv.sell}"></c:out>
                    </c:otherwise>
                    </c:choose>

                  </td>
                <td> <c:out value="${adv.price}"></c:out> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
