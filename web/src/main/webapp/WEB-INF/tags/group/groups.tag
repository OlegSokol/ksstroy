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

<div class="item">
	<img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">
	${zhd.name}
	<div class="add_delete_wrapper">
		<div class="delete_btn">
			<form action="http://localhost:8080/web/projects/removeGroup"
				method="post">
				<input type="image" src="${delete_btn}" name="groupId"
					value="${zhd.id}" alt="Delete">
			</form>
		</div>
		<div class="add_btn">
			<img src="${add_btn}" alt="Add">
		</div>
	</div>
</div>
<div class="controller">
	<div class="controller_name">ADD GROUP</div>
	<form action="http://localhost:8080/web/projects/addGroupToGroup"
		method="post">
		<input type="hidden" name="parentGroupId" value="${zhd.id}">
		<table>
			<tbody>
				<tr>
					<td>name</td>
					<td><input type="text" name="groupName"
						placeholder="TODO//validate"></td>
				</tr>
			</tbody>
		</table>
		<input class="accepth_changes_btn" type="image" src="${done_btn}">
	</form>
</div>
<div class="controller">
	<div class="controller_name">ADD ZONE</div>
	<form action="http://localhost:8080/web/projects/addZone" method="post">
	<input type="hidden" name="parentGroupId" value="${zhd.id}" >
		<table>
			<tbody>
				<tr>
					<td>name</td>
					<td><input type="text" name="name"
						placeholder="TODO//validate"></td>
				</tr>
				<tr>
					<td>width</td>
					<td><input type="text" name="width"
						placeholder="TODO//append width"></td>
				</tr>
				<tr>
					<td>height</td>
					<td><input type="text" name="heigh"
						placeholder="TODO//append heigh"></td>
				</tr>
				<tr>
					<td>measureName</td>
					<td><input type="text" name="measureName"
						placeholder="TODO//autocomplete"></td>
				</tr>
				
			</tbody>
		</table>
		<input class="accepth_changes_btn" type="image" src="${done_btn}">
	</form>
</div>
<div class="controller">
	<div class="controller_name">UPDATE GROUP</div>
	<form action="http://localhost:8080/web/projects/updateGroup">
	<input type="hidden" name="id" value="${zhd.id}">
		<table>
			<tbody>
				
				<tr>
					<td>name</td>
					<td><input type="text" name="groupName" value="${zhd.name}"></td>
				</tr>
			</tbody>
		</table>
		<label class="accepth_changes_btn"> <input type="image"
			name="image" src="${done_btn}">
		</label>
	</form>
</div>

