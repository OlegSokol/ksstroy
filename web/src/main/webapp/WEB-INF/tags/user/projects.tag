<%@tag pageEncoding="UTF-8"%>
<%@attribute name="user" type="ua.ksstroy.logic.user.UserData" required="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<c:forEach var="project" items="${user.projectsList}" >
    <li>
        <div class="item">
            <form class="inline_form" name="formFor${project.id}" action="${pageContext.request.contextPath}/projects/${project.id}" method="post">
            <input type="hidden" name="userName" value="${user.name}">
            <input type="hidden" name="projectName" value="${project.projectName}">
            <a href="javascript:document.formFor${project.id}.submit()">${project.projectName}</a>
        </form>

        <div class="add_delete_wrapper">
            <form action="${pageContext.request.contextPath}/users_projects/deleteProject" method="post">
                <input type="hidden" name="projectId" value="${project.id}">
                <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
            </form>
            <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">
        </div>
        <div class="controller hidden">
            <div class="controller_name">UPDATE PROJECT</div>
            <form action="${pageContext.request.contextPath}/users_projects/updateProject" method="post">
                <input type="hidden" name="projectId" value="${project.id}">
                <table>
                    <tbody>
                    <tr>
                        <td>name</td>
                        <td><input type="text" name="name" value="${project.projectName}"></td>
                    </tr>
                    <tr>
                        <td>description</td>
                        <td><input type="text" name="description" value="${project.description}"></td>
                    </tr>

                    </tbody>
                </table>
                <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
            </form>
        </div>
    </div>
    </li>
  </c:forEach>