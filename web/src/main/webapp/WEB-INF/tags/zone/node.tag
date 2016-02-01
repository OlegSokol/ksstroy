<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true" type="ua.ksstroy.logic.zone.ZoneGroup" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<li>
    <group:groups zhd="${zhd}"/>
    <zone:zone zhd="${zhd}"/>
    <c:forEach var="currentZhd" items="${zhd.groups}">
        <zone:node zhd="${currentZhd}"/>
    </c:forEach>
</li>

