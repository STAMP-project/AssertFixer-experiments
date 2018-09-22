<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
>

<head>
    <title>Sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">
</head>

<body>
<div class="container">


    <div role="alert">
        <form:errors path="*" cssClass="alert alert-danger"/>

        <div th:if="${param.error}" class="alert alert-danger">
            Invalid username and password.
        </div>

    </div>


    <form:form method="POST"
               action="/login" modelAttribute="user">


        <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
        <label for="email" class="sr-only">Email</label>

        <form:input path="email" class="form-control" placeholder="Email" required="required" autofocus="autofocus"/>

        <label for="password" class="sr-only">Password</label>

        <form:password path="password" class="form-control" placeholder="Password" required="required"
                       autofocus="autofocus"/>


        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" name="remember-me"/> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div class="margin-top20 text-center"> Don't have an account?
            <a href="/signup">Create an account</a>
        </div>
    </form:form>

</div>
</body>
</html>