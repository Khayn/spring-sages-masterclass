<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <%@ include file="resources.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
    <h1><s:message code="index.addProductLabel"/></h1>

    <sf:form modelAttribute="productTransferObject" method="post">

        <div class="form-group">
            <label for="name"><s:message code="index.productName"/> </label>
            <sf:input path="name" class="form-control"/>
            <sf:errors path="name"/>
        </div>

        <div class="form-group">
            <label for="description"><s:message code="index.productDesc"/> </label>
            <sf:input path="description" class="form-control"/>
            <sf:errors path="description"/>
        </div>

        <div class="form-group">
            <label for="type"><s:message code="index.productType"/> </label>
            <sf:input path="type" class="form-control"/>
            <sf:errors path="type"/>
        </div>

        <div class="form-group">
            <label for="price"><s:message code="index.productPrice"/> </label>
            <sf:input path="price" class="form-control"/>
            <sf:errors path="price"/>
        </div>

        <button type="submit" class="btn btn-primary"><s:message code="index.saveProduct"/></button>
    </sf:form>

</div>

</body>
</html>