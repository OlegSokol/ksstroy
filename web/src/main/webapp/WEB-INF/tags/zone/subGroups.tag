
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

<ul class="subGroups">

	<c:forEach var="zones" items="${zhd.zones}">

		<div class="item">
			<img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">
			${zones.name}
			<div class="add_delete_wrapper">
				<div class="delete_btn">
					<img src="${delete_btn}" alt="Delete">
				</div>
				<div class="add_btn">
					<img src="${add_btn}" alt="Add">
				</div>
			</div>
		</div>

		<div class="controller">
			<div class="controller_name">ADD ADDITIONAL</div>
			<form action="http://localhost:8080/web/projects/addZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name"
								placeholder="TODO//validate"></td>
						</tr>
						<tr>
							<td>parent zoneId</td>
							<td><input type="text" name="parentGroupId" value="0">
							</td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName"
								placeholder="TODO//autocomplete"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width"
								placeholder="TODO//append measure"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh"
								placeholder="TODO//append measure"></td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
						<tr>
							<td>value</td>
							<td><input type="text" placeholder="TODO//=height*weight">
							</td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>

		<div class="controller">
			<div class="controller_name">ADD SURPLUS</div>
			<form action="http://localhost:8080/web/projects/addZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name"
								placeholder="TODO//validate"></td>
						</tr>
						<tr>
							<td>parent zoneId</td>
							<td><input type="text" name="parentGroupId" value="0">
							</td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName"
								placeholder="TODO//autocomplete"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width"
								placeholder="TODO//append measure"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh"
								placeholder="TODO//append measure"></td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
						<tr>
							<td>value</td>
							<td><input type="text" placeholder="TODO//=height*weight">
							</td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>

		<div class="controller">
			<div class="controller_name">UPDATE</div>
			<form action="http://localhost:8080/web/projects/addZone"
				method="post">
				<table>
					<tbody>
						<tr>
							<td>name</td>
							<td><input type="text" name="name"
								placeholder="TODO//validate"></td>
						</tr>
						<tr>
							<td>parent groupId</td>
							<td><input type="text" name="parentGroupId" value="0">
							</td>
						</tr>
						<tr>
							<td>measureName</td>
							<td><input type="text" name="measureName"
								placeholder="TODO//autocomplete"></td>
						</tr>
						<tr>
							<td>width</td>
							<td><input type="text" name="width"
								placeholder="TODO//append measure"></td>
						</tr>
						<tr>
							<td>height</td>
							<td><input type="text" name="heigh"
								placeholder="TODO//append measure"></td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
						<tr>
							<td>value</td>
							<td><input type="text" placeholder="TODO//=height*weight">
							</td>
						</tr>
						<!-- value calculation only for usability! server side should calculate it itself -->
					</tbody>
				</table>
				<input class="accepth_changes_btn" type="image" src="${done_btn}">
			</form>
		</div>


		<ul class="subZones">



			<c:forEach var="additional" items="${zones.additional}">



			</c:forEach>


			<c:forEach var="surplus" items="${zones.surplus}">

	
			</c:forEach>
		</ul>
	</c:forEach>
</ul>
<!--END OUTPUT Surplus -->