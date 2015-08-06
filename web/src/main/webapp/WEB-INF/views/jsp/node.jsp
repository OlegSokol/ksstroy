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
		<c:forEach var="zhd" items="${zhd.groups}">
			<!-- OUTPUT ZHD groups<ZoneHierarchiData> -->
			<ul>
				<div class="zoneGroups_basicView">
					<li><img class="clickableIcon" alt="expand-collapse_btn"
						src="<c:url value="/resources/img/expand_down.png" />">
						${zhd.name} <img class="clickableIcon delete_btn" alt="delete_btn"
						src="<c:url value="/resources/img/delete_btn.png" />"></li>
				</div>
				<!-- expanded zoneGroup -->
				<li>
					<div class="zoneGroups_basicView zoneGroups_ExpandedView">
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
							<input class="accepth_changes_btn clickableIcon" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>
				<!--END expanded zoneGroup -->
				<ul>
					<!--END OUTPUT ZHD groups<ZoneHierarchiData> -->
					<!-- OUTPUT zones<ZoneData> -->
					<c:forEach var="zones" items="${zhd.zones}">

						<div class="zoneGroups_basicView zones_basicView  ">
							<li><img class="clickableIcon" alt="expand-collapse_btn"
								src="<c:url value="/resources/img/expand_down.png" />">
								${zones.name} <img class="clickableIcon delete_btn"
								alt="delete_btn"
								src="<c:url value="/resources/img/delete_btn.png" />"></li>
						</div>
						<!-- expanded Zones -->
				<li>
					<div class="zoneGroups_ExpandedView zoneGroups_basicView">
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
							<input class="accepth_changes_btn clickableIcon" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>
				<!--END expanded Zones -->
						
						<!--END OUTPUT Zones<ZoneData> -->
						<c:forEach var="additional" items="${zones.additional}">
							<!-- OUTPUT additional -->
							<div class="zoneGroups_basicView additional_basicView ">
							<li><img class="clickableIcon" alt="expand-collapse_btn"
								src="<c:url value="/resources/img/expand_down.png" />">
								+ ${additional.name} <img class="clickableIcon delete_btn"
								alt="delete_btn"
								src="<c:url value="/resources/img/delete_btn.png" />"></li>
						</div>
						<li>
						<!-- expanded Additional -->
					<div class="zoneGroups_ExpandedView zoneGroups_basicView additional_basicView">
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
							<input class="accepth_changes_btn clickableIcon" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>
						<!--END expanded Additional -->
						<!--END OUTPUT additional -->
						
						<!-- OUTPUT Surplus -->
						</c:forEach>
						<c:forEach var="surplus" items="${zones.surplus}">
							<ul>
								<ul> 
								
									<div class="zoneGroups_basicView additional_basicView ">
							<li><img class="clickableIcon" alt="expand-collapse_btn"
								src="<c:url value="/resources/img/expand_down.png" />">
								- ${surplus.name} <img class="clickableIcon delete_btn"
								alt="delete_btn"
								src="<c:url value="/resources/img/delete_btn.png" />"></li>
						</div>
						<!-- expanded surplus -->
							<li>
					<div class="zoneGroups_ExpandedView zoneGroups_basicView additional_basicView">
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
							<input class="accepth_changes_btn clickableIcon" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>
						
						
								
																	
									
								</ul>
							</ul>
						<!--END expanded surplus -->
						</c:forEach>



					</c:forEach>
				</ul>
			</ul>
						<!--END OUTPUT Surplus -->
			<c:set var="zhd" value="${zhd}" scope="request" />
			<jsp:include page="node.jsp" />
		</c:forEach>
	</div>
</body>
</html>