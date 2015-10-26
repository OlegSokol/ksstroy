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

<!--
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
-->

<!-- CUSTOM STYLING -->

<spring:url value="/resources/css/mainStyle.css" var="css" />
<link href="${css}" rel="stylesheet" />
<!--
<spring:url value="/resources/js/mainScript.js" var="js" />
<script src="${js}"></script>
-->
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
		<div>
			SHOW DETAILS - DOUBLE CLICK ON ELEMENT<br> REDACT ELEMENTS -
			CLICK ON REDACTOR MODE BUTTON AND NEXT ADD ICON ON ELEMENT<br>
		</div>
		<div class="redactor_btn">redactor mode</div>
		<br>
		<!-- END OF START_DATA-->


		<p>Test forms for invoke ZoneManager methods</p>

		<form action="/web/projects/addZone" method="POST">
			<input name="name" type="text" value="CreatedNewZone"> <input
				name="parentGroupId" type="text" value="4"> <input
				name="measureName" type="text" value="M2"> <input
				name="width" type="text" value="123"> <input name="heigh"
				type="text" value="123.0"> <input type="submit"
				value="Add Zone">
		</form>

		<form action="/web/projects/addGroupToGroup" method="POST">
			<input name="groupName" type="text" value="CreatedSubGroup"> <input
				name="parentGroupId" type="text" value="1"> <input
				type="submit" value="Add SubGroup">
		</form>

		<jsp:include page="node.jsp" />

		<script type="text/javascript">
			$(document).ready(
					function() {

						//FOR TEST PURPOSES ONLY
						$(".expanded").toggle();
						$(".constructor").toggle();

						$("input").prop('disabled', true);

						//show expande icon if zoneGroup contain zones
						//and hide subGroups
						$.each($(".zoneGroups_basicView"), function(index,
								value) {
							if ($(this).closest("li").siblings("ul").first()
									.hasClass("subGroups")) {
								$(this).find(".clickableIcon").toggle();
								$(this).closest("li").nextAll("ul").first()
										.toggle();
							}
						})

						//show expande icon if zone contain additional and surplus zones
						//and hide subGroups
						$.each($(".zones_basicView"), function(index, value) {
							if ($(this).closest("li").siblings("ul").first()
									.hasClass("subZones")) {
								$(this).find(".clickableIcon").toggle();
								$(this).closest("li").nextAll("ul").first()
										.toggle();
							}
						})

						//ONCLICK HANDLERS AND ETC.
						//hide sub groups or zones on click
						$(".clickableIcon").click(
								function(event) {
									$(event.target).closest("li").nextAll("ul")
											.first().toggle();
								});

						//show details on double click
						$(".zoneGroups_basicView,.zones_basicView").dblclick(
								function(event) {
									$(event.target).closest("li").nextAll(
											".expanded").first().toggle();
								});

						//toggle redactor mode on click
						$(".redactor_btn").click(
								function(event) {
									$(event.target).toggleClass(
											"redactor_btn_clicked");
									if ($("input").prop('disabled')) {
										$("input").prop('disabled', false);
									} else {
										$("input").prop('disabled', true);
									}
									$(".add_delete_wrapper")
											.toggleClass("hide");
								});
						//show constructor on click
						$(".add_kostul").click(
								function(event) {
									$(event.target).closest("li").nextUntil(
											".expanded", ".constructor")
											.toggle();
								});

					});
		</script>
	</div>
	<!-- END OF WRAPER -->
</body>
</html>