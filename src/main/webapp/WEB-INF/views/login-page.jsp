<jsp:include page="template/header.jsp"/>

<div class="container">
    <form action="/login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter login" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


</div>


<jsp:include page="template/footer.jsp"/>