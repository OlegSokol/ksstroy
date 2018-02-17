<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="user" required="true" type="ua.ksstroy.logic.user.UserData" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>


  <div class="controller hidden">
    <div class="controller_name">UPDATE USER</div>
    <form action="${pageContext.request.contextPath}/users_projects/updateUser" method="post">
      <input type="hidden" name="userId" value="${user.id}">
      <table>
        <tbody>
        <tr>
          <td>name</td>
          <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
          <td>role</td>
          <td><input type="text" name="role" value="${user.role}"></td>
        </tr> <tr>
          <td>password</td>
          <td><input type="text" name="password" value="${user.password}"></td>
        </tr>

        </tbody>
      </table>
      <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
    </form>
  </div>

