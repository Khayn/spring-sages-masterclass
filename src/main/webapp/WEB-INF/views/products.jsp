<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
    <%@ include file="resources.jsp" %>
</head>
<body>

<%@ include file="menu.jsp" %>

<div class="container">
    <c:choose>
        <c:when test="${products.totalPages > 0}">
            <h1><s:message code="index.AllProductsLabel"/></h1>
            <table class="table">
                <thead>
                <tr>
                    <th><s:message code="index.productName"/></th>
                    <th><s:message code="index.productDesc"/></th>
                    <th><s:message code="index.productType"/></th>
                    <th><s:message code="index.productPrice"/></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="product" items="${products.data}">
                    <tr>
                        <td>
                                ${product.name}
                        </td>
                        <td>
                                ${product.description}
                        </td>
                        <td>
                                ${product.type}
                        </td>
                        <td>
                                ${product.price}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

            <c:if test="${products.pageNumber > 0}">
                <a href="show-products.html?pageNumber=${products.pageNumber -1}">
                    <s:message code="index.pageBack"/></a>
            </c:if>

            <c:if test="${products.pageNumber+1 < products.totalPages}">
                <a href="show-products.html?pageNumber=${products.pageNumber +1}" class="float-right">
                    <s:message code="index.pageNext"/></a>
            </c:if>

            <div class="text-center">${products.pageNumber +1}/${products.totalPages}</div>

        </c:when>
        <c:otherwise>
            <div class="text-center"><s:message code="index.noProductsLabel"/></div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>