<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="workTypeGroup" required="true" type="ua.ksstroy.logic.workType.WorkTypeGroupData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<c:if test="${workTypeGroup.name ne 'root_group'}">
    <div class="controller hidden">
        <div class="controller_name">Update WorkTypeGroupName</div>
        <form action="${pageContext.request.contextPath}/projects/updateWorkTypeGroupName" method="post">
            <input type="hidden" name="groupId" value="${workTypeGroup.id}">
            <input type="hidden" name="projectId" value="${projectId}">
            <table>
                <tbody>
                <tr>
                    <td>name:</td>
                    <td><input type="text" name="newGroupName" value="${workTypeGroup.name}"></td>
                </tr>
                </tbody>
            </table>
            <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
        </form>
    </div>
</c:if>