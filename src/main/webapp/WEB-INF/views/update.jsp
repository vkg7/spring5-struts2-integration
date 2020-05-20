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
<div align="center">
    <h2>Edit User</h2>

    <s:form action="/user/registerUser.action" method="post">
        <table border="0">
            <%--<tr>
                <td>ID:</td>
                <td>${user.id}
                    <form:hidden path="id"/>
                </td>
            </tr>--%>
            <tr>
                <s:hidden path="id"/>
                <td><s:textfield name="userId" label="User Id"  maxlength="15" disabled="true"/></td>
                <td align="center"><s:actionerror name="userId" cssClass="error"/></td>
            </tr>
            <tr>
                <td><s:textfield name="userName" label="User Name" /></td>
                <td align="center"><s:actionerror name="userName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><s:textfield name="userRole" label="User Role" /></td>
                <td align="center"><s:actionerror name="userRole" cssClass="error"/></td>
            </tr>
            <tr>
                <td><s:textfield name="userStatus" label="User Status" /></td>
                <td align="center"><s:actionerror name="userStatus" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><s:submit value="Update" cssClass="button"/></td>
            </tr>
        </table>
    </s:form>
</div>
<div  id="error" align="center" cssClass="error">
    <p>Exception Name: <s:property value="exception" /> </p>
    <p>Exception Details: <s:property value="handlerMethod" /></p>
</div>
</body>
</html>