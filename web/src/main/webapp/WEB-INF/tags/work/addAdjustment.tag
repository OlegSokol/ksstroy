<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="work" required="true" type="ua.ksstroy.logic.work.WorkData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">Add Adjustment</div>
    <form action="${pageContext.request.contextPath}/projects/addAdjustmentToWork" method="post">
        <input type="hidden" name="workId" value="${work.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>value:</td>
                <td><input type="text" name="value" placeholder="Enter value"></td>
            </tr>
            <tr>
                <td>is absolute?:</td>
                <td><input type="text" name="isAbsolute" placeholder="Enter absolute"></td>
            </tr>
            </tbody>
        </table>
        <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
</div>