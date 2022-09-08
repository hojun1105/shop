<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/14
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="o" items="${list}">
    <form action="${pageContext.request.contextPath}/ordering/OrderCart?num=${o.num}" method="post">
    <table border="1">
    <tr><th>num</th><td><input type="number" name="num" value="${o.num}" readonly></td></tr>
    <tr><th>prod_num</th><td>${o.prod_num}</td></tr>
    <tr><th>amount</th><td><input type="number" name="amount" value="${o.amount}"></td></tr>
    <tr><th>w_date</th><td>${o.w_date}</td></tr>
    <tr><th>payment</th><td><input type="number" name="payment" value="${o.payment}"></td></tr>
    <tr><th>addr</th><td><input type="text" name="addr" value="${o.addr}"></td></tr>
    <tr><td><input type="submit" value="수정"></td></tr>
    <tr><td><button type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/ordering/OrderDel?num=${o.num}'">삭제</button></td></tr>
    </table><br>
    <a href="${pageContext.request.contextPath}/ordering/OrderPay?num=${o.num}">결제</a>
    </form>
</c:forEach>
</body>
</html>