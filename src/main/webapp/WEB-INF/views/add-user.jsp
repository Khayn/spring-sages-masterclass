<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <%@ include file="resources.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
    <h1><s:message code="index.addUserLabel"/></h1>

    <sf:form modelAttribute="user" method="post">

        <div class="form-group">
            <label for="firstName"><s:message code="index.userFirstName"/> </label>
            <sf:input path="firstName" class="form-control"/>
            <sf:errors path="firstName"/>
        </div>

        <div class="form-group">
            <label for="lastName"><s:message code="index.userLastName"/> </label>
            <sf:input path="lastName" class="form-control"/>
            <sf:errors path="lastName"/>
        </div>

        <div class="form-group">
            <label for="email"><s:message code="index.userEmail"/> </label>
            <sf:input path="email" class="form-control"/>
            <sf:errors path="email"/>
        </div>

        <button type="submit" class="btn btn-primary"><s:message code="index.saveUser"/></button>
    </sf:form>

</div>

</body>
</html>