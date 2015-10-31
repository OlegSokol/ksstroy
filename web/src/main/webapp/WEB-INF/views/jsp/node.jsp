<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="zoneHierarchiDataTree">
		<ul>
		<!--ROOT GROOP  -->
		<li>
		<div class="zoneGroups_basicView">
						<svg class="clickableIcon" xmlns="http://www.w3.org/2000/svg"
							fill="#5E5C5B" height="20px" viewBox="0 0 20 20" width="20px">
						<path d="M7 10l5 5 5-5z" /> <path d="M0 0h24v24H0z" fill="none" />
						</svg>
						
						${zhd.name}

						<div class="add_delete_wrapper hide">
							<svg class="delete_btn" xmlns="http://www.w3.org/2000/svg"
								fill="#5E5C5B" height="20px" viewBox="0 0 24 24" width="20px">
							<path class="delete_kostul"
								d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z" />
							<path d="M0 0h24v24H0z" fill="none" /> </svg>
							<div class="add_btn">
								<svg class="add_kostul" xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
									id="Layer_1" x="0px" y="0px" width="20px" height="20px"
									viewBox="0 0 36 36" enable-background="new 0 0 36 36"
									xml:space="preserve"> <path fill="#5E5C5B"
									d="M28.5,4.5h-21c-1.665,0-3,1.35-3,3v21c0,1.65,1.335,3,3,3h21c1.65,0,3-1.35,3-3v-21  C31.5,5.85,30.15,4.5,28.5,4.5z M25.5,19.5h-6v6h-3v-6h-6v-3h6v-6h3v6h6V19.5z"></path>
								<path fill="none" d="M0,0h36v36H0V0z"></path> </svg>
							</div>
						</div>

					</div>
		
		</li>
<!-- END ROOT GROOP  -->
		<c:forEach var="zhd" items="${zhd.groups}">
				<!-- OUTPUT ZHD groups<ZoneHierarchiData> -->

				<li>
					<div class="zoneGroups_basicView">
						<svg class="clickableIcon" xmlns="http://www.w3.org/2000/svg"
							fill="#5E5C5B" height="20px" viewBox="0 0 20 20" width="20px">
						<path d="M7 10l5 5 5-5z" /> <path d="M0 0h24v24H0z" fill="none" />
						</svg>
						
						${zhd.name}

						<div class="add_delete_wrapper hide">
							<svg class="delete_btn" xmlns="http://www.w3.org/2000/svg"
								fill="#5E5C5B" height="20px" viewBox="0 0 24 24" width="20px">
							<path class="delete_kostul"
								d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z" />
							<path d="M0 0h24v24H0z" fill="none" /> </svg>
							<div class="add_btn">
								<svg class="add_kostul" xmlns="http://www.w3.org/2000/svg"
									xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
									id="Layer_1" x="0px" y="0px" width="20px" height="20px"
									viewBox="0 0 36 36" enable-background="new 0 0 36 36"
									xml:space="preserve"> <path fill="#5E5C5B"
									d="M28.5,4.5h-21c-1.665,0-3,1.35-3,3v21c0,1.65,1.335,3,3,3h21c1.65,0,3-1.35,3-3v-21  C31.5,5.85,30.15,4.5,28.5,4.5z M25.5,19.5h-6v6h-3v-6h-6v-3h6v-6h3v6h6V19.5z"></path>
								<path fill="none" d="M0,0h36v36H0V0z"></path> </svg>
							</div>
						</div>

					</div>
				</li>
				<!-- expanded zoneGroup -->

				<!--groups CONSTRUCTOR-->
				<li class="constructor">
					<div class="zoneGroups_ExpandedView">
						<form action="addGroupToGroup" method="post">
							<table>
								<span class="constructorTitle">NEW GROUP</span>
								<tr>
									<td>name</td>
									<td><input type="text" name="groupName"
										placeholder="TODO//validate"></td>
								</tr>
								<tr>
									<td>parent groupId</td>
									<td><input type="hidden" name="parentGroupId"
										value="${zhd.id}"></td>
							</table>
							<input class="accepth_changes_btn" type="image"
								src="<c:url value="/resources/img/done_btn.png" />"> <input
								type="hidden" name="projectId" value="${projectName}">
						</form>
					</div>
				</li>

				<!--END expanded Zones -->

				<!--END  groups  constructor -->

				<!--Zones CONSTRUCTOR  IF GROUP DOESNT HAVE ZONES-->
				<li class="constructor">
					<div class="zoneGroups_ExpandedView">
						<form action="addZone" method="post">
							<table>
								<span class="constructorTitle">NEW ZONE</span>
								<tr>
									<td>name</td>
									<td><input type="text" name="name"
										placeholder="TODO//validate"></td>
								</tr>
								<tr>
									<td>parent groupId</td>
									<td><input type="hidden" name="parentGroupId"
										value="${zhd.id}"></td>
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
									<td><input type="text" placeholder="TODO//=height*weight"></td>
								</tr>
								<!-- value calculation only for usability! server side should calculate it itself -->
							</table>
							<input class="accepth_changes_btn" type="image"
								src="<c:url value="/resources/img/done_btn.png" />">
						</form>
					</div>
				</li>

				<!--END  Zones<ZoneData> constructor -->

				<li class="expanded">
					<div class="zoneGroups_ExpandedView">
						<form action="">
							<table>
								<tr>
									<td>id</td>
									<td><input type="hidden" name="id" value="${zhd.id}"></td>
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
							<label class="accepth_changes_btn"> <input type="submit"
								name="image" style="display: none"> <svg
									xmlns="http://www.w3.org/2000/svg" fill="#5E5C5B" height="20"
									viewBox="0 0 20 20" width="20"> <path d="M0 0h24v24H0z"
									fill="none" /> <path
									d="M9 16.17L4.83 12l-1.42 1.41L9 19 21 7l-1.41-1.41z" /> </svg>
							</label>
						</form>
					</div>
				</li>

				<!--END expanded zoneGroup -->
				<!--END OUTPUT ZHD groups<ZoneHierarchiData> -->

				<!-- OUTPUT zones<ZoneData> -->

				<zone:subGroups zhd="${zhd}" />
				<c:set var="zhd" value="${zhd}" scope="request" />
				<jsp:include page="node.jsp" />
			</c:forEach>
		</ul>
	</div>
</body>
</html>