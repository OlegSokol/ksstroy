<%@tag pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true"
              type="ua.ksstroy.logic.zone.ZoneGroup" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/expand_btn.png" var="expand_btn"/>

<ul class="zones">
    <c:forEach var="zones" items="${zhd.zones}">
    <li>
        <div class="item zone">
            <img class=" dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                ${zones.name} : ${zones.value}${zones.measure}
            <div class="add_delete_wrapper">
                <div class="delete_btn">
                    <form action="${pageContext.request.contextPath}/projects/removeZone" method="post">
                        <input type="hidden" name="projectId" value="${projectId}">
                        <input type="hidden" name="zoneId" value="${zones.id}">
                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
                    </form>
                </div>
                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}" alt="show_update_forms">
            </div>


            <zone:addAdditional zones="${zones}"/>
            <zone:addSurplus zones="${zones}"/>
            <zone:updateZone zones="${zones}"/>
        </div>
        <ul class="work-group hidden ">


            <div class="item">
                <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                SISTEMA TEPLIY POL
                <div class="add_delete_wrapper">
                    <div class="delete_btn">
                        <form action="${pageContext.request.contextPath}/projects/removeZone" method="post">
                            <input type="hidden" name="projectId" value="${projectId}">
                            <input type="hidden" name="zoneId" value="${zones.id}">
                            <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
                        </form>
                    </div>
                    <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                         alt="show_update_forms">
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Add Work</div>
                    <form action="/projects/addWork" method="post">
                        <input type="hidden" name="parentId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                            </tr>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="name" placeholder="Enter name"></td>
                            </tr>
                            <tr>
                                <td>planedCost:</td>
                                <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
                            </tr>

                            <tr>
                                <td>work type:</td>
                                <td>

                                    <select name="workTypeId">
                                        <option value="7">probivka otverstiy mezdu sten</option>
                                        <option value="8">zavod gilzi v stenu</option>
                                        <option value="9">stroblenie sten</option>
                                        <option value="4">ukladka otraxateley i setki</option>
                                        <option value="5">prokladka trub</option>
                                        <option value="6">zalivka polov</option>
                                        <option value="1">probivka otverstiy mezdu sten</option>
                                        <option value="2">zavod vvdonogo provoda</option>
                                        <option value="3">probivka otverstiy v stene</option>
                                    </select>

                                </td>
                            </tr>

                            <tr>
                                <td>zone:</td>
                                <td>
                                    <form method="post">
                                        <select name="zoneId">
                                            <option value="1">pol1</option>
                                            <option value="2">stenaA</option>
                                            <option value="3">potolok</option>
                                            <option value="4">stenaB</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">

                    </form>
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Add WorkGroup</div>
                    <form action="/projects/addInnerWorkGroup" method="post">
                        <input type="hidden" name="parentId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="name" placeholder="Enter name"></td>
                            </tr>
                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">
                    </form>
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Update WorkGroupName</div>
                    <form action="/projects/updateWorkGroupName" method="post">
                        <input type="hidden" name="groupId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="newGroupName" value="OTOPLENIE"></td>
                            </tr>
                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">
                    </form>
                </div>

            </div>


            <ul class="works hidden">


                <ul class="group">
                    <li>
                        <div class="item">
                            ukladka otraxateley i setki
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="ukladka otraxateley i setki"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>


                <ul class="group">
                    <li>
                        <div class="item">
                            prokladka trub
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="prokladka trub"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>


                <ul class="group">
                    <li>
                        <div class="item">
                            zalivka polov
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="6">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="zalivka polov"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>

            </ul>
        </ul> <ul class="work-group hidden">


            <div class="item">
                <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                SISTEMA TEPLIY POL
                <div class="add_delete_wrapper">
                    <div class="delete_btn">
                        <form action="${pageContext.request.contextPath}/projects/removeZone" method="post">
                            <input type="hidden" name="projectId" value="${projectId}">
                            <input type="hidden" name="zoneId" value="${zones.id}">
                            <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
                        </form>
                    </div>
                    <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                         alt="show_update_forms">
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Add Work</div>
                    <form action="/projects/addWork" method="post">
                        <input type="hidden" name="parentId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                            </tr>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="name" placeholder="Enter name"></td>
                            </tr>
                            <tr>
                                <td>planedCost:</td>
                                <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
                            </tr>

                            <tr>
                                <td>work type:</td>
                                <td>

                                    <select name="workTypeId">
                                        <option value="7">probivka otverstiy mezdu sten</option>
                                        <option value="8">zavod gilzi v stenu</option>
                                        <option value="9">stroblenie sten</option>
                                        <option value="4">ukladka otraxateley i setki</option>
                                        <option value="5">prokladka trub</option>
                                        <option value="6">zalivka polov</option>
                                        <option value="1">probivka otverstiy mezdu sten</option>
                                        <option value="2">zavod vvdonogo provoda</option>
                                        <option value="3">probivka otverstiy v stene</option>
                                    </select>

                                </td>
                            </tr>

                            <tr>
                                <td>zone:</td>
                                <td>
                                    <form method="post">
                                        <select name="zoneId">
                                            <option value="1">pol1</option>
                                            <option value="2">stenaA</option>
                                            <option value="3">potolok</option>
                                            <option value="4">stenaB</option>
                                        </select>
                                    </form>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">

                    </form>
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Add WorkGroup</div>
                    <form action="/projects/addInnerWorkGroup" method="post">
                        <input type="hidden" name="parentId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="name" placeholder="Enter name"></td>
                            </tr>
                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">
                    </form>
                </div>
                <div class="controller hidden">
                    <div class="controller_name ">Update WorkGroupName</div>
                    <form action="/projects/updateWorkGroupName" method="post">
                        <input type="hidden" name="groupId" value="2">
                        <input type="hidden" name="projectId" value="33">
                        <table>
                            <tbody>
                            <tr>
                                <td>name:</td>
                                <td><input type="text" name="newGroupName" value="OTOPLENIE"></td>
                            </tr>
                            </tbody>
                        </table>
                        <input class="accept_changes_btn clickableIcon" type="image" src="/resources/img/done_btn.png">
                    </form>
                </div>

            </div>


            <ul class="works hidden">


                <ul class="group">
                    <li>
                        <div class="item">
                            ukladka otraxateley i setki
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="ukladka otraxateley i setki"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>


                <ul class="group">
                    <li>
                        <div class="item">
                            prokladka trub
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="prokladka trub"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>


                <ul class="group">
                    <li>
                        <div class="item">
                            zalivka polov
                            <div class="add_delete_wrapper">
                                <div class="add_delete_wrapper">
                                    <form action="/users_projects/deleteProject" method="post">
                                        <input type="hidden" name="projectId" value="33">
                                        <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                               alt="Delete">
                                    </form>
                                    <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                         alt="show_update_forms">
                                </div>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">UPDATE WORK</div>
                                <form action="file:///C:/projects/updateWork" method="post">
                                    <input type="hidden" name="id" value="6">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" value="zalivka polov"></td>
                                        </tr>
                                        <tr>
                                            <td>type:</td>
                                            <td><input type="text" name="type" value="probivka otverstiy v stene"></td>
                                        </tr>
                                        <tr>
                                            <td>work type:</td>
                                            <td>

                                                <select name="workTypeId">
                                                </select>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" value="3.45"></td>
                                        </tr>
                                        <tr>
                                            <td>zone:</td>
                                            <td>

                                                <select name="zoneId">
                                                    <option value="1">pol1</option>
                                                    <option value="2">stenaA</option>
                                                    <option value="3">potolok</option>
                                                    <option value="4">stenaB</option>
                                                </select>

                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accepth_changes_btn" type="image"
                                           src="file:///C:/resources/img/done_btn.png">

                                </form>
                            </div>

                        </div>
                        <ul class="subgroup">


                        </ul>
                    </li>
                </ul>

            </ul>
        </ul>

        <ul class="subZones">
            <zone:additional additional="${zones.additional}"/>
            <zone:surplus surplus="${zones.surplus}"/>
        </ul>

        </c:forEach>
    </li>
</ul>
