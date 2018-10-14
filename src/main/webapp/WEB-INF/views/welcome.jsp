<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template/header.jsp"/>

<c:set var="context" scope="session" value="${pageContext.request.contextPath}"/>

<script>

    $(document).ready(function () {

        //get Top coins by ajax
        $.get(
            "${context}"  + "/ajax/topcoins",
            function (data) {
                $("#topCoins").empty();
                data.forEach(function (element) {
                    $("#topCoins").append('<tr class="coin hoverable">' +
                        '<td><p class="font-weight-bold">' + element.symbol + '</p></td>' +
                        '<td><p class="font-weight-bold">' + element.price.toFixed(2) + '$</p></td>' +
                        '<td><p style="color: green" class="font-weight-bold">' + element.percent_change_7d + '%</p></td>' +
                        '</tr>');
                })
            }
        );


        //get loose coins by ajax
        $.get(
           "${context}" + "/ajax/loosercoins",
            function (data) {
                $("#looseCoins").empty();
                data.forEach(function (element) {
                    $("#looseCoins").append('<tr class="coin hoverable">' +
                        '<td><p class="font-weight-bold">' + element.symbol + '</p></td>' +
                        '<td><p class="font-weight-bold">' + element.price.toFixed(2) + '$</p></td>' +
                        '<td><p style="color: red" class="font-weight-bold">' + element.percent_change_7d + '%</p></td>' +
                        '</tr>');
                })

            }
        );


        // $(".card").mouseenter(function () {
        //     $(this).css('cursor', 'pointer');
        //     var title = $(this).find(".title").text();
        //     var description = $(this).find(".description").text();
        //     var date = $(this).find(".date").text();
        //
        //     var th = $(this);
        //
        //     $(this).append("<div class=\"card-img-overlay   animated zoomin\">\n" +
        //         "                    <p class=\"card-text text-white brown darken-2\"> " + description + " </p>\n" +
        //         "                </div>")
        //
        //
        // })
        //
        // $(".card").mouseleave(function () {
        //     $(this).find(".card-img-overlay").removeClass("animated zoomin").removeClass("animated shake").addClass("animated zoomout");
        // })

    })


</script>

<style>

    h4 {
        height: 5.2rem;
        overflow: hidden;
    }

    .timeline {
        list-style: none;
        padding: 20px 0 20px;
        position: relative;
    }

    .timeline:before {
        top: 0;
        bottom: 0;
        position: absolute;
        content: " ";
        width: 3px;
        background-color: #eeeeee;
        left: 50%;
        margin-left: -1.5px;
    }

    .timeline > li {
        margin-bottom: 20px;
        position: relative;
    }

    .timeline > li:before,
    .timeline > li:after {
        content: " ";
        display: table;
    }

    .timeline > li:after {
        clear: both;
    }

    .timeline > li:before,
    .timeline > li:after {
        content: " ";
        display: table;
    }

    .timeline > li:after {
        clear: both;
    }

    .timeline > li > .timeline-panel {
        width: 46%;
        float: left;
        border: 1px solid #d4d4d4;
        border-radius: 2px;
        padding: 20px;
        position: relative;
        -webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
        box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
    }

    .timeline > li > .timeline-panel:before {
        position: absolute;
        top: 26px;
        right: -15px;
        display: inline-block;
        border-top: 15px solid transparent;
        border-left: 15px solid #ccc;
        border-right: 0 solid #ccc;
        border-bottom: 15px solid transparent;
        content: " ";
    }

    .timeline > li > .timeline-panel:after {
        position: absolute;
        top: 27px;
        right: -14px;
        display: inline-block;
        border-top: 14px solid transparent;
        border-left: 14px solid #fff;
        border-right: 0 solid #fff;
        border-bottom: 14px solid transparent;
        content: " ";
    }

    .timeline > li > .timeline-badge {
        color: #fff;
        width: 50px;
        height: 50px;
        line-height: 50px;
        font-size: 1.4em;
        text-align: center;
        position: absolute;
        top: 16px;
        left: 50%;
        margin-left: -25px;
        background-color: #999999;
        z-index: 100;
        border-top-right-radius: 50%;
        border-top-left-radius: 50%;
        border-bottom-right-radius: 50%;
        border-bottom-left-radius: 50%;
    }

    .timeline > li.timeline-inverted > .timeline-panel {
        float: right;
    }

    .timeline > li.timeline-inverted > .timeline-panel:before {
        border-left-width: 0;
        border-right-width: 15px;
        left: -15px;
        right: auto;
    }

    .timeline > li.timeline-inverted > .timeline-panel:after {
        border-left-width: 0;
        border-right-width: 14px;
        left: -14px;
        right: auto;
    }

    .timeline-badge.primary {
        background-color: #2e6da4 !important;
    }

    .timeline-badge.success {
        background-color: #3f903f !important;
    }

    .timeline-badge.warning {
        background-color: #f0ad4e !important;
    }

    .timeline-badge.danger {
        background-color: #d9534f !important;
    }

    .timeline-badge.info {
        background-color: #5bc0de !important;
    }

    .timeline-title {
        margin-top: 0;
        color: inherit;
    }

    .timeline-body > p,
    .timeline-body > ul {
        margin-bottom: 0;
    }

    .timeline-body > p + p {
        margin-top: 5px;
    }

    @media (max-width: 767px) {
        ul.timeline:before {
            left: 40px;
        }

        ul.timeline > li > .timeline-panel {
            width: calc(100% - 90px);
            width: -moz-calc(100% - 90px);
            width: -webkit-calc(100% - 90px);
        }

        ul.timeline > li > .timeline-badge {
            left: 15px;
            margin-left: 0;
            top: 16px;
        }

        ul.timeline > li > .timeline-panel {
            float: right;
        }

        ul.timeline > li > .timeline-panel:before {
            border-left-width: 0;
            border-right-width: 15px;
            left: -15px;
            right: auto;
        }

        ul.timeline > li > .timeline-panel:after {
            border-left-width: 0;
            border-right-width: 14px;
            left: -14px;
            right: auto;
        }
    }
