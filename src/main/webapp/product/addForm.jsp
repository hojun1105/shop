<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/13
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>목록 작성 폼</h3>
<form action="${pageContext.request.contextPath}/product/ProdAdd" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr><th>판매자</th><td><input type="text" name="seller" value="${sessionScope.id}" readonly></td></tr>
        <tr><th>상품명</th><td><input type="text" name="name"></td></tr>
        <tr><th>info</th><td><textarea rows="15" cols="20" name="content"></textarea></td></tr>
        <tr><th>price</th><td><input type="number" name="price" ></td></tr>
        <tr><th>amount</th><td><input type="number" name="amount" ></td></tr>
        <tr><th>img1</th><td><input type="file" name="img1" ></td></tr>
        <tr><th>img2</th><td><input type="file" name="img2" ></td></tr>
        <tr><th>img3</th><td><input type="file" name="img3" ></td></tr>
        <tr><th>save</th><td><input type="submit" value="write" ></td></tr>
    </table>
    <a href="${pageContext.request.contextPath}/product/ProdList">취소</a>
</form>
</body>
</html>
