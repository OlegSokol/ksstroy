<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>project</title>

    <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>

    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script type="text/javascript" src="${js}"></script>
</head>
<body>
<div id="wrapper">
    <ul class="initializers">
        <group:addGroup zhd ="${zhd}"/>
        <group:addZone zhd ="${zhd}"/>
    </ul>
    <zone:node zhd="${zhd}"/>
</div>
</body>
</html>