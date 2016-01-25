<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>project</title>
    <spring:url value="/resources/css/mainStyle.css" var="commonCss"/>
    <link href="${commonCss}" rel="stylesheet"/>
    <spring:url value="/resources/css/project.css" var="customCss"/>
    <link href="${customCss}" rel="stylesheet"/>

    <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    user: ${userName}<br>
    project:${projectName}
   <jsp:include page="single_project_menu.jsp"/>

   <jsp:include page="libraries_sidebar.jsp"/>
</div>
</body>
</html>
