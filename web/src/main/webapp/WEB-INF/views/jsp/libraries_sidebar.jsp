<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<ul class="library">
  <h4><spring:message code="LIBRARYES" text="spring message fucked up" /></h4>
  <li>
    <div>
      <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}/library_worktypes"> <spring:message code="library_worktypes" text="spring message fucked up" /></a>
    </div>
  </li>
  <li>
    <div>
      <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}/library_materials"><spring:message code="library_materials" text="spring message fucked up" /></a>
    </div>
  </li>
</ul>