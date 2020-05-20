<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
<span><s:property value="message" /></span>
<div align="center">
    <s:url action="/login/showRegistrationPage.action" var="register" />
    <p><s:a href="%{register}"><label>Register New User</label></s:a></p>
    <s:url action="/login/showLoginPage.action" var="login" />
    <p><s:a href="%{login}"><label>Logout</label></s:a></p>

    <%--<p><a href="views/register.jsp"><label>Register New User</label></a></p>
    <p><a href="views/login.jsp"><label>Logout</label></a></p>--%>
</div>
</body>
</html>