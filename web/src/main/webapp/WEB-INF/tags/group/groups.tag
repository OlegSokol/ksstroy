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
				<input type="hidden" name="projectId" value="${projectId}">
				<input type="image" src="${delete_btn}" name="groupId"
					value="${zhd.id}" alt="Delete">
			</form>
		</div>
		<div class="add_btn">
			<img src="${add_btn}" alt="Add">
		</div>
	</div>
</div>


