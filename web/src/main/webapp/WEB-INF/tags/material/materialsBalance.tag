<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="material" tagdir="/WEB-INF/tags/material" %>

<%@attribute name="materialsList" type="java.util.List" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<table border="1">
    <tr>
        <th>№</th>
        <th>тип</th>
        <th>наименование</th>
        <th>цена</th>
        <th>надо</th>
        <th>склад</th>
        <th>планируемая стоимость</th>
        <th>потрачено</th>
    </tr>
    <c:forEach var="material" items="${materialsList}">
        <tr>
            <td>${material.id}</td>
            <td>Шкаклевки(мок)</td>
            <td>${material.materialType.name}</td>
            <td>${material.materialType.pricePerUnit} грн/шт</td>
            <td>32шт</td>
            <td>15шт</td>
           <%--TODO looks redundant <td>${material.unitsPerWorkZoneMeasure}</td>--%>
            <td>${material.planedCost} грн</td>
            <td>253грн</td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>ИТОГО</td>
        <td>10500грн</td>
        <td>10110грн</td>
            </tr>

</table>