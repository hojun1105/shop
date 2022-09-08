<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/13
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <title>Title</title>

</head>
<body>
<h3>list</h3>

        <c:forEach var="p" items="${products}">
        <table border="1">
            <tr><th>상품번호</th><td>${p.num}</td></tr>
            <tr><th>상품이름</th><td><a href="${pageContext.request.contextPath}/product/ProdDetail?num=${p.num}">${p.name}</a></td></tr>
            <tr><th>가격</th><td>${p.price}</td></tr>
            <tr><th>amount</th><td>${p.amount}</td></tr>
            <tr><th>판매자</th><td>${p.seller}</td></tr>
            <tr><th>상품</th><td><img src="..${p.img1}" style="width:60px;height:60px"></td></tr>
            <c:if test="${sessionScope.id==p.seller}">
            <tr><td><button type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/product/ProdDel?num=${p.num}'">삭제</button></td></tr>
            </c:if>
        </table><br>
        </c:forEach>

</body>
</html>