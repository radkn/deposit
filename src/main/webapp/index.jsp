<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 28/02/2019
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposits page</title>
</head>
<body>
<c:if test="${true}">
    <h3>Error</h3>
</c:if>

<table>
    <c:forEach items="${deposits}" var="deposit">
        <tr>
            <td>${deposit.percent}</td>
            <td>${deposit.month}</td>
            <td>${deposit.earlyWithdrawal}</td>
            <td>${deposit.topUp}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
