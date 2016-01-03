<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>
<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>
<spring:url value="/resources/css/mainStyle.css" var="css"/>
<spring:url value="/resources/js/mainScript.js" var="js"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${css}" rel="stylesheet"/>
    <script src="${js}"></script>
    <title>users_projects</title>
</head>
<body>
<div id="wraper">
<h2>Users</h2>
    <ul class="items_list">
        <c:forEach var="user" items="${usersList}">
            <user:user user="${user}"/>
            <ul>
                <user:projects user="${user}"/>
            </ul>

        </c:forEach>
    </ul>

</div>


</body>
</html>
