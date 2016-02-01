<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>

<%@ attribute name="workGroup" required="true" type="ua.ksstroy.logic.work.WorkGroup" %>
<%@attribute name="workType" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroup" %>

<ul class="work-group">
    <work:workGroup workGroup ="${workGroup}" workType="${workType}"/>
   <ul class="works">
        <work:works workList="${workGroup.work}"/>
        <c:forEach var="innerMaterialType" items="${workGroup.groups}">
            <work:node workGroup="${innerMaterialType}" workType="${workType}"/>
        </c:forEach>

    </ul>
</ul>