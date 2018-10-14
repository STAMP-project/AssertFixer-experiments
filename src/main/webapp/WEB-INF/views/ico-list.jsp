<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>

<script>

    $(document).ready(function () {


        $("#buttonActive").click(function () {
            window.location.href = "${context}/ico-list/active";
        })

        $("#buttonUpcoming").click(function () {
            window.location.href = "${context}/ico-list/upcoming";
        })

        $("#buttonFinished").click(function () {
            window.location.href = "${context}/ico-list/finished";
        })

    })

</script>

<div class="container bg-white">

    <div class="row">

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold">ACTIVE</h3>
            <c:forEach items="${activeIco}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">
                                    <c:choose>
                                        <c:when test="${ico.rating < 4}">
                                            <small class="font-weight-bold" style="color: #bd2130">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4 && ico.rating < 4.5}">
                                            <small class="font-weight-bold" style="color: orange">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4.5}">
                                            <small class="font-weight-bold" style="color: green">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                    </c:choose>
                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>${ Math.abs(ico.todayMinusIcoEnd())}d left</small>
                                </p>
                            </div>
                        </div>
                        <p class="href" hidden>${context}/ico-page/${ico.name}</p>
                    </div>
                </div>
                <!--/.Panel-->
                <br/>

            </c:forEach>


            <button id="buttonActive" style="width: 22rem" type="button" class="btn btn-brown btn-lg btn-block">GO
                MORE ACTIVE ICO
            </button>


        </div>

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold">UPCOMING</h3>
            <c:forEach items="${upcoming}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable ">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">
                                    <c:choose>

                                        <c:when test="${ico.rating < 4}">
                                            <small class="font-weight-bold" style="color: #bd2130">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4 && ico.rating < 4.5}">
                                            <small class="font-weight-bold" style="color: orange">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4.5}">
                                            <small class="font-weight-bold" style="color: green">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                    </c:choose>
                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>Starts ${ Math.abs(ico.todayMinusIcoStart())}d</small>
                                </p>
                            </div>
                            <p hidden>${ico.website_link}</p>
                            <p class="href" hidden>${context}/ico-page/${ico.name}</p>
                        </div>
                    </div>
                </div>
                <!--/.Panel-->
                <br/>
            </c:forEach>


            <button id="buttonUpcoming" style=" width: 22rem" type="button" class="btn btn-brown btn-lg btn-block">
                GO MORE UPCOMING ICO
            </button>


        </div>

        <div class="col-md-4">
            <br/>
            <h3 class="text-center font-weight-bold brown-darken-2 ">ENDED</h3>
            <c:forEach items="${finished}" var="ico">
                <!--Panel-->
                <div style="width: 22rem; height: 10rem" class="card hoverable">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <br/>
                                <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                                <br/>
                                <br/>
                                <p class="text-left">
                                    <c:choose>
                                        <c:when test="${ico.rating < 4}">
                                            <small class="font-weight-bold" style="color: #bd2130">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4 && ico.rating < 4.5}">
                                            <small class="font-weight-bold" style="color: orange">
                                                rating ${ico.rating}</small>
                                        </c:when>

                                        <c:when test="${ico.rating >= 4.5}">
                                            <small class="font-weight-bold" style="color: green">
                                                rating ${ico.rating}</small>
                                        </c:when>
                                    </c:choose>
                                </p>
                            </div>
                            <div class="col">
                                <h5 class="card-title text-center font-weight-bold">${ico.name}</h5>
                            </div>
                            <div class="col">
                                <p class="text-right">
                                    <small>Ended ${ico.todayMinusIcoEnd()}d</small>
                                </p>
                            </div>
                        </div>

                        <p class="href" hidden>${context}/ico-page/${ico.name}</p>

                    </div>
                </div>
                <!--/.Panel-->
                <br/>
            </c:forEach>


            <button id="buttonFinished" style="width: 22rem" type="button" class="btn btn-brown btn-lg btn-block">GO
                MORE FINISHED ICO
            </button>


        </div>

    </div>

    <br/>

</div>


<jsp:include page="template/footer.jsp"/>