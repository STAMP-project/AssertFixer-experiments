<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="template/header.jsp"/>



<script>
    $(document).ready(function () {
        $(function () {
            $('#myTab li:last-child a').tab('show')
        })
    })



</script>


<div class="container">


    <ul class="nav nav-pills mb-3" id="myTab" role="tablist">
        <c:forEach items="${blogs}" var="blog">
            <li class="nav-item">
                <a class="nav-link" id="pills-${blog.name}-tab" data-toggle="pill" href="#pills-${blog.name}"
                   role="tab" aria-controls="pills-${blog.name}" aria-selected="true">${blog.name}</a>
            </li>
        </c:forEach>
    </ul>


    <div class="tab-content" id="pills-tabContent">
        <c:forEach items="${blogs}" var="blog">

            <div class="tab-pane fade show active" id="pills-${blog.name}" role="tabpanel"
                 aria-labelledby="pills-${blog.name}-tab">

                <table>
                    <th>
                    <td>title</td>
                    <td>description</td>
                    <td>link</td>
                    </th>
                    <c:forEach items="${blog.items}" var="item">
                        <tr>
                            <td>${item.title}</td>
                            <td>${item.description}</td>
                            <td>${item.link}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

        </c:forEach>
    </div>
</div>


<jsp:include page="template/footer.jsp"/>