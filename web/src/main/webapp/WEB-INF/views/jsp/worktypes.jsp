<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

	<div class="container">

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Work Types</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
			</thead>

			<c:forEach var="entry" items="${worktypes}">
			    <tr>
				<td>
					${entry.id}
				</td>
				<td>${entry.name}</td>
				<td>${entry.description}</td>
				<td>
				  <spring:url value="/worktypes/${entry.id}" var="viewUrl" />
				  <spring:url value="/worktypes/${entry.id}/delete" var="deleteUrl" /> 
				  <spring:url value="/worktypes/${entry.id}/update" var="updateUrl" />

				  <button class="btn btn-info" 
                                          onclick="location.href='${viewUrl}'">View</button>
				  <button class="btn btn-primary" 
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger" 
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>