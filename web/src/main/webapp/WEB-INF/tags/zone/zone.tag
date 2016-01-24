<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="zhd" required="true"
              type="ua.ksstroy.logic.zonegroup.ZoneHierarchyData" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zone" tagdir="/WEB-INF/tags/zone" %>
<%@ taglib prefix="group" tagdir="/WEB-INF/tags/group" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>

<ul class="zones">
    <c:forEach var="zones" items="${zhd.zones}">
    <li>
        <div class="item">
            <img class=" dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                ${zones.name}
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
        <ul class="subgroups" style="">


            <ul class="group" style="">


                <div class="item">
                    <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                    ELECTRICA
                                        <div class="add_delete_wrapper">
                        <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                            <input type="hidden" name="id" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                   alt="Delete">
                        </form>

                        <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                        <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                             alt="show_update_forms">
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Add Work</div>
                        <form action="http://localhost:8080/projects/addWork" method="post">
                            <input type="hidden" name="parentId" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <table>
                                <tbody>
                                <tr>
                                    <td>name:</td>
                                    <td><input type="text" name="name" placeholder="Enter name"></td>
                                </tr>
                                <tr>
                                    <td>type id:</td>
                                    <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                </tr>
                                <tr>
                                    <td>planedCost:</td>
                                    <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
                                </tr>

                                <tr>
                                    <td>perspectiveCost:</td>
                                    <td><input type="text" name="perspectiveCost" placeholder="Enter perspectiveCost">
                                    </td>
                                </tr>
                                <tr>
                                    <td>closedCost:</td>
                                    <td><input type="text" name="closedCost" placeholder="Enter closedCost"></td>
                                </tr>
                                <tr>
                                    <td>dealCost:</td>
                                    <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                </tr>
                                </tbody>
                            </table>
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Add WorkGroup</div>
                        <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
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
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Update WorkGroupName</div>
                        <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                            <input type="hidden" name="groupId" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <table>
                                <tbody>
                                <tr>
                                    <td>name:</td>
                                    <td><input type="text" name="newGroupName" value="group1_lvl_a"></td>
                                </tr>
                                </tbody>
                            </table>
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>

                </div>
                <ul class="subgroups">
                    <ul class="group">
                        <div class="item">
                            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                           UTEPLENIE PENOPLASTOM
                            <div class="add_delete_wrapper">
                                <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                                    <input type="hidden" name="id" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <input class="delete_btn clickableIcon" type="image"
                                           src="${delete_btn}" alt="Delete">
                                </form>

                                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                     alt="show_update_forms">
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add Work</div>
                                <form action="http://localhost:8080/projects/addWork" method="post">
                                    <input type="hidden" name="parentId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        <tr>
                                            <td>type id:</td>
                                            <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" placeholder="Enter planedCost">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>perspectiveCost:</td>
                                            <td><input type="text" name="perspectiveCost"
                                                       placeholder="Enter perspectiveCost"></td>
                                        </tr>
                                        <tr>
                                            <td>closedCost:</td>
                                            <td><input type="text" name="closedCost" placeholder="Enter closedCost">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>dealCost:</td>
                                            <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add WorkGroup</div>
                                <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
                                    <input type="hidden" name="parentId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Update WorkGroupName</div>
                                <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                                    <input type="hidden" name="groupId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="newGroupName" value="group3_lvl_b"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>

                        </div>
                        <ul class="subgroups">


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        Work_ziro
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="1">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="Work_ziro"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_1"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover1 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_one
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="2">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_one"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover2 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_two
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="3">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_two"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover3 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="3">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="3">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                               zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>

                        </ul>
                    </ul>
                    <ul class="group">


                        <div class="item">
                            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                           UTEPLENIE POLISTIROLOM
                            <div class="add_delete_wrapper">
                                <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                                    <input type="hidden" name="id" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <input class="delete_btn clickableIcon" type="image"
                                           src="${delete_btn}" alt="Delete">
                                </form>

                                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                     alt="show_update_forms">
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add Work</div>
                                <form action="http://localhost:8080/projects/addWork" method="post">
                                    <input type="hidden" name="parentId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        <tr>
                                            <td>type id:</td>
                                            <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" placeholder="Enter planedCost">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>perspectiveCost:</td>
                                            <td><input type="text" name="perspectiveCost"
                                                       placeholder="Enter perspectiveCost"></td>
                                        </tr>
                                        <tr>
                                            <td>closedCost:</td>
                                            <td><input type="text" name="closedCost" placeholder="Enter closedCost">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>dealCost:</td>
                                            <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add WorkGroup</div>
                                <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
                                    <input type="hidden" name="parentId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Update WorkGroupName</div>
                                <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                                    <input type="hidden" name="groupId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="newGroupName" value="group4_lvl_b"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>

                        </div>
                        <ul class="subgroups">


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_tree
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="4">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_tree"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_3"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover4 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_four
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="5">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_four"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_3"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover5 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>

                        </ul>
                    </ul>
                </ul>
            </ul>
        </ul>    <ul class="subgroups" style="">


            <ul class="group" style="">


                <div class="item">
                    <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                    UTEPLENIE
                                        <div class="add_delete_wrapper">
                        <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                            <input type="hidden" name="id" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <input class="delete_btn clickableIcon" type="image" src="${delete_btn}"
                                   alt="Delete">
                        </form>

                        <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                        <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                             alt="show_update_forms">
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Add Work</div>
                        <form action="http://localhost:8080/projects/addWork" method="post">
                            <input type="hidden" name="parentId" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <table>
                                <tbody>
                                <tr>
                                    <td>name:</td>
                                    <td><input type="text" name="name" placeholder="Enter name"></td>
                                </tr>
                                <tr>
                                    <td>type id:</td>
                                    <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                </tr>
                                <tr>
                                    <td>planedCost:</td>
                                    <td><input type="text" name="planedCost" placeholder="Enter planedCost"></td>
                                </tr>

                                <tr>
                                    <td>perspectiveCost:</td>
                                    <td><input type="text" name="perspectiveCost" placeholder="Enter perspectiveCost">
                                    </td>
                                </tr>
                                <tr>
                                    <td>closedCost:</td>
                                    <td><input type="text" name="closedCost" placeholder="Enter closedCost"></td>
                                </tr>
                                <tr>
                                    <td>dealCost:</td>
                                    <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                </tr>
                                </tbody>
                            </table>
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Add WorkGroup</div>
                        <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
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
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>
                    <div class="controller hidden">
                        <div class="controller_name">Update WorkGroupName</div>
                        <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                            <input type="hidden" name="groupId" value="2">
                            <input type="hidden" name="projectId" value="33">
                            <table>
                                <tbody>
                                <tr>
                                    <td>name:</td>
                                    <td><input type="text" name="newGroupName" value="group1_lvl_a"></td>
                                </tr>
                                </tbody>
                            </table>
                            <input class="accept_changes_btn clickableIcon" type="image"
                                   src="./work_files/done_btn.png">
                        </form>
                    </div>

                </div>
                <ul class="subgroups">


                    <ul class="group">


                        <div class="item">
                            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                           UTEPLENIE PENOPLASTOM
                            <div class="add_delete_wrapper">
                                <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                                    <input type="hidden" name="id" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <input class="delete_btn clickableIcon" type="image"
                                           src="${delete_btn}" alt="Delete">
                                </form>

                                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                     alt="show_update_forms">
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add Work</div>
                                <form action="http://localhost:8080/projects/addWork" method="post">
                                    <input type="hidden" name="parentId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        <tr>
                                            <td>type id:</td>
                                            <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" placeholder="Enter planedCost">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>perspectiveCost:</td>
                                            <td><input type="text" name="perspectiveCost"
                                                       placeholder="Enter perspectiveCost"></td>
                                        </tr>
                                        <tr>
                                            <td>closedCost:</td>
                                            <td><input type="text" name="closedCost" placeholder="Enter closedCost">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>dealCost:</td>
                                            <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add WorkGroup</div>
                                <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
                                    <input type="hidden" name="parentId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Update WorkGroupName</div>
                                <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                                    <input type="hidden" name="groupId" value="4">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="newGroupName" value="group3_lvl_b"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>

                        </div>
                        <ul class="subgroups">


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        Work_ziro
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="1">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="Work_ziro"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_1"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="1">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover1 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_one
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="2">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_one"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="2">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover2 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="1">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_two
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="3">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_two"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_2"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="3">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover3 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="3">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="3">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                               zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="2">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>

                        </ul>
                    </ul>
                    <ul class="group">


                        <div class="item">
                            <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
                           UTEPLENIE POLISTIROLOM
                            <div class="add_delete_wrapper">
                                <form action="http://localhost:8080/projects/removeWorkGroup" method="post">
                                    <input type="hidden" name="id" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <input class="delete_btn clickableIcon" type="image"
                                           src="${delete_btn}" alt="Delete">
                                </form>

                                <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                                     alt="show_update_forms">
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add Work</div>
                                <form action="http://localhost:8080/projects/addWork" method="post">
                                    <input type="hidden" name="parentId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        <tr>
                                            <td>type id:</td>
                                            <td><input type="text" name="workTypeId" placeholder="Enter type id"></td>
                                        </tr>
                                        <tr>
                                            <td>planedCost:</td>
                                            <td><input type="text" name="planedCost" placeholder="Enter planedCost">
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>perspectiveCost:</td>
                                            <td><input type="text" name="perspectiveCost"
                                                       placeholder="Enter perspectiveCost"></td>
                                        </tr>
                                        <tr>
                                            <td>closedCost:</td>
                                            <td><input type="text" name="closedCost" placeholder="Enter closedCost">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>dealCost:</td>
                                            <td><input type="text" name="dealCost" placeholder="Enter dealCost"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Add WorkGroup</div>
                                <form action="http://localhost:8080/projects/addInnerWorkGroup" method="post">
                                    <input type="hidden" name="parentId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="name" placeholder="Enter name"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>
                            <div class="controller hidden">
                                <div class="controller_name">Update WorkGroupName</div>
                                <form action="http://localhost:8080/projects/updateWorkGroupName" method="post">
                                    <input type="hidden" name="groupId" value="5">
                                    <input type="hidden" name="projectId" value="33">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>name:</td>
                                            <td><input type="text" name="newGroupName" value="group4_lvl_b"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <input class="accept_changes_btn clickableIcon" type="image"
                                           src="./work_files/done_btn.png">
                                </form>
                            </div>

                        </div>
                        <ul class="subgroups">


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_tree
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="4">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_tree"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_3"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="4">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover4 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="4">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>


                            <ul class="group">
                                <li>
                                    <div class="item">
                                        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}"
                                             alt="Arrow">
                                        work_four
                                        <div class="add_delete_wrapper">
                                            <form action="http://localhost:8080/projects/removeWork" method="post">
                                                <input type="hidden" name="projectId" value="33">
                                                <input type="hidden" name="id" value="5">
                                                <input class="delete_btn clickableIcon" type="image"
                                                       src="${delete_btn}" alt="Delete">
                                            </form>
                                            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
                                            <img class="show_update_forms_btn clickableIcon"
                                                 src="${show_update_forms_btn}" alt="show_update_forms">
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">UPDATE WORK</div>
                                            <form action="http://localhost:8080/projects/updateWork" method="post">
                                                <input type="hidden" name="id" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>name:</td>
                                                        <td><input type="text" name="name" value="work_four"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>type:</td>
                                                        <td><input type="text" name="type" value="worktype_3"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>planedCost:</td>
                                                        <td><input type="text" name="planedCost" value="1.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>perspectiveCost:</td>
                                                        <td><input type="text" name="perspectiveCost" value="2.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>closedCost:</td>
                                                        <td><input type="text" name="closedCost" value="3.0"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>dealCost:</td>
                                                        <td><input type="text" name="dealCost" value="4.0"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accepth_changes_btn" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Cover</div>
                                            <form action="http://localhost:8080/projects/addCoverToWork" method="post">
                                                <input type="hidden" name="workId" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Description:</td>
                                                        <td><input type="text" name="description"
                                                                   placeholder="Enter description"></td>
                                                    </tr>

                                                    <tr>
                                                        <td>Date:</td>
                                                        <td><input type="text" name="date" placeholder="Enter date">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                        <div class="controller hidden">
                                            <div class="controller_name">Add Adjustment</div>
                                            <form action="http://localhost:8080/projects/addAdjustmentToWork"
                                                  method="post">
                                                <input type="hidden" name="workId" value="5">
                                                <input type="hidden" name="projectId" value="33">
                                                <table>
                                                    <tbody>
                                                    <tr>
                                                        <td>value:</td>
                                                        <td><input type="text" name="value" placeholder="Enter value">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>is absolute?:</td>
                                                        <td><input type="text" name="isAbsolute"
                                                                   placeholder="Enter absolute"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <input class="accept_changes_btn clickableIcon" type="image"
                                                       src="./work_files/done_btn.png">
                                            </form>
                                        </div>
                                    </div>
                                    <ul class="subgroup">


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                cover5 value: 12.0%
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                adjustment value: 23.0$
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>
                                            </div>
                                        </li>


                                        <li>
                                            <div class="item">
                                                <img class="dropdown_btn clickableIcon"
                                                     src="${arrow_drop_down}" alt="Arrow">
                                                zone: pol1
                                                <div class="add_delete_wrapper">
                                                    <form action="" method="post">
                                                        <input type="hidden" name="projectId" value="33">
                                                        <input type="hidden" name="id" value="5">

                                                    </form>

                                                </div>

                                            </div>
                                        </li>

                                    </ul>
                                </li>
                            </ul>

                        </ul>
                    </ul>
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
