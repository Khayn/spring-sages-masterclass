<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@ include file="resources.jsp" %>
    <title><s:message code="index.AllUsersLabel"/></title>
</head>

<body>

<%@ include file="menu.jsp" %>

<div class="container">
    <c:choose>
        <c:when test="${users.totalPages > 0}">
            <h1><s:message code="index.AllUsersLabel"/></h1>
            <table class="table">
                <thead>
                <tr>
                    <th><s:message code="index.userFirstName"/></th>
                    <th><s:message code="index.userLastName"/></th>
                    <th><s:message code="index.userEmail"/></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${users.data}">
                    <tr>
                        <td>
                                ${user.firstName}
                        </td>
                        <td>
                                ${user.lastName}
                        </td>
                        <td>
                                ${user.email}
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

            <c:if test="${users.pageNumber > 0}">
                <a href="show-users.html?pageNumber=${users.pageNumber -1}">
                    <s:message code="index.pageBack"/></a>
            </c:if>

            <c:if test="${users.pageNumber+1 < users.totalPages}">
                <a href="show-users.html?pageNumber=${users.pageNumber +1}" class="float-right">
                    <s:message code="index.pageNext"/></a>
            </c:if>

            <div class="text-center">${users.pageNumber +1}/${users.totalPages}</div>

        </c:when>
        <c:otherwise>
            <div class="text-center"><s:message code="index.noUsersLabel"/></div>
        </c:otherwise>
    </c:choose>
</div>

</body>

</html>