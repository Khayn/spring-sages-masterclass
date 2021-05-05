<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@ include file="resources.jsp" %>
    <title><s:message code="index.errorPageTitle"</title>
</head>

<body>

<%@ include file="menu.jsp" %>
<div class="container">
    <s:message code="error" arguments="${message}"/>
</div>

</body>

</html>