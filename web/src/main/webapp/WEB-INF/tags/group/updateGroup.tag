<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true" type="ua.ksstroy.logic.zoneGroup.ZoneHierarchyData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<c:if test="${rootGroupId ne zhd.id}">
    <div class="controller hidden">
        <div class="controller_name">UPDATE GROUP</div>
        <form action="${pageContext.request.contextPath}/projects/updateGroup" method="post">
            <input type="hidden" name="id" value="${zhd.id}"> <input
                type="hidden" name="projectId" value="${projectId}">
            <table>
                <tbody>
                <td>name</td>
                <td><input type="text" name="groupName" value="${zhd.name}"></td>
                </tbody>
            </table>
            <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
        </form>
    </div>
</c:if>