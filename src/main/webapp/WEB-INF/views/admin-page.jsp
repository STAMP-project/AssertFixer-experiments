<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {


    })

</script>


<br/>
<div class="alert alert-primary" role="alert">
    <p>${error}</p>

</div>

<div class="container">

    <%--<c:if test="${error != null}" >--%>
        <div class="alert alert-primary" role="alert">
           <p>${test}</p>

        </div>
    <%--</c:if>--%>

    <div class="row">

        <div class="col">

            <c:forEach items="${users}" var="user">

                <div class="row">

                    <div class="col">

                        <div class="card hoverable">

                            <div class="card-body">

                                <div class="row">

                                    <div class="col">
                                        <i style="color: #6f42c1" class="fas fa-user fa-2x"></i>
                                    </div>

                                    <div class="col">
                                        <p id="userId" class="text-center font-weight-bold">${user.id}</p>
                                    </div>

                                    <div class="col">
                                        <p id="userName" class="text-center font-weight-bold">${user.name}</p>
                                    </div>
                                    <div class="col">
                                        <p id="userEmail" class="text-center font-weight-bold">${user.email}</p>
                                    </div>

                                    <div class="col">
                                        <p id="userRoles" class="text-center font-weight-bold">${user.roles}</p>
                                    </div>

                                    <div class="col">
                                        <p id="userBlogs" class="text-center font-weight-bold">Blogs : ${user.blogs.size()}</p>
                                    </div>



                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="col-1 mt-2">
                        <div>
                            <button id="userDelete" type="button-right"  class="btn btn-brown">Delete</button>
                        </div>
                    </div>


                </div>

                <br/>


            </c:forEach>

            <br/>

        </div>

    </div>


</div>


<jsp:include page="template/footer.jsp"/>