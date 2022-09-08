package member.controller;

import member.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemDelete", value = "/member/MemDelete")
public class MemDelete extends HttpServlet {
    //로그아웃
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("/shop/member/Login");
    }
    //탈퇴
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        HttpSession session = request.getSession(false);
//        String id = request.getParameter("id");
        String id = (String)session.getAttribute("id");
        service.deleteMember(id);
        session.invalidate();
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);

    }
}
