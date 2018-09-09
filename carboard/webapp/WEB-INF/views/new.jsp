<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <form method="post" action="${pageContext.servletContext.contextPath}/upload" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="text">Text:</label>
            <textarea class="form-control" rows="3" id="text" name="textname"></textarea>


            <label for="price">Price:</label>
            <input class="form-control" type="text" name="pricename" id="price"/>

            <label for="brand">Brand:</label>
            <select name="brandname" class="form-control" id="brand">
                <c:forEach items="${branditems}" var="brandvar">
                    <option value="<c:out value='${brandvar.name}'/>">${brandvar.name}</option>
                </c:forEach>
            </select>

            <label for="carbody">Carbody:</label>
            <select name="carbodyname" class="form-control" id="carbody">
                <c:forEach items="${carbodyitems}" var="carbodyvar">
                    <option value="<c:out value='${carbodyvar.name}'/>">${carbodyvar.name}</option>
                </c:forEach>
            </select>

            <label for="transmission">Transmission:</label>
            <select name="transmissionname" class="form-control" id="transmission">
                <c:forEach items="${transmissionitems}" var="transmissionvar">
                    <option value="<c:out value='${transmissionvar.name}'/>">${transmissionvar.name}</option>
                </c:forEach>
            </select>

            <label for="engine">Engine:</label>
            <select name="enginename" class="form-control" id="engine">
                <c:forEach items="${engineitems}" var="enginevar">
                    <option value="<c:out value='${enginevar.name}'/>">${enginevar.name}</option>
                </c:forEach>
            </select>

            <%--<input type="file" name="file" class="btn btn-primary"/>--%>


            <%--<div class="form-group">--%>
                <%--<label class="col-sm-2 control-label">Photo</label>--%>
                <%--<div class="col-sm-10">--%>
                    <%--<div class="fileinput fileinput-new" data-provides="fileinput">--%>
                        <%--<div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">--%>
                            <%--<img src="<c:url value="/resources/car-icon.png"/>" alt="...">--%>
                        <%--</div>--%>
                        <%--<div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>--%>
                        <%--<div>--%>
                            <%--<span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span>
                            <input type="file" name="photo"></span>--%>
                            <%--<a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<hr class="hr-my">--%>
            <%--<div class="form-group">--%>
                <%--<div class="col-sm-offset-2 col-sm-10 text-right">--%>
                    <%--<button type="submit" class="btn btn-success btn-my">Add</button>--%>
                <%--</div>--%>
            <%--</div>--%>



    <%--<label for="photo">Photo:</label>--%>
    <%--<form action="${pageContext.servletContext.contextPath}/upload" method="post" id="photo" enctype="multipart/form-data" >--%>
    <%--</form>--%>
            <input type="file" name="photo">
        <input type="submit" value="add advertisement" class="btn btn-primary" onclick="validate()"/>
        </div>
    </form>
</div>
</body>
</html>
