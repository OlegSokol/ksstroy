<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="work" required="true" type="ua.ksstroy.logic.work.WorkData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">UPDATE WORK</div>
    <form action="${pageContext.request.contextPath}/projects/updateWork" method="post">
        <input type="hidden" name="id" value="${work.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${work.name}"></td>
            </tr>
            <tr>
                <td>type:</td>
                <td><input type="text" name="type" value="${work.type.name}"></td>
            </tr>
            <tr>
                <td>planedCost:</td>
                <td><input type="text" name="planedCost" value="${work.planedCost}"></td>
            </tr>
            <tr>
                <td>perspectiveCost:</td>
                <td><input type="text" name="perspectiveCost" value="${work.perspectiveCost}"></td>
            </tr>
            <tr>
                <td>closedCost:</td>
                <td><input type="text" name="closedCost" value="${work.closedCost}"></td>
            </tr>
            <tr>
                <td>dealCost:</td>
                <td><input type="text" name="dealCost" value="${work.dealCost}"></td>
            </tr>
            </tbody>
        </table>
        <input class="accepth_changes_btn" type="image" src="${done_btn}">
    </form>
</div>