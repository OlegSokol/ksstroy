<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="workGroup" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Add Work</div>
    <form action="${pageContext.request.contextPath}/projects/addWork" method="post">
        <input type="hidden" name="parentId" value="${workGroup.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="Enter name"></td>
            </tr>
            <tr>
                <td>type id:</td>
                <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
            </tr>
            <tr>
                <td>planedCost:</td>
                <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
            </tr>

            <tr> e
                <td>perspectiveCost:</td>
                <td><input type="text" name="perspectiveCost" placeholder="Enter perspectiveCost"></td>
            </tr>
            <tr>
                <td>closedCost:</td>
                <td><input type="text" name="closedCost" placeholder="Enter closedCost"></td>
            </tr>
            <tr>
                <td>dealCost:</td>
                <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
            </tr>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>