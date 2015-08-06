<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project</title>

<!-- BOOTSTRAP -->
<script
	src="<c:url value="https://code.jquery.com/jquery-1.10.2.min.js" />"></script>

<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/bootswatch.js" />"></script>


<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" />"></script>


<link href="<c:url value="/resources/css/bootswatch.min.css" />"
	rel="stylesheet">
<link media="screen"
	href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<!--END BOOTSTRAP -->


<!-- CUSTOM STYLING -->



<spring:url value="/resources/css/mainStyle.css" var="css" />
<link href="${css}" rel="stylesheet" />
<spring:url value="/resources/js/mainScript.js" var="js" />
<script src="${js}"></script>
<!--END CUSTOM STYLING -->

</head>
<body>
	<div id="wraper">

		<div id="customer_start_data">
			<div class="info_block">
				<div class="panel panel-default">
					<div class="panel-heading">Customer</div>
					<div class="panel-body">Customer FIO</div>
				</div>
				<!-- END OF INFO BLOCK -->
			</div>
			<!-- END OF CUSTOMER -->
			<div class="control_block" id="start_data">
				<h4 class="block_title">Start data</h4>
				<img class="adjust_icon" alt="view_icon"
					src="<c:url value="/resources/img/ic_settings_grey600_24dp.png" />" /><br>
				<a class="view_icon" href="./start_data_view"> <img
					alt="view_icon"
					src="<c:url value="/resources/img/ic_eye_black_24dp.png" />" />
				</a>
			</div>
		</div>
		<br>
		<!-- END OF START_DATA-->


		<!-- POP UP ZONES -->
		<div id="zones_popup">

			<ul>
				<li>
					<div class="control_block" id="start_data">
						<h4 class="block_title">${zoneGraph.name}</h4>
						<a class="adjust_icon" href="./start_data_adjust"><img
							alt="view_icon"
							src="<c:url value="/resources/img/ic_settings_grey600_24dp.png" />" /></a><br>
						<a class="view_icon" href="./start_data_view"> <img
							alt="view_icon"
							src="<c:url value="/resources/img/ic_eye_black_24dp.png" />" />
						</a>
					</div>
				</li>

			</ul>
		</div>
	
	




<form action="formTest" method="post">
<input type="submit" value="void form test ">
</form>

<!-- getRootZoneHierarchy(String projectId) -->
<form action="getRootZoneHierarchy" method="post">
<input name="projectId" type="text" >
<input type="submit" value="getRootZoneHierarchy(String projectId)">
</form>
<!-- getRootZoneHierarchy(String projectId) -->



<!-- addGroupToGroup(String groupName, String parentGroupId) -->
<form action="addGroupToGroup" method="post">
<input type="text" name="groupName">
<input type="text" name="parentGroupId">
<input type="submit" value="addGroupToGroup(String groupName, String parentGroupId)">
</form>
<!-- addGroupToGroup(String groupName, String parentGroupId) -->


<!-- addZone(ZoneData zone, String parentGroupId) -->
<form action="addZone" method="post">
<input type="text" name="zone">
<input type="text" name="parentGroupId">
<input type="submit" value="addZone(ZoneData zone, String parentGroupId)">
</form>
<!-- addZone(ZoneData zone, String parentGroupId) -->


<!-- addZoneToZone(ZoneData zone, String parentZoneId) -->
<form action="addZoneToZone" method="post">
<input type="text" name="zone">
<input type="text" name="parentZoneId">
<input type="submit" value="addZoneToZone(ZoneData zone, String parentZoneId)">
</form>
<!-- addZoneToZone(ZoneData zone, String parentZoneId) -->


<!-- subtractZoneFromZone(ZoneData zone, String parentZoneId) -->
<form action="subtractZoneFromZone" method="post">
<input type="text" name="zone">
<input type="text" name="parentZoneId">
<input type="submit" value="subtractZoneFromZone(ZoneData zone, String parentZoneId)">
</form>
<!-- subtractZoneFromZone(ZoneData zone, String parentZoneId) -->


<jsp:include page="node.jsp"/>

		<script>
			//show- hide zones list
			$(document).ready(function() {
				$("#start_data .adjust_icon").click(function() {
					$("#zones_popup ").toggle("slide", 1000);
				});
				//show- hide zones list

			});//end ready function()
		</script>
	</div>
	<!-- END OF WRAPER -->
</body>
</html>