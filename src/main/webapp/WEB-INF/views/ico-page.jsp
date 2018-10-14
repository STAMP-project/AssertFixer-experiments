<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="template/header.jsp"/>


<style>
    .card {
        height: 13rem;
        width: 8rem;
    }

    .card-columns {
        column-count: 4;
    }

    strong {

        font-weight: bold;
    }

    .navbar-light .navbar-nav .nav-link {
        color: red;
    }


</style>


<script>

    $(document).ready(function () {
        $(".team").click(function () {
            var url = $(this).find("a").attr('href');
            window.open(url);
        })
    })
</script>

<br/>
<div class="container bg-white ">
    <br/>

    <div class="row">

        <div class="col-md">

        </div>

        <div class="col-md-10">

            <div class="row">

                <div class="col-md">
                    <img width="120rem" height="120rem" class="img" src="${ico.logolink}"
                         alt="error"/>
                </div>
                <div class="col-md-10">
                    <h5 class="title font-weight-bold">${ico.name} (${ico.data.getCategories("name")})</h5>
                    <p class="text font-weight-normal">${ico.data.intro}</p>
                </div>
                <br/>

            </div>
            <br/>
            <hr/>
            <div class="row">

                <div class="col-md-7">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="${ico.data.getLink("youtube")}"
                                allowfullscreen></iframe>
                    </div>
                </div>

                <div class="col-md ml-5">

                    <div class="card border-white text-center" style="width: 18rem;">

                        <ul class="list-group list-group-flush">

                            <li class="list-group-item ">

                                <fmt:parseDate value="${ico.icoStart}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsIcoStart"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy " value="${parsIcoStart}" var="icoStart"/>


                                <fmt:parseDate value="${ico.icoEnd}" pattern="yyyy-MM-dd'T'HH:mm" var="parsIcoEnd"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy " value="${parsIcoEnd}" var="icoEnd"/>


                                <fmt:parseDate value="${ico.preIcoStart}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsPreIcoStart"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy " value="${parsPreIcoStart}"
                                                var="preIcoStart"/>


                                <fmt:parseDate value="${ico.preIcoEnd}" pattern="yyyy-MM-dd'T'HH:mm"
                                               var="parsPreIcoEnd"
                                               type="both"/>
                                <fmt:formatDate pattern="dd.MM.yyyy " value="${parsPreIcoEnd}"
                                                var="preIcoEnd"/>

                                <h6 class="text-left font-weight-normal">Token status : <span
                                        class="font-weight-bold"> ${ico.status()}</span></h6>

                                <h6 class="text-left font-weight-normal"> Pre sale : <strong> ${preIcoStart}</strong>
                                </h6>
                                <h6 class="text-left font-weight-normal"> End pre sale : <strong>${preIcoEnd}</strong>
                                </h6>
                                <h6 class="text-left font-weight-normal"> Start sale : <strong>${icoStart}</strong></h6>
                                <h6 class="text-left font-weight-normal"> End sale : <strong
                                        class="text-center">${icoEnd}</strong></h6>
                            </li>

                            <li class="list-group-item">
                                <button value="${ico.data.getLink("whitepaper")}" type="button"
                                        class="btn btn-brown btn-sm">White list
                                </button>
                            </li>

                            <li class="list-group-item">
                                <button value="${ico.data.getLink("www")}" type="button"
                                        class="btn btn-brown btn-sm">White site
                                </button>
                            </li>

                            <li class="list-group-item  ">

                                <a href="${ico.data.getLink("twitter")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-twitter fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("slack")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-slack fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("facebook")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-facebook fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("youtube")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-youtube fa-lg "></i>
                                </a>
                                <a href="${ico.data.getLink("telegram")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-telegram fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("github")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-github fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("reddit")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-reddit fa-lg"></i>
                                </a>
                                <a href="${ico.data.getLink("medium")}" class="icon-block">
                                    <i style="color: #795548" class="fab fa-medium fa-lg"></i>
                                </a>

                            </li>

                        </ul>
                    </div>
                </div>
            </div>
            <br/>
            <h3 class="font-weight-bold">Finance</h3>

            <hr/>

            <div class="row">

                <div class="col info">
                    <p class="font-weight-normal">Token : <strong> ${ico.data.getFinance("token") } </strong></p>
                    <p class="font-weight-normal">Price :<strong> ${ico.data.getFinance("price")}</strong></p>
                    <p class="font-weight-normal">Tokens:<strong> ${ico.data.getFinance("tokens")}</strong></p>
                    <p class="font-weight-normal">Hard cap :<strong> ${ico.data.getFinance("hardcap")}</strong></p>
                    <p class="font-weight-normal">Soft cap :<strong> ${ico.data.getFinance("softcap")}</strong></p>
                    <p class="font-weight-normal">raised: <strong> ${ico.data.getFinance("raised")}</strong></p>
                </div>

                <div class="col info">
                    <p class="font-weight-normal">Platform: <strong>${ico.data.getFinance("platform")} </strong></p>
                    <p class="font-weight-normal">Accepting: <strong> ${ico.data.getFinance("accepting")} </strong></p>
                    <p class="font-weight-normal">Token type: <strong> ${ico.data.getFinance("tokentype")}</strong></p>
                </div>
            </div>
            <br/>
            <h3 class="font-weight-bold">Teams</h3>

            <hr/>
            <div class="row text-center">
                <c:forEach items="${ico.data.getCrew()}" var="team">
                    <!-- Grid column -->
                    <div class="team col-lg-3 col-md-6 mb-lg-0 mb-5 hoverable ">
                        <div class="avatar mx-auto">
                            <img style="margin-top: 1rem" src="${team.photo}"
                                 class="rounded-circle z-depth-1" alt="Sample avatar">
                        </div>
                        <br/>
                        <p class="font-weight-bold">${team.name}</p>
                        <p class="text brown-text">${team.title} <a href="${team.links}"
                                                                    class="icon-linkedin">
                            <i style="color: #795548" class="fab fa-linkedin fa-lg"></i>
                        </a></p>
                        <!-- Grid column -->
                    </div>
                </c:forEach>
            </div>

            </section>

        </div>

    </div>

    <div class="col-md">

    </div>

</div>

<br/>

</div>
<br/>
<br/>
</div>

<jsp:include page="template/footer.jsp"/>