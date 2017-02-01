<%--
  Created by IntelliJ IDEA.
  User: nedwaldie
  Date: 1/31/17
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="/partials/navbar.jsp"/>
    <h1>Featured ads</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <p><a href="ads?id=${ad.id}">Show Ad</a></p>
        </div>
    </c:forEach>
</div>
</body>
</html>
