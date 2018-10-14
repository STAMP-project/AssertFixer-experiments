<jsp:include page="template/header.jsp"/>


<div class="container">
    <div class="row">
        <div class="col-md">

        </div>
        <div class="col-md-8">

            <form class="form-horizontal registrationForm" action="${context}/register" method="post" >

                <div class="alert alert-info">
                    Register.
                </div>

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" value="${user.name}" />

                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" value="${user.email}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" value="" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password again:</label>
                    <div class="col-sm-10">
                        <input type="password" name="password_again" id="password_again" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <input type="submit" value="Save" class="btn btn-lg btn-primary" />
                    </div>
                </div>
            </form>

        </div>
        <div class="col-md">


        </div>
    </div>
</div>



<jsp:include page="template/footer.jsp"/>