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
<form method="post" action="">
    Sort:
    <select name="sort">
        <option>by percent</option>
        <option>by time</option>
    </select>


    <br/>
    Filters:
    <div>
       <div>
           percent
           <input type="number" min="0" max="100" name="leftPercentBoard" value="0">
           <input type="number" min="0" max="100" name="rightPercentBoard" value="100">
       </div>
        <div>
            time
            <input type="number" min="0" name="leftTimeBoard" value="0">
            <input type="number" min="0" name="rightTimeBoard" value="100">
        </div>
        <div>
            early withdrawal
            <select name="earlyWithdrawal">
                <option value="" selected hidden>Choose here</option>
                <option>yes</option>
                <option>no</option>
            </select>
        </div>
        <div>
            top up
            <select name="topUp">
                <option value="" selected hidden>Choose here</option>
                <option>yes</option>
                <option>no</option>
            </select>
        </div>
    </div>
    <input type="submit" value="apply">
    <table border="1">
        <tr>
            <%--<td>Bank</td>--%>
            <td>Percent</td>
            <td>Time(month)</td>
            <td>Early withdrawal</td>
            <td>Top up</td>
        </tr>
        <%--<c:forEach items="${banks}" var="bank">--%>
        <c:forEach items="${deposits}" var="deposit">
            <tr>
                    <%--<td>${bank.name}</td>--%>
                <td>${deposit.percent}</td>
                <td>${deposit.month}</td>
                <td>${deposit.earlyWithdrawal}</td>
                <td>${deposit.topUp}</td>
            </tr>
        </c:forEach>
        <%--</c:forEach>--%>
    </table>
</form>
</body>
</html>
