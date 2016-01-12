<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="work" tagdir="/WEB-INF/tags/work" %>

<%@ attribute name="workGroupData" required="true" type="ua.ksstroy.logic.work.WorkGroupData" %>

<ul class="group">
    <work:workGroup workGroup ="${workGroupData}"/>
    <ul class="subgroups">
        <work:works workList="${workGroupData.works}"/>
        <c:forEach var="innerMaterialType" items="${workGroupData.groups}">
            <work:node workGroupData="${innerMaterialType}"/>
        </c:forEach>
    </ul>
</ul>