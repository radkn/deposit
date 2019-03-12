<%--
  Created by IntelliJ IDEA.
  User: Kostia
  Date: 28/02/2019
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="lenguage" value="${not empty param.lenguage ? param.lenguage : not empty lenguage ? lenguage : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${lenguage}" scope="request"/>
<fmt:setBundle basename="view"/>
<html lang="language">
<head>
    <title><fmt:message key="pageTitle"/></title>
</head>
<body>
<form method="post" action="">
    <fmt:message key="sortStr"/>
    <select name="sort">
        <option value="by percent"><fmt:message key="byPercent"/></option>
        <option value="by time"><fmt:message key="byTime"/></option>
    </select>


    <br/>
    <fmt:message key="filtersStr"/>
    <div>
       <div>
           <fmt:message key="percentStr"/>
           <input type="number" min="0" max="100" name="leftPercentBoard" value="0">
           <input type="number" min="0" max="100" name="rightPercentBoard" value="100">
       </div>
        <div>
            <fmt:message key="timeStr"/>
            <input type="number" min="0" name="leftTimeBoard" value="0">
            <input type="number" min="0" name="rightTimeBoard" value="100">
        </div>
        <div>
            <fmt:message key="earlyWithdrawalStr"/>
            <select name="earlyWithdrawal">
                <option value="" selected hidden>Choose here</option>
                <option><fmt:message key="yes"/></option>
                <option><fmt:message key="no"/></option>
            </select>
        </div>
        <div>
            <fmt:message key="topUpStr"/>
            <select name="topUp">
                <option value="" selected hidden>Choose here</option>
                <option><fmt:message key="yes"/></option>
                <option><fmt:message key="no"/></option>
            </select>
        </div>
    </div>
    <input type="submit" value="apply">
    <h3><fmt:message key="depositTableName"/></h3>
    <table border="1">
        <tr>
            <td><fmt:message key="bankStr"/></td>
            <td><fmt:message key="percentStr"/></td>
            <td><fmt:message key="timeStr"/></td>
            <td><fmt:message key="earlyWithdrawalStr"/></td>
            <td><fmt:message key="topUpStr"/></td>
        </tr>
        <c:forEach items="${deposits}" var="deposit">
            <tr>
                <td>${deposit.bank_id}</td>
                <td>${deposit.percent}</td>
                <td>${deposit.month}</td>
                <td>${deposit.earlyWithdrawal ? "yes" : "no"}</td>
                <td>${deposit.topUp ? "yes" : "no"}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
