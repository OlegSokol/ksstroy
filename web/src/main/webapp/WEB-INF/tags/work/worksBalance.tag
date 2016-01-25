<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<table id="works-balance" border="1">
  <tbody><tr>
    <th></th>
    <th>WorkGroup</th>
    <th>WorkName</th>
    <th>Worktype</th>
    <th>Price per zone unit</th>
    <th>Total units</th>
    <th>TotalPlanedPrice</th>
  </tr>

  <tr>
    <td>1</td>
    <td>ELEKTRIKA</td>
    <td>stroblenie kirpich</td>
    <td>stroblenie kirpich</td>
    <td>70</td>
    <td>150m2</td>
    <td>15000grn</td>

  </tr>
  <tr>
    <td>2</td>
    <td>ELEKTRIKA</td>
    <td>zavod vxodnogo provoda</td>
    <td>zavod vxodnogo provoda</td>
    <td>80</td>
    <td>10</td>
    <td>1120grn</td>

  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>Total</td>
    <td>16120grn</td>

  </tr>

  </tbody></table>