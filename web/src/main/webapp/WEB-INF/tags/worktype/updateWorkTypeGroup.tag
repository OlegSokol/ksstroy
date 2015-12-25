<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="workTypeGroup" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroupData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller">
  <div class="controller_name">UPDATE WorkTypeGroupName</div>
  <form action="${pageContext.request.contextPath}/workType/updateWorkTypeGroupName" method="post">
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
    <input class="accepth_changes_btn" type="image" src="${done_btn}">
  </form>
</div>
