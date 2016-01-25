<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true" type="ua.ksstroy.logic.zonegroup.ZoneHierarchyData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<c:if test="${rootGroupId ne zhd.id}">
    <div class="item zone-group">
        <img class=" dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
            ${zhd.name}

        <div class="add_delete_wrapper">
            <form action="${pageContext.request.contextPath}/projects/removeGroup" method="post">
                <input type="hidden" name="projectId" value="${projectId}">
                <input type="hidden" name="groupId" value="${zhd.id}">
                <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
            </form>
            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
            <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">

        </div>
            <group:addGroup zhd ="${zhd}"/>
            <group:addZone zhd ="${zhd}"/>
            <group:updateGroup zhd ="${zhd}"/>
    </div>
</c:if>