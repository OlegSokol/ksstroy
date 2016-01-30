<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="user" required="true" type="ua.ksstroy.logic.user.UserData" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>


<div class="item">
    <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
    ${user.name}
    <div class="add_delete_wrapper">
        <form action="${pageContext.request.contextPath}/users_projects/deleteUser" method="post">
            <input type="hidden" name="userId" value="${user.id}">
            <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
        </form>
        <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
        <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
             alt="show_update_forms">
    </div>

    <user:updataUser user="${user}"/>
    <user:addProject user="${user}"/>
</div>

