<%--
  Created by IntelliJ IDEA.
  User: Vijay Gupta
  Date: 19-05-2020
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ERROR</title>
</head>
<body>
<h3>Debug Information:</h3>

Requested URL= <s:property value="url" /><br><br>

<p>Exception Name: <s:property value="exception" /> </p>
<p>Exception Details: <s:property value="handlerMethod" /></p>
</body>
</html>
