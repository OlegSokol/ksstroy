<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="material" tagdir="/WEB-INF/tags/material" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    <ul id="workTypeDataTree">
        <ul class="initializers">
            <material:addMaterial materialTypeData="${materialObject}"/>
            <material:addMaterialType innerMaterialTypeData="${materialObject}"/>
        </ul>

        <material:node materialTypeData="${materialObject}"/>
    </ul>
</div>
</body>
</html>