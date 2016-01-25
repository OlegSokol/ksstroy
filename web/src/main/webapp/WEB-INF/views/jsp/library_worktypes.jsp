<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="worktype" tagdir="/WEB-INF/tags/worktype" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>
    <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    <jsp:include page="libraries_sidebar.jsp"/>
    <jsp:include page="single_project_menu.jsp"/>
    <ul id="workTypeDataTree">
        <ul class="initializers">
            <worktype:addWorkTypeGroup innerWorkTypeGroup="${workTypeGroup}"/>
            <worktype:addWorkTypes workTypeGroup="${workTypeGroup}"/>
        </ul>
        <worktype:node workTypeGroup="${workTypeObject}"/>
    </ul>
</div>
</body>
</html>