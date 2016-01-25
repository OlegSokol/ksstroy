<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="additional" required="true" type="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>


<c:forEach var="additional" items="${additional}">
    <li>
        <div class="item additional">
            <img class=" dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
            + ${additional.name}
            <div class="add_delete_wrapper">
                <div class="delete_btn">
                    <form action="${pageContext.request.contextPath}/projects/removeZone" method="post">
                        <input type="hidden" name="projectId" value="${projectId}">
                        <input type="hidden" name="zoneId" value="${additional.id}">
                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
                    </form>
                </div>
                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">
            </div>
            <zone:updateZone zones="${additional}"/>
        </div>



    </li>
</c:forEach>