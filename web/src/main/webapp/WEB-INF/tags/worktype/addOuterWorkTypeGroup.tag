<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="outerWorkTypeGroup" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroup" %>
<%@ taglib prefix="worktype" tagdir="/WEB-INF/tags/worktype" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller">
    <div class="controller_name">Add OuterWorkTypeGroup</div>
    <form action="${pageContext.request.contextPath}/workType/addOuterWorkTypeGroup" method="post">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" placeholder="Enter name"></td>
            </tr>
            </tbody>
        </table>
        <input class="accepth_changes_btn" type="image" src="${done_btn}">
    </form>
</div>