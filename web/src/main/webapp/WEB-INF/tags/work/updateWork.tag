<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="work" required="true" type="ua.ksstroy.logic.work.WorkData" %>

<spring:url value="/resources/img/done_btn.png" var="done_btn"/>

<div class="controller hidden">
    <div class="controller_name">UPDATE WORK</div>
    <form action="${pageContext.request.contextPath}/projects/updateWork" method="post">
        <input type="hidden" name="id" value="${work.id}">
        <input type="hidden" name="projectId" value="${projectId}">
        <table>
            <tbody>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="${work.name}"></td>
            </tr>
                      <tr>
                <td>work type:</td>
                <td>
                    <form method="post">
                        <select name="workTypeId">
                            <c:forEach var="workType" items="${workType.workTypeGroupsData}">

                                <c:forEach var="wortTypeData" items="${workType.workTypesData}">
                                    <c:choose>
                                        <c:when test="${wortTypeData.name == work.type.name}">
                                    <option selected value="${wortTypeData.id}" >${wortTypeData.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${wortTypeData.id}" >${wortTypeData.name}</option>
                                        </c:otherwise>
                                    </c:choose>


                                </c:forEach>

                            </c:forEach>

                            <c:if test="${wortTypeData.name == work.type.name}">


                            </c:if>
                        </select>
                    </form>
                </td>
            </tr>
            <tr>
                <td>planedCost:</td>
                <td><input type="text" name="planedCost" value="${work.planedCost}"></td>
            </tr>
          <%-- //TODO delete or implement in future  <tr>
                <td>perspectiveCost:</td>
                <td><input type="text" name="perspectiveCost" value="${work.perspectiveCost}"></td>
            </tr>
            <tr>
                <td>closedCost:</td>
                <td><input type="text" name="closedCost" value="${work.closedCost}"></td>
            </tr>
            <tr>
                <td>dealCost:</td>
                <td><input type="text" name="dealCost" value="${work.dealCost}"></td>
            </tr>--%>


            <tr>
                <td>zone:</td>
                <td>
                    <form method="post">
                        <select name="zoneId">
                            <c:forEach var="zone" items="${zone.groups}">

                                <c:forEach var="zoneData" items="${zone.zones}">
                                    <option value="${zoneData.id}">${zoneData.name}</option>
                                </c:forEach>

                            </c:forEach>
                        </select>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
        <input class="accepth_changes_btn" type="image" src="${done_btn}">
    </form>
</div>