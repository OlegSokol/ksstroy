<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone"%>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down" />
<spring:url value="/resources/img/add_btn.png" var="add_btn" />
<spring:url value="/resources/img/delete_btn.png" var="delete_btn" />
<spring:url value="/resources/img/done_btn.png" var="done_btn" />
</head>
<body>
	<div id="wraper">
		<div id="zoneHierarchiDataTree">
	
            <group:groups zhd="${zhd}" />
          
			<c:forEach var="zhd" items="${zhd.groups}">
				<c:set var="zhd" value="${zhd}" scope="request" />
				<jsp:include page="node.jsp" />
				<zone:zonesWithAdditionalAndSurplus zhd="${zhd}" />
			</c:forEach>

		</div>
	</div>
</body>
</html>