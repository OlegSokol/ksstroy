<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project</title>

<script
	src="<c:url value="https://code.jquery.com/jquery-1.10.2.min.js" />"></script>

<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" />"></script>


<spring:url value="/resources/css/mainStyle.css" var="css" />
<link href="${css}" rel="stylesheet" />

<!--<spring:url value="/resources/js/mainScript.js" var="js" />
<script src="${js}"></script>-->

</head>
<body>
	<div id="wraper">

		<zone:node zhd="${zhd}" />

	</div>
	<!-- END OF WRAPER -->
</body>
</html>