</style>


<br/>

<%--items--%>
<div class="container">

    <div class="row">

        <div class="col">
            <h3 class="font-weight-bold">CRYPTO NEWS</h3>
            <hr style="size: 4rem" color="#795548"/>

            <div style="height: 18rem" class="card hoverable">

                <img style="height: 13rem" alt="Card image cap" class="card-img-top img-fluid"
                     src="${context}/resources/pic/l/l${topItem.getRandomPic(5)}.jpg">

                <h6 style="margin-left: 1rem" class="card-title font-weight-bold mt-1 ">${topItem.title}</h6>

                <div class="row">

                    <div class="col">
                        <p class="date text-left font-italic ml-3 mb-5">by ${topItem.source}</p>
                    </div>

                    <div class="col">
                        <p class="date text-right font-italic mr-3 mb-5">${topItem.diffMinutes()} min
                            ago</p>
                    </div>

                </div>

                <p style="margin-left: 3rem" class="description" hidden>${topItem.description}</p>
                <p class="href" hidden>${topItem.link}</p>
            </div>

            <br/>

            <div class="card-deck">
                <c:forEach items="${averageItems}" var="item" varStatus="i">

                    <div style="height: 20rem;width: 22rem" class="card hoverable">

                        <img style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                             src="${context}/resources/pic/m/m${i.count}.jpg">

                        <h6 class="card-title font-weight-bold ml-3 mt-2">${item.title}</h6>

                        <div class="row">
                            <div class="col">
                                <p class="date text-left font-italic ml-3 ">by ${item.source}</p>
                            </div>
                            <div class="col">
                                <c:choose>
                                    <c:when test="${item.diffHours() == 0}">
                                        <p style="margin-right: 1rem"
                                           class="date text-right font-italic">${ Math.abs(item.diffMinutes())} m
                                            ago </p>
                                    </c:when>
                                    <c:otherwise>
                                        <p style="margin-right: 1rem"
                                           class="date text-right font-italic">${Math.abs(item.diffHours())} h ago </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>

                    </div>


                </c:forEach>
            </div>
        </div>


        <div class="col-4 ">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs nav-justified " role="tablist">
                <li class="nav-item">
                    <a class="nav-link active  brown-text font-weight-bold" data-toggle="tab" href="#panel5" role="tab">
                        <i class="fa fa-sort-up"></i> TOP GAINS</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link  brown-text font-weight-bold" data-toggle="tab" href="#panel6" role="tab">
                        <i class="fa fa-sort-down"></i>TOP LOOSERS </a>
                </li>
            </ul>
            <!-- Nav tabs -->
            <!-- Tab panels -->
            <div class="tab-content font-weight-bold">
                <!--Panel 1-->
                <div class="tab-pane fade  in show active" id="panel5" role="tabpanel">
                    <table class="table h-50">
                        <tbody id="topCoins">
                        </tbody>
                    </table>
                </div>
                <!--/.Panel 1-->
                <!--Panel 2-->
                <div class="tab-pane fade " id="panel6" role="tabpanel">
                    <div class="tab-pane fade in show " id="panel" role="tabpanel">
                        <table class="table ">
                            <tbody id="looseCoins">
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--/.Panel 2-->
            </div>
            <!-- Tab panels -->
        </div>

    </div>

