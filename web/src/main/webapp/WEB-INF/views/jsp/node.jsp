<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div id="zoneHierarchiDataTree">
		 <ul>
			<c:forEach var="zhd" items="${zhd.groups}">
				<!-- OUTPUT ZHD groups<ZoneHierarchiData> -->

				<li>
					<div class="zoneGroups_basicView">
						<img class="clickableIcon" alt="expand-collapse_btn"
							src="<c:url value="/resources/img/expand_down.png" />">
						${zhd.name} <img class="delete_btn" alt="delete_btn"
							src="<c:url value="/resources/img/delete_btn.png" />">
					</div>
				</li>
				<!-- expanded zoneGroup -->

				<li class="expanded">
					<div class="zoneGroups_ExpandedView">
						<form action="">
							<table>
								<tr>
									<td>id</td>
									<td><input type="text" value="${zhd.id}"></td>
								</tr>
								<tr>
									<td>name</td>
									<td><input type="text" value="${zhd.name}"></td>
								</tr>
								<tr>
									<td>group</td>
									<td><input type="text" value="TODO//parent group"></td>
								</tr>
							</table>
							<input class="accepth_changes_btn" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>
				
				<!--END expanded zoneGroup -->

				<!--END OUTPUT ZHD groups<ZoneHierarchiData> -->
				<!-- OUTPUT zones<ZoneData> -->

<ul class="subGroups">

				<c:forEach var="zones" items="${zhd.zones}">
					<li>
						<div class="zones_basicView  ">
							<img class="clickableIcon" alt="expand-collapse_btn"
								src="<c:url value="/resources/img/expand_down.png" />">
							${zones.name} <img class="delete_btn"
								alt="delete_btn"
								src="<c:url value="/resources/img/delete_btn.png" />">
						</div>
					</li>
					<!-- expanded Zones -->
					<li class="expanded">
						<div class="zoneGroups_ExpandedView">
							<form action="">
								<table>
									<tr>
										<td>id</td>
										<td><input type="text" value="${zones.id}"></td>
									</tr>
									<tr>
										<td>name</td>
										<td><input type="text" value="${zones.name}"></td>
									</tr>
									<tr>
										<td>group</td>
										<td><input type="text" value="TODO//parent group"></td>
									</tr>
								</table>
								<input class="accepth_changes_btn" type="image"
									src="<c:url value="/resources/img/done_btn.png" />">
							</form>
						</div>
					</li>
			

					<!--END expanded Zones -->

					<!--END OUTPUT Zones<ZoneData> -->
					 <ul class="subZones">
					<c:forEach var="additional" items="${zones.additional}">
				

						<li>
							<!-- OUTPUT additional -->
							<div class="zones_basicView">
								<img class="clickableIcon" alt="expand-collapse_btn"
									src="<c:url value="/resources/img/expand_down.png" />"> +
								${additional.name} <img class="delete_btn"
									alt="delete_btn"
									src="<c:url value="/resources/img/delete_btn.png" />">
							</div>
						</li>

						<li class="expanded">
							<!-- expanded Additional -->
							<div class="zoneGroups_ExpandedView ">
								<form action="">
									<table>
										<tr>
											<td>id</td>
											<td><input type="text" value="${additional.id}"></td>
										</tr>
										<tr>
											<td>name</td>
											<td><input type="text" value="${additional.name}"></td>
										</tr>
										<tr>
											<td>group</td>
											<td><input type="text" value="TODO//parent group"></td>
										</tr>
									</table>
									<input class="accepth_changes_btn" type="image"
										src="<c:url value="/resources/img/done_btn.png" />">
								</form>
							</div>
						</li>
							

						<!--END expanded Additional -->
						<!--END OUTPUT additional -->
					</c:forEach>
					 
					<!-- OUTPUT Surplus -->
					 
						<c:forEach var="surplus" items="${zones.surplus}">

							<li>
								<div class="zones_basicView">
									<img class="clickableIcon" alt="expand-collapse_btn"
										src="<c:url value="/resources/img/expand_down.png" />">
									- ${surplus.name} <img class="delete_btn"
										alt="delete_btn"
										src="<c:url value="/resources/img/delete_btn.png" />">
								</div>
							</li>
							<!-- expanded surplus -->
							<li class="expanded">
								<div class="zoneGroups_ExpandedView">
									<form action="">
										<table>
											<tr>
												<td>id</td>
												<td><input type="text" value="${surplus.id}"></td>
											</tr>
											<tr>
												<td>name</td>
												<td><input type="text" value="${surplus.name}"></td>
											</tr>
											<tr>
												<td>group</td>
												<td><input type="text" value="TODO//parent group"></td>
											</tr>
										</table>
										<input class="accepth_changes_btn" type="image"
											src="<c:url value="/resources/img/done_btn.png" />">
									</form>
								</div>
							</li>
							<!--END expanded surplus -->
						</c:forEach>
						</ul>
				</c:forEach>

</ul>
				<!--END OUTPUT Surplus -->
				<c:set var="zhd" value="${zhd}" scope="request" />
				<jsp:include page="node.jsp" />
			</c:forEach>
		 </ul>
	</div>
</body>
</html>