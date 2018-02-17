<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>

<%@ attribute name="workGroupData" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>
<%@attribute name="workType" required="true" type="ua.ksstroy.logic.worktype.WorkTypeGroupData" %>

<ul class="work-group">
    <work:workGroup workGroup ="${workGroupData}" workType="${workType}"/>
   <ul class="works">
        <work:works workList="${workGroupData.works}"/>
        <c:forEach var="innerMaterialType" items="${workGroupData.groups}">
            <work:node workGroupData="${innerMaterialType}" workType="${workType}"/>
        </c:forEach>

    </ul>
</ul>