</div>

<%--items--%>
<div class="container">
    <div class="row">
        <div class="col">
            <br/>

            <div class="card-deck">

                <c:forEach items="${lowerItems}" var="item" varStatus="i">

                    <div style="height: 20rem;width: 22rem" class="card hoverable">

                        <img style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                             src="${context}/resources/pic/m/m${i.count}.jpg">

                        <h6 class="card-title font-weight-bold ml-3 mt-2">${item.title}</h6>

                        <div class="row">
                            <div class="col">
                                <p class="date text-left font-italic ml-3 ">by ${item.source}</p>
                            </div>
                            <div class="col">
                                <c:choose>
                                    <c:when test="${item.diffHours() == 0}">
                                        <p style="margin-right: 1rem"
                                           class="date text-right font-italic">${ Math.abs(item.diffMinutes())} m
                                            ago </p>
                                    </c:when>
                                    <c:otherwise>
                                        <p style="margin-right: 1rem"
                                           class="date text-right font-italic">${Math.abs(item.diffHours())} h ago </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <p class="description" hidden>${item.description}</p>
                        <p class="href" hidden>${item.link}</p>

                    </div>

                </c:forEach>

            </div>
            <br/>

        </div>
    </div>
</div>

<%--ICO--%>
<div class="container">

    <h3 class="font-weight-bold wow fadeInUp  hoverable">HOT ICO</h3>
    <hr style="size: 4rem" color="#795548"/>



    <div class="card-deck">

        <c:forEach items="${icos}" var="ico">

            <div class="card  hoverable">

                <div class="card-body">
                    <div class="text-center">
                        <img class="rounded-circle" src="${ico.logolink}" width="60" height="60">
                    </div>
                    <h5 style="margin-top: 2rem"
                        class="card-title text-center font-weight-bold">${ico.name}</h5>

                    <div class="row">
                        <div class="col">
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
                            <p class="text-right">
                                <small class="font-weight-bold">${Math.abs(ico.todayMinusIcoEnd())}d left
                                </small>
                            </p>
                        </div>
                    </div>
                </div>

                <p hidden class="href">${context}/ico-page/${ico.name}/</p>
                <p class="description" hidden>${ico.description}</p>

            </div>

            <br/>
        </c:forEach>
    </div>
</div>

<%--upcoming events--%>
<div class="container">
    <br/>
    <h3 class="font-weight-bold wow fadeInUp hoverable">UPCOMING EVENTS</h3>
    <hr style="size: 4rem" color="#795548"/>
    <ul class="timeline">

        <c:forEach items="${events}" var="event" varStatus="i">
            <c:choose>
                <c:when test="${(i.count%2) ==0}">
                    <li class="timeline-inverted">
                </c:when>
                <c:otherwise>
                    <li>
                </c:otherwise>
            </c:choose>

            <div class="timeline-badge brown">
                <i class="glyphicon glyphicon-check"></i>
            </div>

            <div class="timeline-panel ">

                <div class="timeline-heading ">

                    <div class="row">

                        <div class="col">

                            <div class="row">

                                <div class="col text-center">
                                    <h6 class="timeline-title text-center font-weight-bold">${event.name}</h6>
                                </div>

                                <div class="col text-center">
                                    <h3 class="font-weight-bold">${event.coinName}</h3>
                                </div>


                                <div class="col text-center">
                                    <c:choose>
                                        <c:when test="${event.isHot()}">
                                            <i style="color: red" class="fas fa-fire fa-2x"></i>
                                        </c:when>
                                    </c:choose>
                                </div>

                            </div>

                            <div class="col">
                                <div class="col">
                                    <h5 class=" text-center font-weight-bold">${event.title}</h5>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>

                <p class="font-weight-normal text-center">${event.description}</p>

                <div class="row">

                    <div class="col text-right">
                        <button value="${event.source}" type="button" class="btn btn-brown btn-rounded">Source
                        </button>
                    </div>
                    <br/>

                    <div class="col text-left">
                        <button value="${event.proof}" type="button" class="btn btn-brown btn-rounded">Proof
                        </button>
                    </div>

                </div>

            </div>

            </li>

        </c:forEach>

    </ul>

</div>


<jsp:include page="template/footer.jsp"/>