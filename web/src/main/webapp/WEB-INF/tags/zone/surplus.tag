<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="surplus" required="true" type="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/img/arrow_drop_down.png"
	var="arrow_drop_down" />
<spring:url value="/resources/img/add_btn.png" var="add_btn" />
<spring:url value="/resources/img/delete_btn.png" var="delete_btn" />
<spring:url value="/resources/img/done_btn.png" var="done_btn" />

<c:forEach var="surplus" items="${surplus}">
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
							<input type="hidden" name="parentGroupId" value="${zhd.id}">
							<input type="hidden" name="zoneId" value="${surplus.id}">
							<table>
								<tbody>
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