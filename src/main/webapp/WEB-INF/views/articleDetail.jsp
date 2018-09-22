<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 9/21/2018
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        <c:out value="Login"/>
    </layout:put>
    <layout:put block="styleLinks" type="REPLACE">

    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div>

            <img src="<c:url value="${article.image}"/>" height="200">
            <br/>
                ${article.category}
            <br/>
                ${article.title}
            <br/>
                ${article.publicationDate}
            <br>
                ${article.author}
            <br>
                ${article.content}
            <br>
        </div>
        </div>
    </layout:put>
</layout:extends>