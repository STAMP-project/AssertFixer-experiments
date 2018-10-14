<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/>


<style>

   .card-group {
       /*column-count: 6;*/

       column-count: 4;



   }

    h4 {
        height: 5.2rem;
        overflow: hidden;
    }
</style>

<script>


    $(document).ready(function () {

        $("button").click(function () {
            var href = $(this).attr("value");

            if (href != null)
                window.location = href;

        })
    })
</script>


<ul class="nav justify-content-center font-weight-bold brown lighten-5 ">

    <c:forEach items="${sources}" var="source">
        <li class="nav-item">
            <button  id="buttonNews" value="${context}/news/${source.toString()}" type="button"
                    class="btn btn-brown btn-rounded">${source.toString()}</button>
        </li>
    </c:forEach>

</ul>

<div class="container">

        <br/>
        <br/>
        <div class="card-columns">

            <c:forEach items="${items}" var="item" varStatus="i">

                <div style="height: 20rem;width: 22rem" class="card hoverable">

                    <img style="width: 22rem;height: 12rem" alt="Card  image cap" class="card-img-top img-fluid"
                         src="${context}/resources/pic/m/m${item.getRandomPic(9)}.jpg">

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

                <!--Panel-->
            </c:forEach>


        </div>

</div>

<jsp:include page="template/footer.jsp"/>