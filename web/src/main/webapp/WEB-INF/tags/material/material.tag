<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="material" tagdir="/WEB-INF/tags/material" %>
<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<%@attribute name="materialsList" type="java.util.List" %>

<c:forEach var="material" items="${MaterialsList}">
<li>
      <div class="item">

      ${material.materialType.name}
    <div class="add_delete_wrapper">
      <form action="${pageContext.request.contextPath}/users_projects/deleteUser" method="post">
        <input type="hidden" name="userId" value=" ${material.id}">
        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
      </form>
      <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
      <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
           alt="show_update_forms">
    </div>

          <material:updateMaterial material="${material}"/>
          this forms are only for display values(not to update)
          <material:updateMaterialType materialTypeData="${material.materialType}"/>
  </div>
</li>
</c:forEach>
