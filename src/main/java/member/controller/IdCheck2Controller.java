package member.controller;

import member.Member;
import member.Service;
import org.json.simple.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IdCheck2Controller", value = "/member/IdCheck2Controller")
public class IdCheck2Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        String id = request.getParameter("id");
        Member m = service.getMember(id);

        boolean flag = false;
        if(m == null){
            flag=true;
        }

        JSONObject json = new JSONObject();//{}. 빈 json 객체 생성

        // json에 키와 값 추가
        json.put("flag", flag);
        json.put("id", id);

        String j = json.toJSONString(); //json을 문자열로 변환 {"flag":true, "id":"aaa"}
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append(j);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
