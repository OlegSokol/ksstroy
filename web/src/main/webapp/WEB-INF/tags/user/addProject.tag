<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@attribute name="user" type="ua.ksstroy.logic.user.UserData" required="true" %>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Add Project</div>
    <form action="${pageContext.request.contextPath}/users_projects/addProject" method="post">
        <input type="hidden" name="userId" value="${user.id}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="Enter name"></td>
            </tr>
            <tr>
                <td>description:</td>
                <td><input type="text" name="description" placeholder="Enter role"></td>
            </tr>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>
