	<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="zones" required="true" type="ua.ksstroy.logic.zone.ZoneData"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/img/arrow_drop_down.png"
	var="arrow_drop_down" />
<spring:url value="/resources/img/add_btn.png" var="add_btn" />
<spring:url value="/resources/img/delete_btn.png" var="delete_btn" />
<spring:url value="/resources/img/done_btn.png" var="done_btn" />
	
	<div class="controller">
			<div class="controller_name">UPDATE ZONE</div>
			<form action="http://localhost:8080/web/projects/updateZone"
				method="post">
				<input type="hidden" name="parentGroupId" value="${zones.value}">
				<input type="hidden" name="zoneId" value="${zones.id}">
				<input type="hidden" name="projectId" value="${projectId}">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name" value="${zones.name}"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width" value="${zones.width}"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh" value="${zones.height}"></td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName"
								value="${zones.measureName}"></td>
						</tr>
						<tr>
							<td>value</td>
							<td><input type="text" name="value" value="${zones.value}"></td>
						</tr>

					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>
	