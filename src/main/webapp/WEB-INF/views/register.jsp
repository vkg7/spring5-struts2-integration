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
    <h2>Add A User</h2>
    <s:form action="/user/registerUser.action" method="post" onsubmit="return checkForm(this)">
        <table border="0">
            <tr>
                <td><s:textfield name="userId" label="User Id" maxlength="15" placeholder="Enter a valid user id" required="true"/></td>
                <td align="center"><s:actionerror name="userId" cssClass="error"/></td>
            </tr>
            <tr>
                <td><s:textfield name="userName" label="User Name" required="true"/></td>
                <td align="center"><s:actionerror name="userName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><s:password name="password" label="Password" maxlength="16" placeholder="Enter a valid password" required="true"/></td>
                <td align="center"><s:actionerror name="password" cssClass="error"/></td>
            </tr>
           <%-- <tr>
                <td>Confirm Password:</td>
                <td><form:password onfocus="this.value=''" path="confirmPassword"/></td>
            </tr>--%>
            <tr>
                <td colspan="2" align="center"><s:submit value="Register" cssClass="button"/></td>
            </tr>
        </table>
    </s:form>
</div>
<div id="error" align="center" cssClass="error">
    <p>Exception Name: <s:property value="exception" /> </p>
    <p>Exception Details: <s:property value="handlerMethod" /></p>
</div>
</body>
</html>