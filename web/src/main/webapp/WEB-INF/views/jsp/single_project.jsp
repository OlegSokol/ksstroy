<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>project</title>
    <spring:url value="/resources/css/mainStyle.css" var="commonCss"/>
    <link href="${commonCss}" rel="stylesheet"/>
    <spring:url value="/resources/css/project.css" var="customCss"/>
    <link href="${customCss}" rel="stylesheet"/>

    <spring:url value="/resources/js/jquery-2.1.4.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    <spring:url value="/resources/js/mainScript.js" var="js"/>
    <script src="${js}"></script>
</head>
<body>
<div id="wraper">
    user: ${userName}<br>
    project:${projectName}
    <header>

        <a class="menu_item" href="${projectId}/zones">Zones</a>

        <a class="menu_item" href="${projectId}/work">
            Work(new!!!)
            <table>
                <tbody>
                <tr>
                    <td>total price:</td>
                    <td>250$</td>
                </tr>
                </tbody>
            </table>
        </a>


        <a class="menu_item" href="${projectId}/materials">
            Material Stock
        </a>


    </header>


    <ul class="library">
        <h4>LIBRARY</h4>
        <li>
            <div>
                <a class="menu_item" href="${projectId}/workType">WorkTypes</a>
            </div>
        </li>
        <li>
            <div>
                <a class="menu_item" href="${projectId}/library_materials">Materials</a>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
