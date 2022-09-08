<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/13
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>로그인</h3>
<form action="${pageContext.request.contextPath}/member/Login" method="post">
<table border="1">
    <tr><th>id</th><td><input type="text" name="id"></td></tr>
    <tr><th>pwd</th><td><input type="text" name="pwd"></td></tr>
    <tr><td><input type="submit" value="로그인"></td></tr>
    <tr><a href="${pageContext.request.contextPath}/member/Join">회원가입</a></tr>
</table>
</form>

</body>
</html>
