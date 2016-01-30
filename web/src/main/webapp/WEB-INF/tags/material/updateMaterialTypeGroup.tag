<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="materialTypeGroupData" required="true" type="ua.ksstroy.logic.material.MaterialTypeGroupData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<c:if test="${materialTypeGroupData.name ne 'root_group'}">
    <div class="controller hidden">
        <div class="controller_name">Update Material Type Group</div>
        <form action="${pageContext.request.contextPath}/projects/updateMaterialTypeGroup" method="post">
            <input type="hidden" name="id" value="${materialTypeGroupData.id}">
            <input type="hidden" name="projectId" value="${projectId}">
            <table>
                <tbody>
                <tr>
                    <td>name:</td>
                    <td><input type="text" name="name" value="${materialTypeGroupData.name}"></td>
                </tr>
                <tr>
                    <td>description:</td>
                    <td><input type="text" name="description" value="${materialTypeGroupData.description}"></td>
                </tr>
                </tbody>
            </table>
            <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
        </form>
    </div>
</c:if>