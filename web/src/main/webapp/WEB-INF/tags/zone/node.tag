<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="zhd" required="true" type="ua.ksstroy.logic.zone.ZoneHierarchyData"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<div id="wraper">
		<div id="zoneHierarchiDataTree">
	
            <group:groups zhd="${zhd}" />
            <group:addGroup zhd ="${zhd}"/>
            <group:addZone zhd ="${zhd}"/>
            <group:updateGroup zhd ="${zhd}"/>
            
          
			<c:forEach var="currentZhd" items="${zhd.groups}">
				<zone:node zhd="${currentZhd}" />
				<zone:zone zhd="${currentZhd}" />
			</c:forEach>

		</div>
	</div>
