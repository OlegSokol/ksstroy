<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true"
              type="ua.ksstroy.logic.zonegroup.ZoneHierarchyData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="purchase"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">ADD ZONE</div>
    <form action="${pageContext.request.contextPath}/projects/addZone" method="post">
        <input type="hidden" name="parentGroupId" value="${zhd.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name</td>
                <td><input type="text" name="name" placeholder="TODO//validate"></td>
            </tr>
            <tr>
                <td>width</td>
                <td><input type="text" name="width" placeholder="TODO//append width"></td>
            </tr>
            <tr>
                <td>height</td>
                <td><input type="text" name="heigh" placeholder="TODO//append heigh"></td>
            </tr>
            <tr>
                <td>measureName</td>
                <td><input type="text" name="measureName" placeholder="TODO//autocomplete"></td>
            </tr>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>