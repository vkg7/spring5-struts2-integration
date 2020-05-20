<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
<span><s:property value="message" /></span>
<h1>User List</h1>
<div style="overflow-x:auto;">
    <s:if test="listOfUsers.size() > 0">
    <table id="users" border="2" width="70%" cellpadding="2">
        <tr>
<%--            <th><label>Id</label></th>--%>
            <th><label>User Id</label></th>
            <th><label>User Name</label></th>
            <th><label>User Role</label></th>
            <th><label>User Status</label></th>
            <th><label>Date</label></th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <s:iterator value="listOfUsers" status="userStatus">
            <tr>
<%--                <td>${user.id}</td>--%>
                <td><s:property value="userId" /></td>
                <td><s:property value="userName" /></td>
                <td><s:property value="userRole" /></td>
                <td><s:property value="userStatus" /></td>
                <td><s:date name="date" format="dd/MM/yyyy" /></td>
                <td><a href="/user/update.action/<s:property value="id"/>">Edit</a></td>
                <td><a href="/user/delete.action/<s:property value="id"/>">delete</a></td>
            </tr>
        </s:iterator>
    </table>
    </s:if>
    <br/>
</div>
<div align="center">
    <s:url action="/user/showRegistrationPage.action" var="register" />
    <p><s:a href="%{register}"><label>Register New User</label></s:a></p>

    <s:url action="/login/showLoginPage.action" var="login" />
    <p><s:a href="%{login}"><label>Logout</label></s:a></p>
</div>
</body>
</html>