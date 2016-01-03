<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="user" required="true" type="ua.ksstroy.logic.user.UserData" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>

<spring:url value="/resources/img/arrow_drop_down.png" var="arrow_drop_down"/>
<spring:url value="/resources/img/add_btn.png" var="add_btn"/>
<spring:url value="/resources/img/delete_btn.png" var="delete_btn"/>
<spring:url value="/resources/img/show_updates_btn.png" var="show_update_forms_btn"/>
<spring:url value="/resources/img/done_btn.png" var="done_btn"/>


    <div class="item">
        <img class="dropdown_btn clickableIcon" src="${arrow_drop_down}" alt="Arrow">
        ${user.name}
        <div class="add_delete_wrapper">
            <form action="/projects/removeGroup" method="post">
                <input type="hidden" value="${user.id}">
                <input class="delete_btn clickableIcon" type="image" src="${delete_btn}" alt="Delete">
            </form>
            <img class="add_btn clickableIcon" src="${add_btn}" alt="Add">
            <img class="show_update_forms_btn clickableIcon" src="${show_update_forms_btn}"
                 alt="show_update_forms">
        </div>

        <div class="controller hidden">
            <div class="controller_name">UPDATE USER</div>
            <form action="/updateUser" method="post">
                <table>
                    <tbody>
                    <tr>
                        <td>name</td>
                        <td><input type="text" name="name" value="${user.name}"></td>
                    </tr>
                    <tr>
                        <td>role</td>
                        <td><input type="text" name="width" value="${user.role}"></td>
                    </tr>

                    </tbody>
                </table>
                <input class="accept_changes_btn clickableIcon" type="image" src="${done_btn}">
            </form>
        </div>
    </div>

