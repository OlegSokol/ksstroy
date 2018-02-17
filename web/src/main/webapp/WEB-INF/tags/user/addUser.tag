<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
  <div class="controller_name">Add User</div>
  <form action="${pageContext.request.contextPath}/users_projects/addUser" method="post">
    <table>
      <tbody>
      <tr>
        <td>name:</td>
        <td><input type="text" name="name" placeholder="Enter name"></td>
      </tr>
      <tr>
        <td>role:</td>
        <td><input type="text" name="role" placeholder="Enter role"></td>
      </tr>
      <tr>
        <td>password:</td>
        <td><input type="text" name="password" placeholder="Enter password"></td>
      </tr>
            </tbody>
    </table>
    <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
  </form>
</div>
