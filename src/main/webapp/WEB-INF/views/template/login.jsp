<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script>

    // jQuery.validator.setDefaults({
    //     debug: true,
    //     success: "valid"
    // });
    // $("#registerForm").validate({
    //     debug: true,
    //     rules: {
    //         password: "required",
    //         password_again: {
    //             equalTo: "#password"
    //         }
    //     }
    //
    // });


</script>


<script>

    $(document).ready(function () {
        $('#identicalForm').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },

            fields: {
                password: {
                    validators: {
                        identical: {
                            field: 'confirmPassword',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        identical: {
                            field: 'password',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                }
            }
        });
    });
</script>

<!--Modal: Login / Register Form-->
<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs tabs-2  brown darken-2" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#panel7" role="tab"><i
                                class="fa fa-user mr-1"></i> Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#panel8" role="tab"><i
                                class="fa fa-user-plus mr-1"></i> Register</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body mb-1">

                            <form id="loginForm" action="${context}/login" method="post">

                                <div class="md-form form-sm mb-5">
                                    <i class="fa fa-envelope prefix"></i>
                                    <input name="username" type="text" id="modalLRInput10"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput10">Your
                                        login</label>
                                </div>


                                <div class="md-form form-sm mb-4">
                                    <i class="fa fa-lock prefix"></i>
                                    <input name="password" type="password" id="modalLRInput11"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput11">Your
                                        password</label>
                                </div>


                                <div class="text-center mt-2">
                                    <button type="submit"
                                            class="btn  btn-brown">Log in </button>
                                </div>
                                <!--Footer-->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-brown waves-effect ml-auto"
                                            data-dismiss="modal">Close
                                    </button>
                                </div>

                            </form>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <form:form modelAttribute="user" action="${context}/register" method="post">
                            <!--Body-->
                            <div class="modal-body">

                                <div class="md-form form-sm mb-5">
                                    <i class="fa fa-user prefix"></i>
                                    <input name="name" type="text" id="modalLRInput16"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput12">Your
                                        name</label>
                                </div>
                                <div class="md-form form-sm mb-5">
                                    <i class="fa fa-envelope prefix"></i>
                                    <input name="email" type="email" id="modalLRInput12"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput12">Your
                                        email</label>
                                </div>

                                <div class="md-form form-sm mb-5">
                                    <i class="fa fa-lock prefix"></i>
                                    <input name="password" type="password" id="modalLRInput13"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput13">Your
                                        password</label>
                                </div>

                                <div class="md-form form-sm mb-4">
                                    <i class="fa fa-lock prefix"></i>
                                    <input name="repeatpassword" type="password" id="modalLRInput14"
                                           class="form-control form-control-sm validate">
                                    <label data-error="wrong" data-success="right" for="modalLRInput14">Repeat
                                        password</label>
                                </div>

                                <div class="text-center form-sm mt-2">
                                    <%--<input type="submit" class="btn btn-brown">Sign up <i--%>
                                        <%--class="fa fa-sign-in ml-1"></i>--%>
                                    <%--</input>--%>

                                        <button type="submit"
                                                class="btn  btn-brown">Sign in </button>

                                </div>

                            </div>
                        </form:form>

                        <!--Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-brown waves-effect ml-auto"
                                    data-dismiss="modal">Close
                            </button>
                        </div>

                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>

</div>



