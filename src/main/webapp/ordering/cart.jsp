<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br/>
    <c:forEach var="o" items="${lista}">
        <form action="${pageContext.request.contextPath}/ordering/OrderCart?num=${o.num}" method="post">
        <table border="1">
            <tr><th>num</th><td>${o.num}</td></tr>
            <tr><th>prod_num</th><td>${o.prod_num}</td></tr>
            <tr><th>w_date</th><td>${o.w_date}</td></tr>
            <tr><th>amount</th><td>${o.amount}"</td></tr>
            <tr><th>payment</th><td>${o.payment}"</td></tr>
            <tr><th>addr</th><td>${o.addr}</td></tr>
            <tr><td><button type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/ordering/OrderDel?num=${o.num}'">삭제</button></td></tr>
        </table><br>
            <a href="${pageContext.request.contextPath}/ordering/OrderPay?num=${o.num}">결제</a>
        </form>
    </c:forEach>
</body>
</html>
