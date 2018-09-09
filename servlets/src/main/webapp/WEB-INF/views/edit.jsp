<%@ page import="zuryanov.servlets.logic.ValidateService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var valid = true;
            if (document.getElementByName("login").value == '') {
                alert('Заполните поле логин');
                valid = false;
            }
            return valid;
        }

        function updateUser() {
            var country = $('select[name="counrtyname"]').val();
            var city = $('select[name="cityname"]').val();
            $.ajax('./change', {
                method: 'GET',
                data : {name : document.getElementById("lbllogin").value,
                        countryname : country,
                        cityname : city
                }
            })
            return false;
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
<form method="post" action="${pageContext.servletContext.contextPath}/edit?id=${id}">
    <div class="form-group">
        <label for="lbllogin">Name:</label>
        <input type="text" class="form-control" name="login" value="${user}" id="lbllogin"/>

        <label for="lblcountry">Country:</label>
        <select name="countryname" class="form-control" id="lblcountry">
            <c:forEach items="${countriesupdate}" var="countryvar">
                <c:if test="${countryvar eq countryattr}">
                    <option selected value="<c:out value='${countryvar}'/>">${countryvar}</option>
                </c:if>
                <c:if test="${countryvar != countryattr}">
                    <option  value="<c:out value='${countryvar}'/>">${countryvar}</option>
                </c:if>
            </c:forEach>
        </select>

        <label for="lblcity">City:</label>
        <select name="cityname" class="form-control" id="lblcity" onchange="updateUser()">
            <c:forEach items="${citiesupdate}" var="cityvar">
                <c:if test="${cityvar eq cityattr}">
                    <option selected value="<c:out value='${cityvar}'/>">${cityvar}</option>
                </c:if>
                <c:if test="${cityvar != cityattr}">
                    <option value="<c:out value='${cityvar}'/>">${cityvar}</option>
                </c:if>
            </c:forEach>
        </select>
        <input type="submit" class="btn btn-primary" value="Edit" onclick="return validate();"/>
    </div>
</form>
</body>
</html>
</body>
</html>
