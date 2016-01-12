<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>ua.ksstroy</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <spring:url value="/resources/css/mainStyle.css" var="css"/>
    <link href="${css}" rel="stylesheet"/>
        <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    <div>
        <h2>KS STROY PROJECT</h2>

        <p>
            Enterprise resource planning (ERP) is a category of business management software. Typically a suite of integrated applications
            ,that an organization can use to collect, store, manage and interpret data from many
            business activities, including:
            product planning, cost
            manufacturing or service delivery
            marketing and sales
            inventory management
            shipping and payment
        </p>
        <p>
            KsStroy is a domain specific ERP for building.
        </p>

        <p>
            <a href="./users_projects" id="ref">Users with projects</a>
        </p>
    </div>
</div>
</body>
</html>