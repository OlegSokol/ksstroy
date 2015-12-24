<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ua.ksstroy</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
    </script>
    <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>
    <spring:url value="/resources/js/hello.js" var="js"/>
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