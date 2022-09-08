<%--
  Created by IntelliJ IDEA.
  User: jeonghojun
  Date: 2022/07/15
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        const j = (string) => {
            let val1 = document.getElementById('val1');
            let val2 = document.getElementById('val2');

            if(string=="name"){
                document.fom.action="${pageContext.request.contextPath}/product/ProdGetByName";
                val1.type="text";
                val2.type="hidden";}
            else if(string=="price"){
                document.fom.action="${pageContext.request.contextPath}/product/ProdGetByPrice";
                val1.type="number";
                val2.type="number";}
            else if(string=="seller"){
                document.fom.action="${pageContext.request.contextPath}/product/ProdGetBySeller";
                val1.type="text";
                val2.type="hidden";
            }
        }

    </script>
</head>
<body>
<form name="fom" action=" " method="post">
<table>
    <tr>
        <th>how</th>
        <td><input type="radio" name="search" value="name" onclick="j('name')">name</td>
        <td><input type="radio" name="search" value="price" onclick="j('price')">price</td>
        <td><input type="radio" name="search" value="seller" onclick="j('seller')">seller</td>
    </tr>
    <tr><input type="hidden" name="val1" id="val1"></tr>
    <tr><input type="hidden" name="val2" id="val2"></tr>
    <tr><input type="submit" value="검색"></tr>
</table>
</form>
</body>
</html>