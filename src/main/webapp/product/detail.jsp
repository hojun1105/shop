<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>상세</h3>
<table border="1">
<tr>
    <td><img src="..${p.img1}" style="width:100px;height:100px"></td>
    <td><img src="${pageContext.request.contextPath}${p.img2}" style="width:100px;height:100px"></td>
    <td><img src="..${p.img3}" style="width:100px;height:100px"></td>
</tr>
</table>
<form action="${pageContext.request.contextPath}/product/ProdDetail" method="post">
<table border="1">
    <tr><th>상품번호</th><td><input type="text" name="num" value="${p.num}" readonly></td></tr>
    <tr><th>판매자</th><td><input type="text" name="seller" value="${p.seller}" readonly></td></tr>
    <tr><th>info</th><td><textarea rows="15" cols="20" name="info">${p.info}</textarea></td></tr>
    <tr><th>상품이름</th><td><input type="text" name="name" value="${p.name}"></td></tr>
    <tr><th>가격</th><td><input type="number" name="price" value="${p.price}"></td></tr>
    <tr><th>amount</th><td><input type="number" name="amount" value="${p.amount}"></td></tr>
    <c:if test="${sessionScope.id == 'num'}">
    <tr><td><input type=submit value="수정완료"></td></tr>
    </c:if>
</table>
</form>
</body>
</html>
