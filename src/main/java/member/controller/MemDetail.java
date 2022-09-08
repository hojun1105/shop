package member.controller;

import member.Member;
import member.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Detail", value = "/member/MemDetail")
public class MemDetail extends HttpServlet {

    //로그인한 id로 검색한 member객체를 request에 담아서 /member/detail.jsp로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Service service = new Service();
        String id = (String)session.getAttribute("id");
        Member m = service.getMember(id);
        request.setAttribute("m",m);
        request.setAttribute("path","/member/detail.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    // /member/detail.jsp페이지에서 수정버튼 누르면 post로 요청. 수정완료
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Service service = new Service();
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        Boolean mem_type = Boolean.parseBoolean(request.getParameter("mem_type"));
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");
        Member m = new Member(id,pwd,mem_type,tel,addr);
        System.out.println(m);
        service.editMember(m);
        response.sendRedirect("/shop/MainIndex.jsp");
    }
}
