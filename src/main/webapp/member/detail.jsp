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
    <script type="text/javascript">
        window.onload = () => {
            let radio = null;
            if(${m.mem_type}){
                radio = document.getElementById("mem2");
            }else{
                radio = document.getElementById("mem1");
            }
            radio.checked = true;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/MemDetail" method="post">
    <table>
        <tr><th>id</th><td><input type="text" name="id" value="${m.id}" readonly></td></tr>
        <tr><th>pwd</th><td><input type="text" name="pwd" value="${m.pwd}"></td></tr>
        <tr><th>tel</th><td><input type="text" name="tel" value="${m.tel}"></td></tr>
        <tr><th>addr</th><td><input type="text" name="addr" value="${m.addr}"></td></tr>
        <tr><th>가입형태</th><td><input type="radio" name="mem_type" id="mem1" disabled>구매자</td>
            <input type="radio" name="mem_type" id="mem2" disabled>판매자></tr>
        <tr><td><input type="submit" value="수정"></td></tr>
    </table>
    <a href="${pageContext.request.contextPath}/MainIndex.jsp">메뉴로 돌아감</a>
</form>
</body>
</html>
