<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}"><spring:message code="project" text="spring message fucked up" /></a>
    <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}/zones"><spring:message code="zones" text="spring message fucked up" /></a>
    <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}/work"><spring:message code="work" text="spring message fucked up" /></a>
    <a class="menu_item" href="${pageContext.request.contextPath}/projects/${projectId}/materials"><spring:message code="materials" text="spring message fucked up" /></a>
</header>
