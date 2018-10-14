<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {

        var ctx = "${context}";

        $("#exampleModalCenter").show();

        $("#blogDelete ").click(function () {
            var blogName = $("#blogName").text();
            $.ajax({
                url: ctx + "/blog/remove",
                type: 'GET',
                data: {name: blogName}
            })

            window.location.href = ctx + "/user-profile";
        })

        $("#blogButton").click(function () {
            var blogName = $("#defaultForm-name").val();
            var blogUrl = $("#defaultForm-url").val();

            $.ajax({
                url: ctx + "/blog/add",
                type: 'GET',
                data: {name: blogName, url: blogUrl},
                success: function () {
                }
            })
            window.location.href = ctx + "/user-profile";
        })

    })
</script>


<br/>


<div class="container">

    <div class="row text-center">

        <div class="col">

            <h1 class="text font-weight-normal ml-5">Welcome ${name} <i class="fas fa-user-circle fa-2x"></i>
            </h1>
            <a id="addBlogButton" class="btn del btn-brown btn-rounded mb-4 hoverable" data-toggle="modal"
               data-target="#modalLoginForm">Add
                Blog</a>
        </div>

    </div>


    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">

            <div class="modal-content">

                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Add blog</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <form:form modelAttribute="blog" action="${context}/blog/add" method="post">
                    <div class="modal-body mx-3">
                        <div class="md-form mb-5">
                            <i class="fa fa-edit prefix grey-text"></i>
                            <input type="text" id="defaultForm-name" name="name" class="form-control validate">
                            <label data-error="wrong" data-success="right"  for="defaultForm-name">Blog name</label>
                        </div>

                        <div class="md-form mb-4">
                            <i class="fa fa-rss prefix grey-text"></i>
                            <input type="text" id="defaultForm-url"  name="url" class="form-control validate">
                            <label data-error="wrong" data-success="right" for="defaultForm-url">Blog url</label>
                        </div>

                    </div>
                    <%--<div class="modal-footer d-flex justify-content-center">--%>
                    <%--<button id="blogButton" class="btn btn-brown">Save</button>--%>
                    <%--</div>--%>
                    <div class="text-center">
                        <button type="submit"
                                class="btn  btn-brown ">Save
                        </button>
                    </div>

                </form:form>


            </div>
        </div>
    </div>

    <c:forEach items="${blogs}" var="blog">

        <div class="row">

            <div class="col-11">

                <div class="card hoverable">

                    <div class="card-body">

                        <div class="row">

                            <div class="col-lg-1">
                                <i style="color: #6f42c1" class="fas fa-rss fa-2x"></i>
                            </div>

                            <div class="col-2">
                                <p id="blogName" class="text-center font-weight-bold">${blog.name}</p>
                            </div>

                            <div class="col-8 text-right">
                                <h6 class="text-left font-weight-bold"> ${blog.url}</h6>
                            </div>

                        </div>
                    </div>

                </div>

            </div>

            <div class="col-1 mt-2">
                <div>
                    <button id="blogDelete" type="button-right" class="btn btn-brown">Delete</button>
                </div>
            </div>

        </div>

        <br/>

    </c:forEach>

</div>


<jsp:include page="template/footer.jsp"/>