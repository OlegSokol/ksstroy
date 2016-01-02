<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="materialTypeData" required="true" type="ua.ksstroy.logic.material.MaterialTypeData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<c:if test="${materialTypeData.name ne 'root_group'}">
    <div class="controller hidden">
        <div class="controller_name">Update Material Type</div>
        <form action="${pageContext.request.contextPath}/projects/updateMaterialType" method="post">
            <input type="hidden" name="id" value="${materialTypeData.id}">
            <input type="hidden" name="projectId" value="${projectId}">
            <table>
                <tbody>
                <tr>
                    <td>name:</td>
                    <td><input type="text" name="name" value="${materialTypeData.name}"></td>
                </tr>
                <tr>
                    <td>description:</td>
                    <td><input type="text" name="description" value="${materialTypeData.description}"></td>
                </tr>
                </tbody>
            </table>
            <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
        </form>
    </div>
</c:if>