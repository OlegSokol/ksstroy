<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ attribute name="workTypchikList" required="true" type="java.util.List" %><%@ taglib prefix="worktype" tagdir="/WEB-INF/tags/worktype" %><spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/><spring:url value="/resources/img/add_btn.png" var="add_btn"/><spring:url value="/resources/img/delete_btn.png" var="delete_btn"/><c:forEach var="workType" items="${workTypchikList}">    <ul>        <div class="item">            <img class="clickableIcon" src="${arrow_drop_down}" alt="Arrow">                ${workType.name}            <div class="add_delete_wrapper">                <div class="delete_btn">                    <form action="${pageContext.request.contextPath}/workType/removeWorkType" method="post">                        <input type="hidden" name="projectId" value="${projectId}">                        <input type="hidden" name="id" value="${workType.id}">                        <input type="image" src="${delete_btn}" alt="Delete">                    </form>                </div>                <div class="add_btn">                    <img src="${add_btn}" alt="Add">                </div>            </div>        </div>        <worktype:updateWorkType workType="${workType}"/>    </ul></c:forEach>