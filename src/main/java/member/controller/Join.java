package member.controller;

import member.Member;
import member.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Join", value = "/member/Join")
public class Join extends HttpServlet {
    //join form 실행
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path","/member/joinForm.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //join 완료
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        Boolean mem_type = Boolean.parseBoolean(request.getParameter("mem_type"));
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");

        Member m = new Member(id,pwd,mem_type,tel,addr);
        service.join(m);
        response.sendRedirect("/shop/member/Login");

    }
}
