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
		</div>
		control: expand all -double click<br> show details- click on
		element <br>
		<!-- END OF START_DATA-->

		<div class="redactor_btn">redactor mode</div>


		<!-- getRootZoneHierarchy(String projectId) -->
		<form action="getRootZoneHierarchy" method="post">
			<input name="projectId" type="text"> <input type="submit"
				value="getRootZoneHierarchy(String projectId)">
		</form>
		<!-- getRootZoneHierarchy(String projectId) -->



		<!-- addGroupToGroup(String groupName, String parentGroupId) -->
		<form action="addGroupToGroup" method="post">
			<input type="text" name="groupName"> <input type="text"
				name="parentGroupId"> <input type="submit"
				value="addGroupToGroup(String groupName, String parentGroupId)">
		</form>
		<!-- addGroupToGroup(String groupName, String parentGroupId) -->


		<!-- addZone(ZoneData zone, String parentGroupId) -->
		<form action="addZone" method="post">
			<input type="text" name="zone"> <input type="text"
				name="parentGroupId"> <input type="submit"
				value="addZone(ZoneData zone, String parentGroupId)">
		</form>
		<!-- addZone(ZoneData zone, String parentGroupId) -->


		<!-- addZoneToZone(ZoneData zone, String parentZoneId) -->
		<form action="addZoneToZone" method="post">
			<input type="text" name="zone"> <input type="text"
				name="parentZoneId"> <input type="submit"
				value="addZoneToZone(ZoneData zone, String parentZoneId)">
		</form>
		<!-- addZoneToZone(ZoneData zone, String parentZoneId) -->


		<!-- subtractZoneFromZone(ZoneData zone, String parentZoneId) -->
		<form action="subtractZoneFromZone" method="post">
			<input type="text" name="zone"> <input type="text"
				name="parentZoneId"> <input type="submit"
				value="subtractZoneFromZone(ZoneData zone, String parentZoneId)">
		</form>
		<!-- subtractZoneFromZone(ZoneData zone, String parentZoneId) -->


		<jsp:include page="node.jsp" />


		<!-- CREATE NEW ELEMENT PANEL -->

		<div id="constructor">
			<!-- zone groups constructor -->


			<li>
				<div class="zones_basicView  ">
					<img class="clickableIcon" alt="expand-collapse_btn"
						src="<c:url value="/resources/img/expand_down.png" />"> New
					group <img class="delete_btn" alt="delete_btn"
						src="<c:url value="/resources/img/delete_btn.png" />">
				</div>
			</li>
			<!-- expanded Groups -->



			<li class="expanded">
				<div class="zoneGroups_ExpandedView">
					<form action="addGroupToGroup" method="post">
						<table>
							<tr>
								<td>id</td>
								<td><input type="text" name="groupName"
									placeholder="TODO// automatic generate"></td>
							</tr>
							<tr>
								<td>name</td>
								<td><input type="text"></td>
							</tr>
							<tr>
								<td>parent groupId</td>
								<td><input type="text" name="parentGroupId"
									placeholder="TODO//parent group"></td>
							</tr>
						</table>
						<input class="accepth_changes_btn" type="image"
							src="<c:url value="/resources/img/done_btn.png" />">
					</form>
				</div>
			</li>
			<!--END zone groups constructor -->


			<!--  zones<ZoneData> constructor -->
			<li>
				<div class="zones_basicView  ">
					<img class="clickableIcon" alt="expand-collapse_btn"
						src="<c:url value="/resources/img/expand_down.png" />"> new
					Zone <img class="delete_btn" alt="delete_btn"
						src="<c:url value="/resources/img/delete_btn.png" />">
				</div>
			</li>
			<!-- expanded Zones -->

			<li class="expanded">
				<div class="zoneGroups_ExpandedView">
					<form action="addZone" method="post">
						<table>
					<tr>
								<td>id</td>
								<td><input type="text" name="id" placeholder="TODO// automatic generate"></td>
							</tr>
							<tr>
								<td>name</td>
								<td><input type="text" name="name" placeholder="TODO//validate"></td>
							</tr>
							<tr>
								<td>parent groupId</td>
								<td><input type="text" name="parentGroupId" placeholder="TODO//validation"></td>
							</tr>
                              
                              	<tr>
								<td>measureName</td>
								<td><input type="text" name="measureName" placeholder="TODO//autocomplete"></td>
							</tr>
                              	<tr>
								<td>width</td>
								<td><input type="text" name="width" placeholder="TODO//append measure"></td>
							</tr>
                              
                              
                              	<tr>
								<td>height</td>
								<td><input type="text" name="heigh" placeholder="TODO//append measure"></td>
							</tr>

  <!-- value calculation only for usability! server side should calculate it itself -->
                              	<tr>
								<td>value</td>
								<td><input type="text"  placeholder="TODO//=height*weight"></td>
							</tr>
							 <!-- value calculation only for usability! server side should calculate it itself -->
						</table>
						<input class="accepth_changes_btn" type="image"
							src="<c:url value="/resources/img/done_btn.png" />">
					</form>
				</div>
			</li>

			<!--END expanded Zones -->

			<!--END  Zones<ZoneData> constructor -->
			<li>
				<!--  additional constructor -->
				<div class="zones_basicView">
					<img class="clickableIcon" alt="expand-collapse_btn"
						src="<c:url value="/resources/img/expand_down.png" />"> +
					new additional <img class="delete_btn" alt="delete_btn"
						src="<c:url value="/resources/img/delete_btn.png" />">
				</div>
			</li>

			<li class="expanded">
				<!-- expanded Additional -->

				<div class="zoneGroups_ExpandedView ">
					<form action="addZoneToZone" method="post">
							<table>
					<tr>
								<td>id</td>
								<td><input type="text" name="id" placeholder="TODO// automatic generate"></td>
							</tr>
							<tr>
								<td>name</td>
								<td><input type="text" name="name" placeholder="TODO//validate"></td>
							</tr>
							<tr>
								<td>parent zoneId</td>
								<td><input type="text" name="parentZoneId" placeholder="TODO//validation"></td>
							</tr>
                              
                              	<tr>
								<td>measureName</td>
								<td><input type="text" name="measureName" placeholder="TODO//autocomplete"></td>
							</tr>
                              	<tr>
								<td>width</td>
								<td><input type="text" name="width" placeholder="TODO//append measure"></td>
							</tr>
                              
                              
                              	<tr>
								<td>height</td>
								<td><input type="text" name="heigh" placeholder="TODO//append measure"></td>
							</tr>

  <!-- value calculation only for usability! server side should calculate it itself -->
                              	<tr>
								<td>value</td>
								<td><input type="text"  placeholder="TODO//=height*weight"></td>
							</tr>
							 <!-- value calculation only for usability! server side should calculate it itself -->
						</table>
						<input class="accepth_changes_btn" type="image"
							src="<c:url value="/resources/img/done_btn.png" />">
					</form>
				</div>
			</li>
			<!--END expanded Additional -->
			<!--END  additional  constructor-->

			<li>
				<div class="zones_basicView">
					<img class="clickableIcon" alt="expand-collapse_btn"
						src="<c:url value="/resources/img/expand_down.png" />"> -
					new surplus <img class="delete_btn" alt="delete_btn"
						src="<c:url value="/resources/img/delete_btn.png" />">
				</div>
			</li>
			<!-- expanded surplus -->


			<li class="expanded">
				<div class="zoneGroups_ExpandedView">
					<form action="subtractZoneFromZone" method="post">
						<table>
							<tr>
								<td>id</td>
								<td><input type="text"
									placeholder="TODO//automatic generate"></td>
							</tr>
							<tr>
								<td>name</td>
								<td><input type="text" name="zone"></td>
							</tr>
							<tr>
								<td>parent zoneId</td>
								<td><input type="text" name="parentZoneId"
									placeholder="TODO//parent group"></td>
							</tr>
						</table>
						<input class="accepth_changes_btn" type="image"
							src="<c:url value="/resources/img/done_btn.png" />">
					</form>
				</div>
			</li>





		</div>
		<!-- END CREATE NEW ELEMENT PANEL -->


		<script type="text/javascript">
			$(document).ready(function() {
				//show expanded form on double click
				$('li').dblclick(function() {

					console.log($(this));
					var clickedID = this.id;
					var next = $(this).next();
					console.log(next.hasClass("expanded"));
					if (next.hasClass("expanded"))
						next.toggle();
				});

				//	console.log($( ".clickableIcon" ).closest( ".subGroups" )[0]);
				//toggle elements under speciyed group
				/*			$( document ).on( "dblclick", function( event ) {
								console.log($(".clickableIcon").closest( ".subGroups" ));
				  $( ".clickableIcon").closest( ".subGroups" ).toggle();
				});*/

				//set default state of elements to hide;
				$("#constructor").toggle();
				$("input").attr('disabled', 'disabled');

				//redactor button
				$('.redactor_btn').click(function() {
					console.log($(this).attr("class"));
					//redactor mode activated: show controll elements
					$(this).toggleClass("redactor_btn_clicked");
					$("#constructor, .delete_btn").toggle();
					if (!$("input").attr("disabled")) {
						//toggle input to disabled state
						$("input").attr('disabled', 'disabled');
					} else {
						$("input").removeAttr('disabled');
					}
				});

				console.log("ready!");

			});

			//show subgroups icon only if has subroups

			var clickable = document.getElementsByClassName("clickableIcon");
			//console.log(clickable);

			var arrayLength = clickable.length;
			//console.log(arrayLength);
			for (var i = 0; i < arrayLength; i++) {
				//console.log(clickable[i]);

				try {
					if (((clickable[i]).parentNode.parentNode.nextElementSibling.nextElementSibling.className) == "subGroups") {
						//console.log(clickable[i]);
						//console.log(clickable[i].parentNode.parentNode.nextElementSibling.nextElementSibling);
						//console.log($(clickable[i]));
						$(clickable[i]).toggle();
						//.nextElementSibling.nextElementSibling
					}
				} catch (err) {
					//console.log(err);
				}
				try{
				if (((clickable[i]).parentNode.parentNode.nextElementSibling.nextElementSibling.className) == "subZones") {
					console
							.log((clickable[i]).parentNode.parentNode.nextElementSibling.nextElementSibling.className);
					console.log(clickable[i]);
					$(clickable[i]).toggle();
				}
				}
				catch (err) {
					//console.log(err);
				}
				//Do something
			}//

			// end show subgroups icon only if has subroups

			//hide subgroup element on click
			document.onclick = function(event) {
				if (event.target.getAttribute("class") == "clickableIcon") {
					console.log(event.target);
					var target = event.target;
					console
							.log(target.parentNode.parentNode.nextElementSibling.nextElementSibling);
					var subGroups = target.parentNode.parentNode.nextElementSibling.nextElementSibling;
					$(subGroups).toggle();//mix some Jquery
				}
				//end hide subgroup element on click
			};
			
			
			
		</script>
	</div>
	<!-- END OF WRAPER -->
</body>
</html>