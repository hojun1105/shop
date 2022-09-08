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
    <script>
        const a = () => {
            //비동기 요청 객체 생성
            const xhttp = new XMLHttpRequest();

            //핸들러 등록: 요청에 대한 응답이 왔을때 자동 호출될 함수 등록
            xhttp.onload=function(){
                if(xhttp.status==200){
                    let resVal =  xhttp.responseText;//텍스트 응답
                    let obj = JSON.parse(resVal);//응답값을 json으로 파싱
                    let msg = "사용불가능한 아이디";
                    if(obj.flag) {
                        msg = "사용가능한 아이디";
                    } else{
                        f1.id.value ="";
                    }
                    let res = document.getElementById("res");
                    res.innerHTML=msg;
                }else {
                    alert(xhttp.status);
                }
            }
            let id = f1.id.value;
            //요청 객체 오픈. 요청 설정, 서버 페이지 경로 // true 비동기
            xhttp.open("POST","/shop/member/IdCheck2Controller",true);
            xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=utf-8');
            let param = "id="+id;
            //요청 전송
            xhttp.send(param);
        }
    </script>
</head>
<body>
<h3>회원가입</h3>
<form action="/shop/member/Join" method="post" name="f1">
<table border="1">
    <tr><th>id</th><td><input type="text" name="id">
        <input type="button" value="중복체크" onclick="a()">
        <span id="res"></span></td>
    </tr>
    <tr><th>pwd</th><td><input type="pwd" name="pwd"></td></tr>
    <tr><th>tel</th><td><input type="text" name="tel"></td></tr>
    <tr><th>addr</th><td><input type="text" name="addr"></td></tr>
    <tr><th>가입종류</th>
        <td>
            <input type="radio" name="mem_type" value="false">구매자
            <input type="radio" name="mem_type" value="true">판매자
        </td>
    </tr>
    <tr><td><input type="submit" value="가입"></td></tr>
</table>
</form>
</body>
</html>
