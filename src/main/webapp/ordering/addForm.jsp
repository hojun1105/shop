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
<%--<body onload="init();">--%>
<%--<script language="JavaScript">--%>

<%--    var sell_price;--%>
<%--    var amount;--%>

<%--    function init () {--%>
<%--        sell_price = document.form.sell_price.value;--%>
<%--        amount = document.form.amount.value;--%>
<%--        document.form.sum.value = sell_price;--%>
<%--        change();--%>
<%--    }--%>

<%--    function add () {--%>
<%--        hm = document.form.amount;--%>
<%--        sum = document.form.sum;--%>
<%--        hm.value ++ ;--%>

<%--        sum.value = parseInt(hm.value) * sell_price;--%>
<%--    }--%>

<%--    function del () {--%>
<%--        hm = document.form.amount;--%>
<%--        sum = document.form.sum;--%>
<%--        if (hm.value > 1) {--%>
<%--            hm.value -- ;--%>
<%--            sum.value = parseInt(hm.value) * sell_price;--%>
<%--        }--%>
<%--    }--%>

<%--    function change () {--%>
<%--        hm = document.form.amount;--%>
<%--        sum = document.form.sum;--%>

<%--        if (hm.value < 0) {--%>
<%--            hm.value = 0;--%>
<%--        }--%>
<%--        sum.value = parseInt(hm.value) * sell_price;--%>
<%--    }--%>
<%--</script>--%>
<form action="${pageContext.request.contextPath}/ordering/OrderAdd" method="post">
    <table border="1">
        <tr><th>상품번호</th><td><input type="text" name="prod_num" value="${p.num}" readonly></td></tr>
        <tr><th>판매자</th><td><input type="text" name="seller" value="${p.seller}" readonly></td></tr>
        <tr><th>info</th><td><textarea rows="15" cols="20" name="info" readonly>${p.info}</textarea></td></tr>
        <tr><th>상품이름</th><td><input type="text" name="name" value="${p.name}"readonly></td></tr>
        <tr><th>가격</th><td><input type="number" name="price" value="${p.price}" readonly></td></tr>
        <tr><th>수량</th><td><input type="number" name="amount" value="${p.amount}" readonly></td></tr><br><br/><br>

        <tr><th>consumer</th><td><input type="text" name="consumer" value="${sessionScope.id}" readonly></td></tr>
        <tr><th>addr</th><td><input type="text" name="addr"></td></tr>
        <tr><th>payment</th><td><input type="number" name="payment"></td></tr>
        <tr><th>order_amount</th><td><input type="number" name="order_amount"></td></tr>
<%--        <form name="form" method="get">--%>
<%--    <tr><th>수량</th><td><input type=hidden name="sell_price" value="${p.price}}">--%>
<%--        <input type="text" name="order_amount" value="1" size="3" onchange="change();">--%>
<%--        <input type="button" value=" + " onclick="add();">--%>
<%--        <input type="button" value=" - " onclick="del();"><br></td></tr>--%>
<%----%>
<%--    <tr><th>금액</th><td><input type="text" name="sum" size="11" readonly>원</td></tr>--%>
<%--        </form>--%>
        <tr><td><input type=submit value="주문"></td></tr>
    </table>
</form>
    <a href="${pageContext.request.contextPath}/product/ProdList">취소</a>
</body>
</html>
