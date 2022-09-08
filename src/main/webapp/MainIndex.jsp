<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/13
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>시작</h3>
<c:if test="${empty sessionScope.id}">
    <a href="${pageContext.request.contextPath}/member/Login">로그인</a>
</c:if>
<c:if test="${not empty sessionScope.id}">
    <form action="${pageContext.request.contextPath}/member/MemDelete" method="post">
    <a href="${pageContext.request.contextPath}/member/MemDelete">로그아웃</a>
    <a href="${pageContext.request.contextPath}/member/MemDetail">내 정보</a>
        <input type="submit" value="탈퇴"></form>
    <c:if test="${sessionScope.mem_type}">
        <h3>판매자</h3>
        <table border="1">
            <tr><td><a href="${pageContext.request.contextPath}/product/ProdList">리스트</a></td></tr>
            <tr><td><a href="${pageContext.request.contextPath}/product/ProdAdd">추가</a></td></tr>
            <tr><td><a href="${pageContext.request.contextPath}/product/ProdGetByName">검색</a></td></tr>
            </table>
    </c:if>
    <c:if test="${not sessionScope.mem_type}">
        <h3>구매자</h3>
        <table border="1">
            <tr><td><a href="${pageContext.request.contextPath}/product/ProdList"> 리스트</a></td></tr>
            <tr><td><a href="${pageContext.request.contextPath}/ordering/OrderList?ispay=true">결제목록</a></td></tr>
            <tr><td><a href="${pageContext.request.contextPath}/ordering/OrderCart">장바구니</a></td></tr>
            <tr><td><a href="${pageContext.request.contextPath}/product/ProdGetByName">검색</a></td></tr>
        </table>
    </c:if>
</c:if>

<c:if test="${not empty path and path!=''}">
    <jsp:include page="${path}"></jsp:include>
</c:if>
</body>
</html>
