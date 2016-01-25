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
        <th></th>
        <th>Name</th>
        <th>Price for unit</th>
        <th>Need</th>
        <th>Purchased</th>
        <th>Balance</th>
        <th>Planed cost</th>
        <th>Purchased cost</th>
        <th>Money balance</th>
    </tr>

    <tr>
        <td>1</td>
        <td>Shtukaturka</td>
        <td>14</td>
        <td>80</td>
        <td>70</td>
        <td>-10</td>
        <td>1120</td>
        <td>980</td>
        <td>-140</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Shpaklevka</td>
        <td>14</td>
        <td>80</td>
        <td>70</td>
        <td>-10</td>
        <td>1120</td>
        <td>980</td>
        <td>-140</td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>Total</td>
        <td>2240</td>
        <td>1960</td>
        <td>-280</td>
    </tr>

</table>