<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/14
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="o" items="${list}">
    <table border="1">
        <tr><th>주문번호</th><td>${o.num}</td></tr>
        <tr><th>상품번호</th><td>${o.prod_num}</td></tr>
        <tr><th>payment</th><td>${o.payment}</td></tr>
        <tr><th>amount</th><td>${o.amount}</td></tr>
        <tr><th>w_date</th><td>${o.w_date}</td></tr>
        <tr><th>consumer</th><td>${o.consumer}</td></tr>
        <tr><th>addr</th><td>${o.addr}</td></tr>
        <tr><td><button type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/ordering/OrderDel?num=${o.num}'">삭제</button></td></tr>
    </table><br>
</c:forEach>

</body>
</html>
