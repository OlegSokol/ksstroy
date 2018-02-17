<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ua.ksstroy</title>
      <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>
    <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    <h2>Projects</h2>

    <p>
        <c:if test="${empty projects}">
        You haven't any project
        </c:if>

        <c:forEach items="${projects}" var="entry">
            <a href="./projects/${entry.id}">${entry.projectName}</a><br>
        </c:forEach>
    </p>
</div>
</body>
</html>