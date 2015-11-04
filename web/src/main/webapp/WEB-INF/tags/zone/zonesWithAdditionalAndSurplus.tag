<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="zhd" required="true"
	type="ua.ksstroy.logic.zone.ZoneHierarchyData"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/img/arrow_drop_down.png"
	var="arrow_drop_down" />
<spring:url value="/resources/img/add_btn.png" var="add_btn" />
<spring:url value="/resources/img/delete_btn.png" var="delete_btn" />
<spring:url value="/resources/img/done_btn.png" var="done_btn" />

<ul class="zones">

	<c:forEach var="zones" items="${zhd.zones}">

		<div class="item">
			<img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">
			${zones.name}
			<div class="add_delete_wrapper">
				<div class="delete_btn">
					<form action="http://localhost:8080/web/projects/removeZone"
						method="post">
						<input type="image" src="${delete_btn}" name="zoneId"
							value="${zones.id}" alt="Delete">
					</form>
				</div>
				<div class="add_btn">
					<img src="${add_btn}" alt="Add">
				</div>
			</div>
		</div>

		<div class="controller">
			<div class="controller_name">ADD ADDITIONAL</div>
			<form action="http://localhost:8080/web/projects/addAdditionalZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name" value="NewAdditional"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width" value="4.0"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh" value="3.0"></td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName" value="M2"></td>
						</tr>
						<tr>
							<td>parent zoneId</td>
							<td><input type="text" name="parentZoneId"
								value="${zones.id}"></td>
						</tr>
										</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>

		<div class="controller">
			<div class="controller_name">ADD SURPLUS</div>
			<form action="http://localhost:8080/web/projects/addSurplusZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name" value="NewSurplus"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width" value="3.0"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh" value="8.0"></td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName" value="M2"></td>
						</tr>
						<tr>
							<td>parent zoneId</td>
							<td><input type="text" name="parentZoneId"
								value="${zones.id}"></td>
						</tr>
					
					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>

		<div class="controller">
			<div class="controller_name">UPDATE ZONE</div>
			<form action="http://localhost:8080/web/projects/updateZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>id</td>
							<td><input type="text" name="zoneId" value="${zones.id}"></td>
						</tr>
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
							<td>parent groupId</td>
							<td><input type="text" name="parentGroupId" value="${zhd.id}">
							</td>
						</tr>
						<tr>
							<td>value</td>
							<td><input type="text" name="value"
								value="${zones.value}"></td>
						</tr>

					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>

		<ul class="subZones">

			<c:forEach var="additional" items="${zones.additional}">
				<li>
					<div class="item">
						<img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">
						+${additional.name}
						<div class="add_delete_wrapper">
							<div class="delete_btn">
								<form action="http://localhost:8080/web/projects/removeZone"
									method="post">
									<input type="image" src="${delete_btn}" name="zoneId"
										value="${additional.id}" alt="Delete">
								</form>
							</div>
							<div class="add_btn">
								<img src="${add_btn}" alt="Add">
							</div>
						</div>
					</div>
					<div class="controller">
						<div class="controller_name">UPDATE ADDITIONAL</div>
						<form action="http://localhost:8080/web/projects/updateZone"
							method="post">
							<table>
								<tbody>
									<tr>
										<td>id</td>
										<td><input type="text" name="zoneId"
											value="${additional.id}"></td>
									</tr>
									<tr>
										<td>name</td>
										<td><input type="text" name="name"
											value="${additional.name}"></td>
									</tr>
									<tr>
										<td>width</td>
										<td><input type="text" name="width"
											value="${additional.width}"></td>
									</tr>
									<tr>
										<td>height</td>
										<td><input type="text" name="heigh"
											value="${additional.height}"></td>
									</tr>
									<tr>
										<td>measureName</td>
										<td><input type="text" name="measureName"
											value="${additional.measureName}"></td>
									</tr>
									<tr>
							<td>parent groupId</td>
							<td><input type="text" name="parentGroupId" value="${zhd.id}">
							</td>
							</tr>
									<tr>
							<td>value</td>
							<td><input type="text" value="${additional.value}">
							</td>
						</tr> 
								</tbody>
							</table>
							<input class="accepth_changes_btn" type="image" src="${done_btn}">
						</form>
					</div>
				</li>

			</c:forEach>

			<c:forEach var="surplus" items="${zones.surplus}">
				<li>
					<div class="item">
						<img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">
						-${surplus.name}
						<div class="add_delete_wrapper">
							<div class="delete_btn">
								<form action="http://localhost:8080/web/projects/removeZone"
									method="post">
									<input type="image" src="${delete_btn}" name="zoneId"
										value="${surplus.id}" alt="Delete">
								</form>
							</div>
							<div class="add_btn">
								<img src="${add_btn}" alt="Add">
							</div>
						</div>
					</div>

					<div class="controller">
						<div class="controller_name">UPDATE SURPLUS</div>
						<form action="http://localhost:8080/web/projects/updateZone"
							method="post">
							<table>
								<tbody>
									<tr>
										<td>id</td>
										<td><input type="text" name="zoneId"
											value="${surplus.id}"></td>
									</tr>
									<tr>
										<td>name</td>
										<td><input type="text" name="name"
											value="${surplus.name}"></td>
									</tr>
									<tr>
										<td>width</td>
										<td><input type="text" name="width"
											value="${surplus.width}"></td>
									</tr>
									<tr>
										<td>height</td>
										<td><input type="text" name="heigh"
											value="${surplus.height}"></td>
									</tr>
									<tr>
										<td>measureName</td>
										<td><input type="text" name="measureName"
											value="${surplus.measureName}"></td>
									</tr>
								<tr>
							<td>parent groupId</td>
							<td><input type="text" name="parentGroupId" value="${zhd.id}">
							</td>
						</tr>
									<tr>
							<td>value</td>
							<td><input type="text" value="${surplus.value}">
							</td>
						</tr>
								</tbody>
							</table>
							<input class="accepth_changes_btn" type="image" src="${done_btn}">
						</form>
					</div>
				</li>
			</c:forEach>
		</ul>
	</c:forEach>
</ul>
