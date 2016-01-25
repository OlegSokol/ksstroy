<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="material" tagdir="/WEB-INF/tags/material" %>
<html>
<head>
  <title>materials</title>
  <spring:url value="/resources/css/mainStyle.css" var="commonCss"/>
  <link href="${commonCss}" rel="stylesheet"/>

  <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
  <script src="${jQuery}"></script>
  <spring:url value="/resources/js/mainScript.js" var="js"/>
  <script src="${js}"></script>
</head>
<body>
<jsp:include page="single_project_menu.jsp"/>

<ul >
<%--  <material: materialsList="${MaterialsList}"/>--%>
</ul>

<div align="center">
    <h2>MATERIALS</h2>
    <jsp:include page="libraries_sidebar.jsp"/>
    <material:materialsBalance materialsList="${MaterialsList}"/>


</div>
</body>
</html>